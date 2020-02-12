package com.pweb2.appifpb.service;

import com.pweb2.appifpb.controller.dto.AuthDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "aluno-ms")
@Service
public interface AlunoService {

    @GetMapping("/auth")
    ResponseEntity auth(AuthDTO authDTO);


}
