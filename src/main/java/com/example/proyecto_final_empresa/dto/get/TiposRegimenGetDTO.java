package com.example.proyecto_final_empresa.dto.get;

import com.example.proyecto_final_empresa.modelo.TipoRegimenHospedaje;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class TiposRegimenGetDTO {
    private int codigoTipoRegimen;
    private String nombre;
    private String descripcion;

    private List<TipoRegimenHospedajeGetDTO> tipoRegimenHospedajes;
}
