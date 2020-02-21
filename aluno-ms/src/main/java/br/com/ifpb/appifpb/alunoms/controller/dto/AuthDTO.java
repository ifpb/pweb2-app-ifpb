package br.com.ifpb.appifpb.alunoms.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthDTO {

    private String matricula;
    private String senha;

}
