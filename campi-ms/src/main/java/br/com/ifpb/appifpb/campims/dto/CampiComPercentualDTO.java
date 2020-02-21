package br.com.ifpb.appifpb.campims.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CampiComPercentualDTO {

    private Integer id;
    private String campus;
    private Float quant;
    private Float total;
    private Float percentual;
}
