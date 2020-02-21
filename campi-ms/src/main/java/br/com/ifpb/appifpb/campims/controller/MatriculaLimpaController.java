package br.com.ifpb.appifpb.campims.controller;

import br.com.ifpb.appifpb.campims.dto.MatriculasLimpasDTO;
import br.com.ifpb.appifpb.campims.dto.NomeCursosDTO;
import br.com.ifpb.appifpb.campims.service.MatriculaLimpaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("campus")
@AllArgsConstructor
public class MatriculaLimpaController {

    private final MatriculaLimpaService matriculaLimpaService;

    @GetMapping("{id}/max")
    public ResponseEntity<List<MatriculasLimpasDTO>> buscarPorCampiMix(@PathVariable("id") String campus) {
        System.out.println(campus);
        return ResponseEntity.ok(matriculaLimpaService.buscarPorCampusMax(campus));
    }

    @GetMapping("{id}/min")
    public ResponseEntity<List<MatriculasLimpasDTO>> buscarPorCampiMin(@PathVariable("id") String campus) {
        return ResponseEntity.ok(matriculaLimpaService.buscarPorCampusMin(campus));
    }

    @GetMapping("{id}/cursos")
    public ResponseEntity<List<NomeCursosDTO>> buscarNomesCursos(@PathVariable("id") String campus) {
        return ResponseEntity.ok(matriculaLimpaService.buscarNomesCurso(campus));
    }

    @GetMapping("{campus}/curso/{curso}")
    public ResponseEntity<MatriculasLimpasDTO> buscarPorCampusECurso(@PathVariable("campus") String campus, @PathVariable("curso") String curso) {
        return ResponseEntity.ok(matriculaLimpaService.buscarPorCampuseCurso(campus,curso));
    }

}
