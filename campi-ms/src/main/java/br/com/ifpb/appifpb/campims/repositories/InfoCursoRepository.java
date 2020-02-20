package br.com.ifpb.appifpb.campims.repositories;

import br.com.ifpb.appifpb.campims.model.InfoCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoCursoRepository extends JpaRepository<InfoCurso, Integer> {


}