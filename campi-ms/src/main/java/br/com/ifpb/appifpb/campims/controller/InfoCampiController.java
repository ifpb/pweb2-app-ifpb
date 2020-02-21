package br.com.ifpb.appifpb.campims.controller;

import br.com.ifpb.appifpb.campims.dto.NomeCampiDTO;
import br.com.ifpb.appifpb.campims.dto.NomeCursosDTO;
import br.com.ifpb.appifpb.campims.service.InfoCursoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("campi")
public class InfoCampiController {

    private final InfoCursoService infoCursoService;

    @GetMapping("{nomeCampus}/cursos")
    public ResponseEntity<List<NomeCursosDTO>> buscarNomesCurso(@PathVariable("nomeCampus") String campus) {
        return ResponseEntity.ok(infoCursoService.buscarNomeCursoPorCampus(campus));
    }

    @GetMapping("all")
    public ResponseEntity<List<NomeCampiDTO>> buscarNomesCampus() {
        return ResponseEntity.ok(infoCursoService.buscarNomesCampi());
    }

}
