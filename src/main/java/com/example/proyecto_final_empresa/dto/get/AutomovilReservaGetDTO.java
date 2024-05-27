package com.example.proyecto_final_empresa.dto.get;

import com.example.proyecto_final_empresa.modelo.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class AutomovilReservaGetDTO {

    private int codigoReserva;
    private int capacidadMax;
    private String costoMoraDia;
    private Date fechaReserva;
    private AgenciaGetDTO agencia;
    private EmpleadoGetDTO empleado;
    private ClienteGetDTO cliente;
    private List<ServiciosGetDTO> servicios;
    private List<DetalleReservaAutomovilGetDTO> detallesReserva;

}
