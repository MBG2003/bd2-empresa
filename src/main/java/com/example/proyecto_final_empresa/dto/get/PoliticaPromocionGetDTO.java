package com.example.proyecto_final_empresa.dto.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PoliticaPromocionGetDTO {

    private int idPolitica;

    private int codigoPlan;

    private int porcentajeDescuento;

    private int cantidadPersonas;

    private String descripcion;
}
