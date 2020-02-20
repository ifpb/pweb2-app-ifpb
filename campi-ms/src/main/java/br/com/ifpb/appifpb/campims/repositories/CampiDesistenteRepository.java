package br.com.ifpb.appifpb.campims.repositories;

import br.com.ifpb.appifpb.campims.model.CampiDesistente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampiDesistenteRepository extends JpaRepository<CampiDesistente, Integer> {


}
