package com.example.proyecto_final_empresa.dto.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class HabitacionGetDTO {

    private int codigoHabitacion;

    private NivelGetDTO nivel;

    private int codigoHospedaje;

    private String nombre;

    private char estado;

    private BigDecimal precio;

    private String descripcion;

    private int cantidadHabitacion;
}
