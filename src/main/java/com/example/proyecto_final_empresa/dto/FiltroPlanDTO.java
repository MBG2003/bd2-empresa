package com.example.proyecto_final_empresa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FiltroPlanDTO {

    private BigDecimal precioMin;

    private BigDecimal precioMax;

    private int codigoPlan;
    private int codigoTipoPlan;
}
