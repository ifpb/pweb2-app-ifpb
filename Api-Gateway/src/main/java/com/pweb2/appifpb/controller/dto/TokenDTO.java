package com.pweb2.appifpb.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class TokenDTO implements Serializable {
    private String token;
}
