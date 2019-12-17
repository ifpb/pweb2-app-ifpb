from kafka import KafkaConsumer
from kafka import KafkaProducer
from sqlalchemy import create_engine
from Domain import Aluno, Matricula, Bolsa, Projeto
# 201422010139

def dadosDaMatricula(engine, matricula):
    query = engine.execute(f"SELECT matricula, nome, \"curso.nome\",situacao,cota,campus FROM alunos WHERE matricula='{matricula}'").fetchall()[0]
    if(query):
        aluno = Aluno(query[0], query[1])
        aluno.matriculas = [Matricula(aluno.id, query[3], query[4], query[5], query[2])]
        return aluno
    else:
        None

#

def dadosDemaisMatriculas(aluno,engine):
    outrasMaticulas = engine.execute(f"SELECT matricula, nome, \"curso.nome\",situacao,cota,campus FROM alunos WHERE nome ilike '%%{aluno.nome}%%' AND matricula NOT ilike '{aluno.id}'")
    for matriculaTupla in outrasMaticulas:
        aluno.matriculas.append(Matricula(matriculaTupla[0], matriculaTupla[3], matriculaTupla[4], matriculaTupla[5], matriculaTupla[2]))
    return aluno
#

def dadosBolsas(aluno, engine):
    bolsas = engine.execute(f"SELECT categoria_bolsa,COUNT(*) as quantidade FROM bolsas WHERE aluno ilike '%%{aluno.nome}%%' GROUP BY categoria_bolsa")
    if(bolsas.rowcount > 0):
        aluno.bolsas = []
        for b in bolsas:
            aluno.bolsas.append(Bolsa(b[0], b[1]))
    return aluno
#

def dadosProjetosExtensao(aluno, engine):
    projetosExtensao = engine.execute(f"SELECT titulo, participantes, area_conhecimento, inicio_execucao, fim_execucao, valor_total_executado, unidade_organizacional FROM projetos_extensao WHERE participantes ilike '%%{aluno.nome}%%'")
    if(projetosExtensao.rowcount > 0):
        for projeto in projetosExtensao:
            aluno.projetos.append(Projeto(projeto[0], 'EXTENSAO',
                                          projeto[1], projeto[2],
                                          projeto[3], projeto[4],
                                          projeto[5], projeto[6]))
    return aluno
#

def dadosProjetosPesquisa(aluno, engine):#titulo, tipo, participantes, areaConhecimento, dataInicio, dataFim, valor, unidadeOrganizacional
    projetosPesquisa = engine.execute(f"SELECT titulo, participantes, area_conhecimento, inicio_execucao, fim_execucao, valor_total_executado, unidade_organizacional FROM projetos_pesquisa WHERE participantes ilike '%%{aluno.nome}%%'")
    if(projetosPesquisa.rowcount > 0):
        for projeto in projetosPesquisa:
            aluno.projetos.append(Projeto(projeto[0], 'PESQUISA',
                                          projeto[1], projeto[2],
                                          projeto[3], projeto[4],
                                          projeto[5], projeto[6]))
    return aluno
#

def run(matricula):
    engine = create_engine('postgresql://postgres:postgres@db_postgres:5432/tratador_db')
    aluno = dadosDaMatricula(engine, matricula)
    if (aluno):
        aluno.projetos = []
        aluno = dadosDemaisMatriculas(aluno, engine)
        aluno = dadosBolsas(aluno, engine)
        aluno = dadosProjetosExtensao(aluno, engine)
        aluno = dadosProjetosPesquisa(aluno, engine)
    return aluno
#