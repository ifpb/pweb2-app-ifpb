package com.pweb2.appifpb.controller;

import com.pweb2.appifpb.controller.dto.NomeSituacoesDTO;
import com.pweb2.appifpb.controller.dto.QuantCampusCursoDTO;
import com.pweb2.appifpb.controller.dto.QuantCursosDTO;
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
public class CursosController {

    private final CampiService campiService;

    @GetMapping("campus/{nomeCampus}")
    public ResponseEntity<QuantCursosDTO> buscarPorCampus(@PathVariable("nomeCampus") String campus){
        ResponseEntity quantCursosDTOResponseEntity = this.campiService.buscarPorCampus(campus);
        Logger.getLogger(this.getClass().getName()).info(quantCursosDTOResponseEntity.toString());
        return quantCursosDTOResponseEntity;
    }

    @GetMapping("campus/{nomeCampus}/curso/{nomeCurso}")
    public ResponseEntity<QuantCursosDTO> buscaPorCampusEporCurso(@PathVariable("nomeCampus") String campus, @PathVariable("nomeCurso") String curso){
        return this.campiService.buscaPorCampusEporCurso(campus, curso);
    }

    @GetMapping("campus/{nomeCampus}/situacao/{situacao}")
    public ResponseEntity<QuantCursosDTO> buscaPorCampusEporSituacao(@PathVariable("nomeCampus") String campus, @PathVariable("situacao") String situacao){
        return this.campiService.buscaPorCampusEporSituacao(campus, situacao);
    }

    @GetMapping("campus/{nomeCampus}/cursos/{nomeCurso}/situacao/{situacao}")
    public ResponseEntity<QuantCursosDTO> buscaPorCampusEporCursoEporSituacao(@PathVariable("nomeCampus") String campus,
                                                                              @PathVariable("nomeCurso") String curso,
                                                                              @PathVariable("situacao") String situacao){
        return this.campiService.buscaPorCampusEporCursoEporSituacao(campus, curso, situacao);
    }

    @GetMapping("situacoes")
    public ResponseEntity<List<NomeSituacoesDTO>> listarSituacoes(){
        return this.campiService.listarSituacoes();
    }

    @GetMapping("campus/{nomeCampus}/cursos/situacao/{situacao}")
    ResponseEntity<List<QuantCampusCursoDTO>> buscarTotalCursosCampus(@PathVariable("nomeCampus") String campus,
                                                                      @PathVariable("situacao") String situacao){
        return this.campiService.buscarTotalCursosCampus(campus, situacao);
    }


}
