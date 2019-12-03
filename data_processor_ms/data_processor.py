import pandas
import re
from sqlalchemy import create_engine
import requests

def download_dados():
    print('Iniciando download dos dados.\n...')
    nomes = ['alunos.csv', 'campi.csv']
    reqs = [requests.get('https://dados.ifpb.edu.br/dataset/d02eb6b8-5745-4436-ae22-ef1c182897d9/resource/29c2b593-ed14-4b73-b30c-d6135f072cf7/download/alunos.csv'),
            requests.get('https://dados.ifpb.edu.br/dataset/096a37b3-52c6-43d6-9ec3-6de5b73b51a0/resource/77679e8c-f885-4b62-bf33-df7cc55b2bb9/download/campi.csv')]

    for req, nome in zip(reqs, nomes):
        with open('/app/DB/dados/'+nome, 'wb') as csv:
            csv.write(req.content)
    print('Fim do download.')


def tratando_csv_aluno():
    print('Tratando dados dos alunos.\n...')
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
    print('Tratamento concluido.')
    return alunos


def main():
    download_dados()
    print('Persistindo dados.')
    engine = create_engine('postgresql+psycopg2://postgres:postgres@db_postgres:5432/tratador_db')
    tratando_csv_aluno().to_sql(name='alunos', con=engine, if_exists='replace', index=True, index_label='id')
    print('Persistência concluida.')

main()