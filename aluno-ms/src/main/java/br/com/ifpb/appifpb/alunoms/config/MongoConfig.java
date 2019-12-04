package br.com.ifpb.appifpb.alunoms.config;

import br.com.ifpb.appifpb.alunoms.repository.AlunoRepository;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = AlunoRepository.class)
@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "aluno-ms";
    }


    @Override
    public com.mongodb.client.MongoClient mongoClient() {
        return MongoClients.create("mongodb://mongo:27017");
    }
}
