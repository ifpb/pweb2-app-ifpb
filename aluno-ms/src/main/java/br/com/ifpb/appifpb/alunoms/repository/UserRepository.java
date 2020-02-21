package br.com.ifpb.appifpb.alunoms.repository;

import br.com.ifpb.appifpb.alunoms.domain.auth.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {


}
