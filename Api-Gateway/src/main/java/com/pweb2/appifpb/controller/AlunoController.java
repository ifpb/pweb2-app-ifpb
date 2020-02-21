package com.pweb2.appifpb.controller;

import com.pweb2.appifpb.controller.dto.AuthDTO;
import com.pweb2.appifpb.controller.dto.TokenDTO;
import com.pweb2.appifpb.controller.dto.UserDTO;
import com.pweb2.appifpb.model.Aluno;
import com.pweb2.appifpb.service.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@CrossOrigin()
@RestController
@RequestMapping("api")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping("auth")
    public ResponseEntity<TokenDTO> auth(@RequestBody AuthDTO authDTO) {
        ResponseEntity<String> response = alunoService.auth(authDTO);
        String token = response.getBody();
        Logger.getLogger("DEBUG").info("NOVO TOKEN SOLICITADO: "+token);
        TokenDTO tokenResponse = new TokenDTO(token);
        return ResponseEntity.ok().body(tokenResponse);
    }

    @PostMapping("register")
    public ResponseEntity register(@RequestBody UserDTO userDTO){
        return this.alunoService.register(userDTO);
    }

    @GetMapping("aluno/{matricula}")
    public ResponseEntity<Aluno> aluno(@PathVariable("matricula") String matricula){
        return this.alunoService.aluno(matricula);
    }
}
