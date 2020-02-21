package com.pweb2.appifpb.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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
