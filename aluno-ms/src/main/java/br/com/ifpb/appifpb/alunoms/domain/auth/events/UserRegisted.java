package br.com.ifpb.appifpb.alunoms.domain.auth.events;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UserRegisted {
    private String matricula;
    private String nomeCompleto;
    private String curso;
    private LocalDateTime momento;
}
