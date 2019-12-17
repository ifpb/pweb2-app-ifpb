package br.com.ifpb.appifpb.alunoms.controller;

import br.com.ifpb.appifpb.alunoms.config.security.jwt.JwtUtil;
import br.com.ifpb.appifpb.alunoms.controller.dto.AuthDTO;
import br.com.ifpb.appifpb.alunoms.controller.dto.TokenDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final JwtUtil jwtUtil;

    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("auth")
    public ResponseEntity login(@RequestBody AuthDTO authDTO) {

        System.out.println(passwordEncoder.encode(authDTO.getPassword()));

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(authDTO.getMatricula(), authDTO.getPassword());

        String token = this.jwtUtil.generateToken(authenticationManager.authenticate(authenticationToken));

        return ResponseEntity.ok(new TokenDTO(token));
    }

}
