package br.com.ifpb.appifpb.campims.controller;

import br.com.ifpb.appifpb.campims.dto.NomeCursosDTO;
import br.com.ifpb.appifpb.campims.dto.NomeSituacoesDTO;
import br.com.ifpb.appifpb.campims.dto.QuantCampusCursoDTO;
import br.com.ifpb.appifpb.campims.dto.QuantCursosDTO;
import br.com.ifpb.appifpb.campims.service.InfoCursoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("estatisticas")
public class InfoCursoController {

    private final InfoCursoService infoCursoService;

    @GetMapping("campus/{nomeCampus}")
    public ResponseEntity<QuantCursosDTO> buscarPorCampus(@PathVariable("nomeCampus") String campus) {
        return ResponseEntity.ok(infoCursoService.buscarPorCampus(campus));
    }

    @GetMapping("campus/{nomeCampus}/curso/{nomeCurso}")
    public ResponseEntity<QuantCursosDTO> buscaPorCampusEporCurso(@PathVariable("nomeCampus") String campus, @PathVariable("nomeCurso") String curso) {
        return ResponseEntity.ok(infoCursoService.buscarPorCampusECurso(campus, curso));
    }

    @GetMapping("campus/{nomeCampus}/situacao/{situacao}")
    public ResponseEntity<QuantCursosDTO> buscaPorCampusEporSituacao(@PathVariable("nomeCampus") String campus, @PathVariable("situacao") String situacao) {
        return ResponseEntity.ok(infoCursoService.buscarPorCampusESituacao(campus, situacao));
    }

    @GetMapping("campus/{nomeCampus}/curso/{nomeCurso}/situacao/{situacao}")
    public ResponseEntity<QuantCursosDTO> buscaPorCampusEporCursoEporSituacao(@PathVariable("nomeCampus") String campus,
                                                                              @PathVariable("nomeCurso") String curso,
                                                                              @PathVariable("situacao") String situacao) {
        return ResponseEntity.ok(infoCursoService.buscarPorCampusEporCursoEporSitucao(campus, curso, situacao));
    }

    @GetMapping("situacoes")
    public ResponseEntity<List<NomeSituacoesDTO>> listarSituacoes() {
        return ResponseEntity.ok(infoCursoService.buscarSituacoes());
    }

    @GetMapping("campus/{nomeCampus}/cursos/situacao/{situacao}")
    public ResponseEntity<List<QuantCampusCursoDTO>> buscarTotalCursosCampus(@PathVariable("nomeCampus") String campus,
                                                                            @PathVariable("situacao") String situacao) {
        return ResponseEntity.ok(infoCursoService.buscarQuantCursosPorCampuseSituacao(campus, situacao));
    }

}
