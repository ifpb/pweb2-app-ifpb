package br.com.ifpb.appifpb.alunoms.repository;

import br.com.ifpb.appifpb.alunoms.domain.aluno.Aluno;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends MongoRepository<Aluno, String> {
}
