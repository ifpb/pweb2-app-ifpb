from kafka import KafkaConsumer
from kafka import KafkaProducer
import aluno_handler
from Domain import Aluno
import json

TOPICO_RECEPTOR_MATRICULA = "receptor-matricula"
TOPICO_RECEPTOR_ALUNO = "receptor-aluno"

producer = KafkaProducer(bootstrap_servers=['kafka:9092'], value_serializer=lambda v: json.dumps(v, ensure_ascii=False, default=lambda o: o.__dict__).encode('utf8'))


def run():
    consumer = KafkaConsumer(TOPICO_RECEPTOR_MATRICULA, bootstrap_servers=['kafka:9092'], group_id='pweb-receptor-matricula')
    for msg in consumer:
        try:
            matricula = msg.value.decode("utf-8")
            aluno = aluno_handler.run(matricula)
            if(aluno):
                sendAluno(aluno.__dict__)
            else:
                sendEmptyAluno()
        except:
            sendErrorConsumer()

def sendAluno(aluno):
    producer.send(TOPICO_RECEPTOR_ALUNO, aluno).get()

def sendEmptyAluno():
    producer.send(TOPICO_RECEPTOR_ALUNO, {}).get()

def sendErrorConsumer():
    producer.send(TOPICO_RECEPTOR_ALUNO, {'ERR': 'Falha no processo de recuperação de dados do Aluno'}).get()
