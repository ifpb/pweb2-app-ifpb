from kafka import KafkaProducer
from kafka import KafkaConsumer
import time

def main():
    # time.sleep(12)
    # print("\n\n\n\n\n\n\n\n\n\n\nesperou os 15s\n\n\n\n\n\n\n\n\n\n\n")
    # producer = KafkaProducer(
    #     bootstrap_servers='172.21.0.4:9092')
    # producer.send("meu-topico-legal", b"primeira msg")
    # producer.close()
    consumer = KafkaConsumer('meu-topico-legal',bootstrap_servers=['kafka:9092'])
    while 1:
        print("-")
        for msg in consumer:
            print(msg)
    print("fim")