package com.example.proyecto_final_empresa.dto.get;

import com.example.proyecto_final_empresa.modelo.TipoAutomovil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class TipoMarcaAutoGetDTO {
    private int codigoTipoMarcaAuto;
    private String nombre;
    private String descripcion;

    //private List<TipoAutomovilGetDTO> tiposAutomovil;

}
