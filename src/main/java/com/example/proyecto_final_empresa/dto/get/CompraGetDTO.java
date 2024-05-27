package com.example.proyecto_final_empresa.dto.get;

import com.example.proyecto_final_empresa.modelo.Cliente;
import com.example.proyecto_final_empresa.modelo.DetalleCompraArticulo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CompraGetDTO {

    private int codigoCompra;
    private Date fechaCompra;
    private BigDecimal total;

    private ClienteGetDTO cliente;
    private List<DetalleCompraArticuloGetDTO> detalles;
}
