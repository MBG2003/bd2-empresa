package com.example.proyecto_final_empresa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CancelarHospedajeDTO {
    private Date fecha;

    private BigDecimal costo;

    private int reservaHospedaje;
}
