package com.example.proyecto_final_empresa.dto.get;

import com.example.proyecto_final_empresa.modelo.Automovil;
import com.example.proyecto_final_empresa.modelo.TipoAutomovil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class TipoGamaGetDTO {

    private int codigoTipoGama;
    private String nombre;
    private String descripcion;
    private TipoAutomovilGetDTO tipoAutomovil;
    //private List<AutomovilGetDTO> automoviles;
}
