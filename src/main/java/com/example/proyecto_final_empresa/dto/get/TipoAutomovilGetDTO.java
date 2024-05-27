package com.example.proyecto_final_empresa.dto.get;

import com.example.proyecto_final_empresa.modelo.TipoGama;
import com.example.proyecto_final_empresa.modelo.TipoMarcaAuto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class TipoAutomovilGetDTO {
    private int codigoTipoAutomovil;
    private String nombre;
    private String descripcion;
    private TipoMarcaAutoGetDTO tipoMarcaAuto;
    //private List<TipoGamaGetDTO> tiposGama;
}
