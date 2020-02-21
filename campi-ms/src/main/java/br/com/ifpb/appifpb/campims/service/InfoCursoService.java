package br.com.ifpb.appifpb.campims.service;

import br.com.ifpb.appifpb.campims.dto.*;
import br.com.ifpb.appifpb.campims.repositories.InfoCursoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InfoCursoService {

    private final InfoCursoRepository infoCursoRepository;

    public QuantCursosDTO buscarPorCampus(String campus) {
        return infoCursoRepository.buscarPorCampus(campus);
    }

    public QuantCursosDTO buscarPorCampusESituacao(String campus, String situacao) {
        return infoCursoRepository.buscarPorCampusESituacao(campus, situacao);
    }

    public QuantCursosDTO buscarPorCampusECurso(String campus, String curso) {
        return infoCursoRepository.buscarPorCampusECurso(campus, curso);
    }

    public QuantCursosDTO buscarPorCampusEporCursoEporSitucao(String campus, String curso, String situacao) {
        return infoCursoRepository.buscarPorCampusECursoESituacao(campus, curso, situacao);
    }

    public List<NomeSituacoesDTO> buscarSituacoes() {
        return infoCursoRepository.buscarNomesSituacoes();
    }

    public List<QuantCampusCursoDTO> buscarQuantCursosPorCampuseSituacao(String campus, String situacao) {
        List<QuantCampusCursoDTO> result = infoCursoRepository.buscarQuantCursosPorCampusEsituacao(campus, situacao);
        if(result != null && !result.isEmpty() && result.size() > 10) {
            return result.subList(0, 9);
        } else {
            return result;
        }
    }

    public List<NomeCursosDTO> buscarNomeCursoPorCampus(String campus) {
        return infoCursoRepository.buscarNomesCurso(campus);
    }

    public List<NomeCampiDTO> buscarNomesCampi() {
        return infoCursoRepository.buscarNomeCampus();
    }
}
