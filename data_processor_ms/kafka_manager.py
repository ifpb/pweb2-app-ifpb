from kafka import KafkaConsumer
from kafka import KafkaProducer
import aluno_handler
from Domain import Aluno
import json
from time import sleep

TOPICO_RECEPTOR_MATRICULA = "receptor-matricula"
TOPICO_RECEPTOR_ALUNO = "receptor-aluno"

TOPICO_REGISTRATION = "registration-info"
TOPICO_STUDENT = "student-info"
TOPICO_CAMPI = "campi-info"


def run():
    for i in range(20):
        brokers_available = True
        try:
            consumer = KafkaConsumer(TOPICO_RECEPTOR_MATRICULA, bootstrap_servers=['kafka:9092'], group_id='pweb-receptor-matricula')
        except kafka.errors.NoBrokersAvailable:
            brokers_available = False
            sleep(3)
        if brokers_available:
            break
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
    for i in range(20):
        brokers_available = True
        try:
            producer = KafkaProducer(bootstrap_servers=['kafka:9092'],
                                     value_serializer=lambda v: json.dumps(v, ensure_ascii=False,
                                                                           default=lambda o: o.__dict__).encode('utf8'))
        except kafka.errors.NoBrokersAvailable:
            brokers_available = False
            sleep(3)
        if brokers_available:
            break
    producer.send(TOPICO_RECEPTOR_ALUNO, aluno).get()

def sendEmptyAluno():
    producer.send(TOPICO_RECEPTOR_ALUNO, {}).get()

def sendErrorConsumer():
    producer.send(TOPICO_RECEPTOR_ALUNO, {'ERR': 'Falha no processo de recuperação de dados do Aluno'}).get()



def sendQuantidadeAlunosLimparamMatriculas(registration_info):
    for i in range(20):
        brokers_available = True
        try:
            producer = KafkaProducer(bootstrap_servers=['kafka:9092'],
                                     value_serializer=lambda v: json.dumps(v, ensure_ascii=False,
                                                                           default=lambda o: o.__dict__).encode('utf8'))
        except kafka.errors.NoBrokersAvailable:
            brokers_available = False
            sleep(3)
        if brokers_available:
            break
    producer.send(TOPICO_REGISTRATION, registration_info).get()

def sendSituacaoAlunoCanpiCurso(student_info):
    for i in range(20):
        brokers_available = True
        try:
            producer = KafkaProducer(bootstrap_servers=['kafka:9092'], max_request_size=101626282,
                                     value_serializer=lambda v: json.dumps(v, ensure_ascii=False,
                                                                           default=lambda o: o.__dict__).encode('utf8'))
        except kafka.errors.NoBrokersAvailable:
            brokers_available = False
            sleep(3)
        if brokers_available:
            break
    producer.send(TOPICO_STUDENT, student_info).get(timeout=1000)
    producer.close()

def sendQuantidadeAlunosComBolsaDesistentes(campi_info):
    for i in range(20):
        brokers_available = True
        try:
            producer = KafkaProducer(bootstrap_servers=['kafka:9092'],
                                     value_serializer=lambda v: json.dumps(v, ensure_ascii=False,
                                                                           default=lambda o: o.__dict__).encode('utf8'))
        except kafka.errors.NoBrokersAvailable:
            brokers_available = False
            sleep(3)
        if brokers_available:
            break
    producer.send(TOPICO_CAMPI, campi_info).get()