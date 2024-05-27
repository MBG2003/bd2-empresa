package com.example.proyecto_final_empresa.dto;

import com.example.proyecto_final_empresa.dto.get.DetalleReservaAutomovilGetDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservaAutomovilDTO {

    private int codigoAutomovil;
    private int capacidadMax;
    private String costoMoraDia;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaEntrega;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaReserva;
    private int codigoAgencia;
    private int codigoEmpleado;
    private int codigoCliente;
    private List<Integer> codServicios;
    private List<DetalleReservaAutomovilGetDTO> detallesReserva;
}
