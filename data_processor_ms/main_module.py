import data_processor as DataProcessor
import kafka_comunication as KafkaComunication

def main():
    DataProcessor.main()
    KafkaComunication.main()

main()