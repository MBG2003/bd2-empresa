package com.example.proyecto_final_empresa.dto.get;

import com.example.proyecto_final_empresa.modelo.CompraPlan;
import com.example.proyecto_final_empresa.modelo.Plan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class DetalleCompraPlanGetDTO {
    private int codigoDetalle;
    private BigDecimal costo;
    private int cantidad;
    private int descuento;
    private CompraPlanGetDTO compraPlan;
    private PlanGetDTO plan;
}
