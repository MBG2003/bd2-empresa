package com.example.proyecto_final_empresa.dto.get;

import com.example.proyecto_final_empresa.modelo.Automovil;
import com.example.proyecto_final_empresa.modelo.AutomovilReserva;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class DetalleReservaAutomovilGetDTO {

    private int codigo;
    private BigDecimal precioTotal;
    private Date fecha;
    private AutomovilGetDTO automovil;

}
