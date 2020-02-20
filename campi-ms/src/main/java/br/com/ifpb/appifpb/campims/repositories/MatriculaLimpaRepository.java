package br.com.ifpb.appifpb.campims.repositories;

import br.com.ifpb.appifpb.campims.dto.MatriculasLimpasDTO;
import br.com.ifpb.appifpb.campims.dto.NomeCursosDTO;
import br.com.ifpb.appifpb.campims.model.MatriculaLimpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface MatriculaLimpaRepository extends JpaRepository<MatriculaLimpa, Integer> {


    @Query("SELECT new br.com.ifpb.appifpb.campims.dto.MatriculasLimpasDTO(m.campus as campus, m.curso as curso, (m.quantMatriculasLimpas/m.totalAluno * 100) as percentual) " +
            "FROM MatriculaLimpa m " +
            "WHERE m.campus = :campus " +
            "ORDER BY percentual DESC")
    List<MatriculasLimpasDTO> buscarPorCampus(String campus);

    @Query("SELECT new br.com.ifpb.appifpb.campims.dto.MatriculasLimpasDTO(m.campus as campus, m.curso as curso, (m.quantMatriculasLimpas/m.totalAluno * 100) as percentual) " +
            "FROM MatriculaLimpa m " +
            "WHERE m.campus = :campus AND m.curso = :curso")
    MatriculasLimpasDTO buscarPorCampusECurso(String campus, String curso);

    @Query("SELECT new br.com.ifpb.appifpb.campims.dto.NomeCursosDTO(m.curso) FROM MatriculaLimpa m WHERE m.campus = :campus")
    List<NomeCursosDTO> buscarNomesCursosPorCampi(String campus);


}
