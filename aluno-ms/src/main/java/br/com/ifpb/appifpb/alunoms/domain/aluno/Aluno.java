package br.com.ifpb.appifpb.alunoms.domain.aluno;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document
public class Aluno implements Serializable {

    @Id
    public String id;
    public String nome;

}

