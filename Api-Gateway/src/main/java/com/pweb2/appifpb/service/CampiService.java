package com.pweb2.appifpb.service;


import com.pweb2.appifpb.controller.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "campi-ms")
@Service
public interface CampiService {

    @GetMapping("campi/all")
    ResponseEntity<List<NomeCampiDTO>> todosCampus();

    @GetMapping("campi/{nomeCampus}")
    ResponseEntity<CampiComPercentualDTO> buscarCampusPorNome(@PathVariable("nomeCampus") String nomeCampus);

    @GetMapping("estatisticas/campus/{nomeCampus}")
    ResponseEntity<QuantCursosDTO> buscarPorCampus(@PathVariable("nomeCampus") String campus);

    @GetMapping("estatisticas/campus/{nomeCampus}/curso/{nomeCurso}")
    ResponseEntity<QuantCursosDTO> buscaPorCampusEporCurso(@PathVariable("nomeCampus") String campus, @PathVariable("nomeCurso") String curso);

    @GetMapping("estatisticas/campus/{nomeCampus}/situacao/{situacao}")
    ResponseEntity<QuantCursosDTO> buscaPorCampusEporSituacao(@PathVariable("nomeCampus") String campus, @PathVariable("situacao") String situacao);

    @GetMapping("estatisticas/campus/{nomeCampus}/cursos/{nomeCurso}/situacao/{situacao}")
    ResponseEntity<QuantCursosDTO> buscaPorCampusEporCursoEporSituacao(@PathVariable("nomeCampus") String campus,
                                                                              @PathVariable("nomeCurso") String curso,
                                                                              @PathVariable("situacao") String situacao);

    @GetMapping("estatisticas/situacoes")
    ResponseEntity<List<NomeSituacoesDTO>> listarSituacoes();

    @GetMapping("campi/{nomeCampus}/cursos")
    ResponseEntity<List<NomeCursosDTO>> buscarNomesCurso(@PathVariable("nomeCampus") String campus);

    @GetMapping("estatisticas/campus/{nomeCampus}/cursos/situacao/{situacao}")
    ResponseEntity<List<QuantCampusCursoDTO>> buscarTotalCursosCampus(@PathVariable("nomeCampus") String campus,
                                                                             @PathVariable("situacao") String situacao);
}
