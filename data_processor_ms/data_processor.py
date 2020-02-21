import pandas
import re
from sqlalchemy import create_engine
import requests
from threading import Thread
import schedule
from time import sleep
import data_processor_campi
from kafka_manager import sendQuantidadeAlunosComBolsaDesistentes, sendSituacaoAlunoCanpiCurso, sendQuantidadeAlunosLimparamMatriculas
import logging

logging.basicConfig(format='%(asctime)s - %(levelname)s : %(message)s', filename='/app/logs/kafka_manager.log',
                            datefmt='%m/%d/%Y %I:%M:%S %p', level=logging.INFO)
log = logging.getLogger()

log.info("data_processor.py")

def download_dados():
    log.info('Iniciando download dos dados.\n...')
    nomes = ['alunos.csv', 'campi.csv', 'bolsas.csv', 'projetos-extensao.csv', 'projetos-pesquisa.csv']
    reqs = [requests.get('https://dados.ifpb.edu.br/dataset/d02eb6b8-5745-4436-ae22-ef1c182897d9/resource/29c2b593-ed14-4b73-b30c-d6135f072cf7/download/alunos.csv'),
            requests.get('https://dados.ifpb.edu.br/dataset/096a37b3-52c6-43d6-9ec3-6de5b73b51a0/resource/77679e8c-f885-4b62-bf33-df7cc55b2bb9/download/campi.csv'),
            requests.get('https://dados.ifpb.edu.br/dataset/5e8c6175-55c2-4498-b51b-7b45ae16ddcd/resource/a93651da-2257-42ed-ac7c-057b6db4fa3c/download/bolsas.csv'),
            requests.get('https://dados.ifpb.edu.br/dataset/029b50a4-f50a-422d-867f-b457277b5168/resource/7b3b7850-9a34-450d-96e1-e7ce13f4bb9f/download/projetos-extensao.csv'),
            requests.get('https://dados.ifpb.edu.br/dataset/e99b5cfd-f2f3-4b54-bb4f-6ddd9e480af7/resource/c45ea036-d8fc-4ba9-88bc-7854d5b964d5/download/projetos-pesquisa.csv')
            ]

    for req, nome in zip(reqs, nomes):
        with open('/app/DB/dados/'+nome, 'wb') as csv:
            csv.write(req.content)
    log.info('Fim do download.')


def tratando_csv_bolsas():
    bolsas = pandas.read_csv('/app/DB/dados/bolsas.csv')
    bolsas['categoria_bolsa'] = bolsas['categoria_bolsa'].str.strip()
    return bolsas


def tratando_csv_projetos_extensao():
    projetos_extensao = pandas.read_csv('/app/DB/dados/projetos-extensao.csv')
    return projetos_extensao


def tratando_csv_projetos_pesquisa():
    projetos_pesquisa = pandas.read_csv('/app/DB/dados/projetos-pesquisa.csv')
    return projetos_pesquisa


def tratando_csv_aluno():
    log.info('Tratando dados dos alunos.\n...')
    #Convertendo para maiúsculo
    alunos = pandas.read_csv('/app/DB/dados/alunos.csv')
    alunos['curso.nome'] = alunos['curso.nome'].str.upper()

    #Convertendo para maiúsculo, removeno palavra 'CAMPUS' e removendo coluna com nome = 'REITORIA'
    campi = pandas.read_csv('/app/DB/dados/campi.csv')
    campi['nome'] = campi['nome'].str.upper()
    campi['nome'] = campi['nome'].str.replace('CAMPUS ', '')
    campi.drop(campi[campi['nome']=='REITORIA'].index, inplace=True)

    #criando e add coluna id_curso
    newCols = alunos['curso.nome'].str.split(' - ', expand=True)
    alunos['id_curso'] = newCols[0]

    #Removendo id da string de cada célula da coluna curso.nome
    alunos['curso.nome'] = alunos['curso.nome'].str.replace(r'^[\d\w]+ - ', '')

    #criando e add coluna campus
    regxCampi = '|'.join(campi['nome'])
    alunos.drop(alunos[~alunos['curso.nome'].str.contains(r''+regxCampi)].index, inplace=True)
    alunos['campus'] = [re.search(r''+regxCampi, x).group() for x in alunos['curso.nome']]
    log.info('Tratamento concluido.')
    return alunos


def persistir():
    # download_dados()
    log.info('Persistindo dados...')
    engine = create_engine('postgresql+psycopg2://postgres:postgres@db_postgres:5432/tratador_db')
    tratando_csv_aluno().to_sql(name='alunos', con=engine, if_exists='replace', index=True, index_label='id')
    tratando_csv_bolsas().to_sql(name='bolsas', con=engine, if_exists='replace', index=True, index_label='id')
    tratando_csv_projetos_extensao().to_sql(name='projetos_extensao', con=engine, if_exists='replace', index=True, index_label='id')
    tratando_csv_projetos_pesquisa().to_sql(name='projetos_pesquisa', con=engine, if_exists='replace', index=True, index_label='id')
    log.info('Persistência concluida.')
    sendQuantidadeAlunosLimparamMatriculas(data_processor_campi.quantidade_alunos_limparam_matriculas(engine))
    sendSituacaoAlunoCanpiCurso(data_processor_campi.situacao_campus_curso(engine))
    sendQuantidadeAlunosComBolsaDesistentes(data_processor_campi.quantidade_alunos_auxilio_e_desistiram(engine))



def agendador():
    schedule.every().day.at("00:00").do(persistir)
    # schedule.every().minute.do(persistir)
    while True:
        schedule.run_pending()
        sleep(1)


def run():
    log.info("run...")
    persistir()
    # agendador()
    log.info("agendado processamento")
    thread = Thread(target=agendador)
    thread.start()
