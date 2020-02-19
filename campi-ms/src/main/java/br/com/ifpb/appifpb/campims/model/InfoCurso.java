package br.com.ifpb.appifpb.campims.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InfoCurso {

    @Id
    @GeneratedValue
    private Integer id;
    private String campus;
    private String curso;
    private String situacao;

}
