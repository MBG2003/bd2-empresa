package com.example.proyecto_final_empresa.dto.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TipoRegimenGetDTO {

    private int codigoTipoRegimen;

    private String nombre;

    private String descripcion;
}
