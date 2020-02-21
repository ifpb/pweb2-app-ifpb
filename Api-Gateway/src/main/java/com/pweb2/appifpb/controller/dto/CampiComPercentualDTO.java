package com.pweb2.appifpb.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CampiComPercentualDTO {

    private String campus;
    private Float quant;
    private Float total;
    private Float percentual;
}
