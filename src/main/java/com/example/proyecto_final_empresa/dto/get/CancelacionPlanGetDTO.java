package com.example.proyecto_final_empresa.dto.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class CancelacionPlanGetDTO {

    private int codigo;

    private Date fechaPolitica;

    private BigDecimal costo;

}
