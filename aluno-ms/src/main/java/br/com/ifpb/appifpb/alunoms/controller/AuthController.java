package br.com.ifpb.appifpb.alunoms.controller;

import br.com.ifpb.appifpb.alunoms.config.security.jwt.JwtUtil;
import br.com.ifpb.appifpb.alunoms.controller.dto.AuthDTO;
import br.com.ifpb.appifpb.alunoms.controller.dto.TokenDTO;
import br.com.ifpb.appifpb.alunoms.controller.dto.UserDTO;
import br.com.ifpb.appifpb.alunoms.domain.auth.User;
import br.com.ifpb.appifpb.alunoms.repository.UserRepository;
import br.com.ifpb.appifpb.alunoms.service.UserService;
import br.com.ifpb.appifpb.alunoms.service.exception.UserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class AuthController {

    private final JwtUtil jwtUtil;

    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;

    private final UserService userService;

    private final UserRepository userRepository;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, PasswordEncoder passwordEncoder, UserService userService, UserRepository userRepository) {
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping("auth")
    public String login(@RequestBody AuthDTO authDTO) {

        System.out.println(passwordEncoder.encode(authDTO.getSenha()));

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(authDTO.getMatricula(), authDTO.getSenha());

        String token = this.jwtUtil.generateToken(authenticationManager.authenticate(authenticationToken));

        return token;
    }

    @PostMapping("register")
    public ResponseEntity cadastro(@RequestBody UserDTO userDTO) {
        try {
            this.userService.register(userDTO);
            return ResponseEntity.ok().build();
        } catch (UserException e) {
            log.error("Register error", e);
            return ResponseEntity.badRequest().header("erro", e.getMessage()).build();
        }
    }

    @GetMapping("teste/{matricula}")
    public User teste(@PathVariable("matricula") String matricula) {
        return this.userRepository.findById(matricula).get();
    }

}
