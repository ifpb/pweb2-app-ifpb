package br.com.ifpb.appifpb.campims.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MatriculaLimpa {

    @Id
    @GeneratedValue
    private Integer id;
    private String curso;
    private String campus;
    private Float quantMatriculasLimpas;
    private Float totalAluno;

}
