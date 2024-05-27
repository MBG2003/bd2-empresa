package com.example.proyecto_final_empresa.dto.get;


import com.example.proyecto_final_empresa.modelo.Plan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class DetallePlanGetDTO {

    private int codigoDetallePlan;

    private int codigoPlan;

    private Date fechaInicio;

    private Date fechaFin;
}
