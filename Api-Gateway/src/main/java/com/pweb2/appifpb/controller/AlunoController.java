package com.pweb2.appifpb.controller;

import com.pweb2.appifpb.controller.dto.AuthDTO;
import com.pweb2.appifpb.service.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping("auth")
    public String auth(@RequestBody AuthDTO authDTO) {
        return alunoService.auth(authDTO);
    }

}
