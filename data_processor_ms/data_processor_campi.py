from sqlalchemy import create_engine
from Domain import RegistrationInfo, StudentInfo, CampusInfo

def quantidade_alunos_limparam_matriculas(engine):
    query = """select tab1."curso.nome", tab1.campus, tab1.quant as limparam, tab2.quant as total
    
                                from
                                (select count(*)::float as quant, \"curso.nome\", campus 
                                from(
                                    select \"curso.nome\", campus from alunos 
                                    group by nome, \"curso.nome\", campus having count(*)>1
                                ) as tab
                                group by tab .\"curso.nome\", campus 
                                order by quant desc) tab1,
                                
                                (select count(*)::float as quant, campus, \"curso.nome\" from alunos a group by campus, \"curso.nome\") tab2
                                
                                where tab1.\"curso.nome\" ilike tab2.\"curso.nome\" and tab1.campus ilike tab2.campus"""
    results = engine.execute(query).fetchall()
    result_list_obj = []
    for r in results:
        result_list_obj.append(RegistrationInfo(r[0], r[1], r[2], r[3]))
    return result_list_obj


def situacao_campus_curso(engine):
    query = """select campus, \"curso.nome\", situacao from alunos a"""
    results = engine.execute(query).fetchall()
    result_list_obj = []
    for r in results:
        result_list_obj.append(StudentInfo(r[0], r[1], r[2]))
    return result_list_obj

def quantidade_alunos_auxilio_e_desistiram(engine):
    query = """select tab1.campus, tab1.quant, tab2.total
                from
                (select campus, count(*) as quant from alunos a, bolsas b 
                where a.nome ilike b.aluno and 
                a.situacao similar to \'Trancado|Voluntariamente|Trancado|Jubilado|Evasão|Cancelamento Compulsório|Cancelado|Afastado\'
                group by campus) tab1,
                (select campus, count(*) as total from alunos a group by campus) tab2
                where tab1.campus ilike tab2.campus"""
    results = engine.execute(query).fetchall()
    result_list_obj = []
    for r in results:
        result_list_obj.append(CampusInfo(r[0], r[1], r[2]))
    return result_list_obj


