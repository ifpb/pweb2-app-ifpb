from kafka import KafkaConsumer
from kafka import KafkaProducer
import aluno_handler
from Domain import Aluno
import json


def run():
    consumer = KafkaConsumer('receptor-matricula', bootstrap_servers=['kafka:9092'], group_id='pweb-receptor-matricula')
    for msg in consumer:
        matricula = msg.value.decode("utf-8")
        aluno = aluno_handler.run(matricula)
        sendAluno(aluno.__dict__)


def sendAluno(aluno):
    producer = KafkaProducer(bootstrap_servers=['kafka:9092'], value_serializer=lambda v: json.dumps(v, ensure_ascii=False, default=lambda o:o.__dict__).encode('utf8'))
    future = producer.send('receptor-aluno', aluno)
    result = future.get()
