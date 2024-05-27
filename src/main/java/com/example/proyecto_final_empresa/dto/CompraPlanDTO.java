package com.example.proyecto_final_empresa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompraPlanDTO {
    private Date fechaReserva;
    private int codigoPlan;
    private int cantidadPersonas;
    private int codigoCliente;
    private int codigoEmpleado;
    private int codigoAgencia;
}
