package br.com.ifpb.appifpb.campims.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatriculasLimpasDTO {

    private String curso;
    private String campi;
    private Float percentual;

}
