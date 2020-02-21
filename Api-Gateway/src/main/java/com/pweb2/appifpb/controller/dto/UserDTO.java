package com.pweb2.appifpb.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class UserDTO implements Serializable {

    private String matricula;
    private String senha;
    private String nomeCompleto;
    private String curso;

}
