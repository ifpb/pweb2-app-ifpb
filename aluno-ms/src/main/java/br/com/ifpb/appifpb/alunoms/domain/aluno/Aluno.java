package br.com.ifpb.appifpb.alunoms.domain.aluno;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Data
@Document
public class Aluno implements Serializable {

    @Id
    public String id;
    public String nome;

    public List<Projeto> projetos;

    public List<Bolsa> bolsas;

    public List<Matricula> matriculas;
}

