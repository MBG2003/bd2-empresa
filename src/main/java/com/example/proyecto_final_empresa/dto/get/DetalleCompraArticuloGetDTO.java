package com.example.proyecto_final_empresa.dto.get;

import com.example.proyecto_final_empresa.modelo.Articulo;
import com.example.proyecto_final_empresa.modelo.Compra;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class DetalleCompraArticuloGetDTO {

    private int codigoDetalle;
    private int cantidad;
    private Date fecha;

    private ArticuloGetDTO articulo;
    private CompraGetDTO compra;
}
