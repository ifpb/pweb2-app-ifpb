FROM nickgryg/alpine-pandas
RUN apk update && \
    apk add --no-cache gcc musl-dev linux-headers && \
    apk add postgresql-dev
RUN pip3 install --upgrade pip
COPY requirements.txt /app/requirements.txt
#COPY data_processor.py /app/data_processor.py
#COPY ./DB/dados/alunos.csv /app/DB/dados/alunos.csv
#COPY ./DB/dados/campi.csv /app/DB/dados/campi.csv
RUN PYTHONPATH=/usr/bin/python pip3 install -r /app/requirements.txt
CMD python3 /app/data_processor.py
