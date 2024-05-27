package com.example.proyecto_final_empresa.dto.get;

import com.example.proyecto_final_empresa.modelo.Plan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class PoliticaCancelacionGetDTO {

    private int idPolitica;
    private BigDecimal precioNochePersona;
    private int fechaPoliticaDias;
    private String descripcion;

    private PlanGetDTO plan;
}
