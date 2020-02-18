package com.pweb2.appifpb.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Projeto {

    private String titulo;
    private TipoProjeto tipo;
    private String participantes;
    private String areaConhecimento;

    //    @DateTimeFormat(iso = DateTimeFormatter.ofPattern("dd/MM/Myyyy-MM-dd"))
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicio;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFim;
    private String valor;
    private String unidadeOrganizacional;

    public static Projeto criar (String titulo, TipoProjeto tipo, String participantes,
                                 String areaConhecimento, LocalDate dataInicio,
                                 LocalDate dataFim, String valor, String unidadeOrganizacional) {
        final Projeto p = new Projeto();
        p.titulo = titulo;
        p.tipo = tipo;
        p.participantes = participantes;
        p.areaConhecimento = areaConhecimento;
        p.dataInicio = dataInicio;
        p.dataFim = dataFim;
        p.valor = valor;
        p.unidadeOrganizacional = unidadeOrganizacional;
        return p;
    }
}
