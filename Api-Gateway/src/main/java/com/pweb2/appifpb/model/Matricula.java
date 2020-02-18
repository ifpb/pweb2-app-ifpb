package com.pweb2.appifpb.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Matricula {

    private String valor;
    private String situacao;
    private String cota;
    private String campus;
    private String curso;

    public static Matricula criar(String valor, String situacao, String cota, String campus, String curso) {
        final Matricula m = new Matricula();
        m.valor = valor;
        m.situacao = situacao;
        m.cota = cota;
        m.campus = campus;
        m.curso = curso;
        return m;
    }
}
