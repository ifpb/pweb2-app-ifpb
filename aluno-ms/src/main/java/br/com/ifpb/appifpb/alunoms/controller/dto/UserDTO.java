package br.com.ifpb.appifpb.alunoms.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserDTO {

    private String matricula;
    private String senha;
    private String nomeCompleto;
    private String curso;

}
