package com.pweb2.appifpb.service;


import com.pweb2.appifpb.controller.dto.CampiComPercentualDTO;
import com.pweb2.appifpb.controller.dto.NomeCampiDTO;
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
}
