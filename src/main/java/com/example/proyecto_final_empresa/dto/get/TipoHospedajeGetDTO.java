package com.example.proyecto_final_empresa.dto.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TipoHospedajeGetDTO {

    private int codigoTipoHospedaje;

    private String nombre;

    private String descripcion;
}
