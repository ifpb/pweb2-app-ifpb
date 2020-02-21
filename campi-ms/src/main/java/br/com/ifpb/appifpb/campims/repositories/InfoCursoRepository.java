package br.com.ifpb.appifpb.campims.repositories;

import br.com.ifpb.appifpb.campims.dto.NomeSituacoesDTO;
import br.com.ifpb.appifpb.campims.dto.QuantCursosDTO;
import br.com.ifpb.appifpb.campims.model.InfoCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfoCursoRepository extends JpaRepository<InfoCurso, Integer> {

    @Query("SELECT new br.com.ifpb.appifpb.campims.dto.QuantCursosDTO(count(i)) FROM InfoCurso i WHERE i.campus = :campus")
    QuantCursosDTO buscarPorCampus(String campus);

    @Query("SELECT new br.com.ifpb.appifpb.campims.dto.QuantCursosDTO(count(i)) " +
            "FROM InfoCurso i " +
            "WHERE i.campus = :campus AND i.curso = :curso")
    QuantCursosDTO buscarPorCampusECurso(String campus, String curso);

    @Query("SELECT new br.com.ifpb.appifpb.campims.dto.QuantCursosDTO(count(i)) " +
            "FROM InfoCurso i " +
            "WHERE i.campus = :campus AND i.situacao = :situacao")
    QuantCursosDTO buscarPorCampusESituacao(String campus, String situacao);

    @Query("SELECT new br.com.ifpb.appifpb.campims.dto.QuantCursosDTO(count(i)) " +
            "FROM InfoCurso i " +
            "WHERE i.campus = :campus AND i.curso = :curso AND i.situacao = :situacao")
    QuantCursosDTO buscarPorCampusECursoESituacao(String campus, String curso, String situacao);

    @Query("SELECT new br.com.ifpb.appifpb.campims.dto.NomeSituacoesDTO(i.situacao) " +
            "FROM InfoCurso i " +
            "GROUP BY i.situacao")
    List<NomeSituacoesDTO> buscarNomesSituacoes();

}
