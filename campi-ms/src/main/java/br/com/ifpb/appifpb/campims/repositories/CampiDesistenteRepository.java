package br.com.ifpb.appifpb.campims.repositories;

import br.com.ifpb.appifpb.campims.dto.CampiComPercentualDTO;
import br.com.ifpb.appifpb.campims.dto.NomeCampiDTO;
import br.com.ifpb.appifpb.campims.model.CampiDesistente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampiDesistenteRepository extends JpaRepository<CampiDesistente, Integer> {

    @Query("SELECT new br.com.ifpb.appifpb.campims.dto.CampiComPercentualDTO(c.id, c.campus, c.quant, c.total,(c.quant / c.total * 100) as percentual) " +
            "FROM CampiDesistente c " +
            "WHERE c.campus = :nomeCampus")
    CampiComPercentualDTO listarCampusPorNome(String nomeCampus);


}
