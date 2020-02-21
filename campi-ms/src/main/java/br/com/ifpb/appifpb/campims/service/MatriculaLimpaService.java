package br.com.ifpb.appifpb.campims.service;

import br.com.ifpb.appifpb.campims.dto.MatriculasLimpasDTO;
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
        if(result != null && !result.isEmpty() && result.size() > 10) {
            return result.subList(0, 9);
        } else {
            return result;
        }
    }

    public List<MatriculasLimpasDTO> buscarPorCampusMin(String campus) {
        List<MatriculasLimpasDTO> result = matriculaLimpaRepository.buscarPorCampus(campus);
        if(result != null && !result.isEmpty() && result.size() > 10) {
            return result.subList(result.size() - 11, result.size() -1);
        } else {
            return result;
        }

    }

    public MatriculasLimpasDTO buscarPorCampuseCurso(String campus, String curso) {
        return matriculaLimpaRepository.buscarPorCampusECurso(campus, curso);
    }


}
