package com.example.proyecto_final_empresa.dto.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ReservaHospedajeGetDTO {

    private int codigoReservaHospedaje;

    private AgenciaGetDTO agencia;

    private EmpleadoGetDTO empleado;

    private ClienteGetDTO cliente;

    private int idPoliticaCancelacion;

    private BigDecimal costoMoraDia;

    private int cantidadPersonas;

    private Date fechaReserva;

    private Date fechaRealizacion;

    private Date fechaFinEntrega;
}