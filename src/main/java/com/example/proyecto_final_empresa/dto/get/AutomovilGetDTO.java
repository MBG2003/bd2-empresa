package com.example.proyecto_final_empresa.dto.get;


import com.example.proyecto_final_empresa.modelo.DetalleReservaAutomovil;
import com.example.proyecto_final_empresa.modelo.Servicios;
import com.example.proyecto_final_empresa.modelo.TipoGama;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class AutomovilGetDTO {

    private int codigoAutomovil;
    private String nombre;
    private int capacidadMax;
    private String estado;
    private char disponible;
    private BigDecimal precio;
    private TipoGamaGetDTO tipoGama;
    //private List<ServiciosGetDTO> servicios;
}
