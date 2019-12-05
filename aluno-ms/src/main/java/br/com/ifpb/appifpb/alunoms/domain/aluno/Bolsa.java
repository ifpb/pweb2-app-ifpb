package br.com.ifpb.appifpb.alunoms.domain.aluno;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Bolsa implements Serializable {

    private String categoria;
    private int quantidade;

    public static Bolsa criar(String categoria, int quantidade) {
        final Bolsa b = new Bolsa();
        b.categoria = categoria;
        b.quantidade = quantidade;
        return b;
    }
}
