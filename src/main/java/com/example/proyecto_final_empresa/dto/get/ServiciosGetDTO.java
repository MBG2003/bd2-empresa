package com.example.proyecto_final_empresa.dto.get;

import com.example.proyecto_final_empresa.modelo.Automovil;
import com.example.proyecto_final_empresa.modelo.AutomovilReserva;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ServiciosGetDTO {

    private int codigoServicio;
    private String nombre;
    private BigDecimal precio;
    private String descripcion;

    //private List<AutomovilGetDTO> automoviles;
    //private List<AutomovilReservaGetDTO> automovilReservas;

}
