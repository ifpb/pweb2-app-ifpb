package br.com.ifpb.appifpb.campims.service;

import br.com.ifpb.appifpb.campims.dto.MatriculasLimpasDTO;
import br.com.ifpb.appifpb.campims.dto.NomeCursosDTO;
import br.com.ifpb.appifpb.campims.model.MatriculaLimpa;
import br.com.ifpb.appifpb.campims.repositories.MatriculaLimpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MatriculaLimpaService {

    private final MatriculaLimpaRepository matriculaLimpaRepository;

    public List<MatriculasLimpasDTO> buscarPorCampusMax(String campus) {
        List<MatriculasLimpasDTO> result = matriculaLimpaRepository.buscarPorCampus(campus);
        return result.subList(0, 9);
    }

    public List<MatriculasLimpasDTO> buscarPorCampusMin(String campus) {
        List<MatriculasLimpasDTO> result = matriculaLimpaRepository.buscarPorCampus(campus);
        return result.subList(result.size() - 11, result.size() -1);
    }

    public MatriculasLimpasDTO buscarPorCampuseCurso(String campus, String curso) {
        return matriculaLimpaRepository.buscarPorCampusECurso(campus, curso);
    }

    public List<NomeCursosDTO> buscarNomesCurso(String campus) {
        return matriculaLimpaRepository.buscarNomesCursosPorCampi(campus);
    }

}
