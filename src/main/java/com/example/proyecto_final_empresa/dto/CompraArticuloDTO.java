package com.example.proyecto_final_empresa.dto;

import com.example.proyecto_final_empresa.dto.get.DetalleCompraArticuloGetDTO;
import com.example.proyecto_final_empresa.modelo.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompraArticuloDTO {
    private Date fechaCompra;
    private BigDecimal total;
    private int cantidadPersonas;
    private int codigoCliente;
    private int codigoEmpleado;
    private List<DetalleCompraArticuloGetDTO> detalles;
}
