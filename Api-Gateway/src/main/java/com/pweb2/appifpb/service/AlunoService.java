package com.pweb2.appifpb.service;

import com.pweb2.appifpb.controller.dto.AuthDTO;
import com.pweb2.appifpb.controller.dto.UserDTO;
import com.pweb2.appifpb.model.Aluno;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "aluno-ms")
@Service
public interface AlunoService {

    @PostMapping("/auth")
    ResponseEntity<String> auth(AuthDTO authDTO);

    @PostMapping("/register")
    ResponseEntity register(UserDTO userDTO);

    @GetMapping("aluno/{matricula}")
    ResponseEntity<Aluno> aluno(@PathVariable("matricula") String matricula);
    
}
