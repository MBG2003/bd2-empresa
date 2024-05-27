package com.example.proyecto_final_empresa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservaHospedajeDTO {

    private int codigoAgencia;

    private int codigoEmpleado;
    private int codigoCliente;

    private int idPoliticaCancelacion;
    private BigDecimal costoMoraDia;
    private int cantidadPersonas;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaReserva;
    private Date fechaRealizacion;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaFinEntrega;
    private List<Integer> codHabitaciones;
}