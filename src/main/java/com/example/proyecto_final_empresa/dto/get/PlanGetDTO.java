package com.example.proyecto_final_empresa.dto.get;

import com.example.proyecto_final_empresa.modelo.DetalleCompraPlan;
import com.example.proyecto_final_empresa.modelo.DetallePlan;
import com.example.proyecto_final_empresa.modelo.PoliticaPromocion;
import com.example.proyecto_final_empresa.modelo.TipoPlan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PlanGetDTO {
    private int codigoPlan;
    private String nombre;
    private int precioUnidad;
    private int cantidadPersona;
    private String descripcion;
    private TipoPlanGetDTO tipoPlan;
    private List<DetallePlanGetDTO> detalles;
    private List<PoliticaPromocionGetDTO> politicasPromocion;
    //private List<DetalleCompraPlanGetDTO> detallesCompraPlan;
}
