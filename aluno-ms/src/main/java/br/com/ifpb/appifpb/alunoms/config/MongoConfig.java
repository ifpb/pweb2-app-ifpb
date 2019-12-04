package br.com.ifpb.appifpb.alunoms.config;

import br.com.ifpb.appifpb.alunoms.repository.AlunoRepository;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = AlunoRepository.class)
@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "aluno-ms";
    }

    @Override
    public MongoClient mongoClient() {
        return new MongoClient("mongo", 27017);
    }

}
