package br.com.ifpb.appifpb.campims.repositories;

import br.com.ifpb.appifpb.campims.model.MatriculaLimpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaLimpaRepository extends JpaRepository<MatriculaLimpa, Integer> {

}
