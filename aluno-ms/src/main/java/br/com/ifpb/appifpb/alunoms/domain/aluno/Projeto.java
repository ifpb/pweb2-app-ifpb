package br.com.ifpb.appifpb.alunoms.domain.aluno;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Projeto {

    private String titulo;
    private TipoProjeto tipo;
    private String participantes;
    private String areaConhecimento;
    private LocalDate dataInicio;
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
