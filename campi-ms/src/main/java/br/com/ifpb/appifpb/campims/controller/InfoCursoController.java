package br.com.ifpb.appifpb.campims.controller;

import br.com.ifpb.appifpb.campims.dto.NomeSituacoesDTO;
import br.com.ifpb.appifpb.campims.dto.QuantCursosDTO;
import br.com.ifpb.appifpb.campims.repositories.InfoCursoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.xml.ws.Response;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("estatisticas")
public class InfoCursoController {

    private final InfoCursoRepository infoCursoRepository;

    @GetMapping("campus/{nomeCampus}")
    public ResponseEntity<QuantCursosDTO> buscarPorCampus(@PathVariable("nomeCampus") String campus) {
        return ResponseEntity.ok(infoCursoRepository.buscarPorCampus(campus));
    }

    @GetMapping("campus/{nomeCampus}/curso/{nomeCurso}")
    public ResponseEntity<QuantCursosDTO> buscaPorCampusEporCurso(@PathVariable("nomeCampus") String campus, @PathVariable("nomeCurso") String curso) {
        return ResponseEntity.ok(infoCursoRepository.buscarPorCampusECurso(campus, curso));
    }

    @GetMapping("campus/{nomeCampus}/situacao/{situacao}")
    public ResponseEntity<QuantCursosDTO> buscaPorCampusEporSituacao(@PathVariable("nomeCampus") String campus, @PathVariable("situacao") String situacao) {
        return ResponseEntity.ok(infoCursoRepository.buscarPorCampusESituacao(campus, situacao));
    }

    @GetMapping("campus/{nomeCampus}/curso/{nomeCurso}/situacao/{situacao}")
    public ResponseEntity<QuantCursosDTO> buscaPorCampusEporCursoEporSituacao(@PathVariable("nomeCampus") String campus,
                                                                              @PathVariable("nomeCurso") String curso,
                                                                              @PathVariable("situacao") String situacao) {
        return ResponseEntity.ok(infoCursoRepository.buscarPorCampusECursoESituacao(campus, curso, situacao));
    }

    @GetMapping("situacoes")
    public ResponseEntity<List<NomeSituacoesDTO>> listarSituacoes() {
        return ResponseEntity.ok(infoCursoRepository.buscarNomesSituacoes());
    }



}
