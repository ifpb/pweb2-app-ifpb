package com.pweb2.appifpb.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@ToString
@Data
public class Aluno implements Serializable {

    public String id;
    public String nome;

    public List<Projeto> projetos;

    public List<Bolsa> bolsas;

    public List<Matricula> matriculas;
}
