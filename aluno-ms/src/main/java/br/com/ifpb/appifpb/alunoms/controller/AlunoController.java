package br.com.ifpb.appifpb.alunoms.controller;

import br.com.ifpb.appifpb.alunoms.domain.aluno.*;
import br.com.ifpb.appifpb.alunoms.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @GetMapping("/aluno/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable("id") String id){
        Optional<Aluno> aluno = repository.findById(id);
        return ResponseEntity.ok(aluno.orElse(null));
    }

    @PostMapping(value = "/aluno", consumes = "application/json")
    public ResponseEntity<Aluno> save(@RequestBody Aluno aluno){
        Aluno result = repository.save(aluno);
        return ResponseEntity.ok(result);
    }

}
