import data_processor
import kafka_manager
import data_processor_campi
from kafka_manager import sendQuantidadeAlunosComBolsaDesistentes, sendSituacaoAlunoCanpiCurso, sendQuantidadeAlunosLimparamMatriculas
from sqlalchemy import create_engine


if __name__ == "__main__":
    data_processor.run()
    kafka_manager.run()
    # engine = create_engine('postgresql+psycopg2://postgres:postgres@db_postgres:5432/tratador_db')
    # sendQuantidadeAlunosLimparamMatriculas(data_processor_campi.quantidade_alunos_limparam_matriculas(engine))
    # sendSituacaoAlunoCanpiCurso(data_processor_campi.situacao_campus_curso(engine))
    # sendQuantidadeAlunosComBolsaDesistentes(data_processor_campi.quantidade_alunos_auxilio_e_desistiram(engine))
    # pass