package br.com.ifpb.appifpb.campims.controller;


import br.com.ifpb.appifpb.campims.dto.CampiComPercentualDTO;
import br.com.ifpb.appifpb.campims.dto.NomeCampiDTO;
import br.com.ifpb.appifpb.campims.service.CampiDesistenteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("campi")
@AllArgsConstructor
public class CampiDesistenteController {

    private final CampiDesistenteService campiService;

    @GetMapping("all")
    public ResponseEntity<List<NomeCampiDTO>> nomesCampi(){
        return ResponseEntity.ok().body(this.campiService.nomesCampi());
    }

    @GetMapping("{nomeCampi}")
    public ResponseEntity<CampiComPercentualDTO> buscarCampusPorNome(@PathVariable("nomeCampi") String nome){
        return ResponseEntity.ok().body(this.campiService.buscarCampusPorNome(nome));
    }
}
