package br.com.ifpb.appifpb.campims.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuantCampusCursoDTO {

    private Long quant;
    private String nomeCurso;

}
