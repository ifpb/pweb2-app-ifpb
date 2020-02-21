package com.pweb2.appifpb.controller;

import com.pweb2.appifpb.controller.dto.CampiComPercentualDTO;
import com.pweb2.appifpb.controller.dto.NomeCampiDTO;
import com.pweb2.appifpb.controller.dto.NomeCursosDTO;
import com.pweb2.appifpb.controller.dto.QuantCampusCursoDTO;
import com.pweb2.appifpb.service.CampiService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@CrossOrigin
@RestController
@RequestMapping("api/campi")
@AllArgsConstructor
public class CampiController {

    private final CampiService campiService;

    @GetMapping
    public ResponseEntity<List<NomeCampiDTO>> todosCampus(){
        ResponseEntity<List<NomeCampiDTO>> listResponseEntity = this.campiService.todosCampus();
        Logger.getLogger(this.getClass().getName()).info(listResponseEntity.toString());
        return listResponseEntity;
    }

    @GetMapping("{nomeCampus}")
    public ResponseEntity<CampiComPercentualDTO> listarCampusPorNome(@PathVariable("nomeCampus") String nomeCampus){
        Logger.getLogger(this.getClass().getName()).info(nomeCampus);
        return this.campiService.buscarCampusPorNome(nomeCampus);
    }

    @GetMapping("{nomeCampus}/cursos")
    public ResponseEntity<List<NomeCursosDTO>> buscarNomesCurso(@PathVariable("nomeCampus") String campus) {
        return campiService.buscarNomesCurso(campus);
    }
}
