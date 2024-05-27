package com.example.proyecto_final_empresa.dto.get;

import com.example.proyecto_final_empresa.modelo.DetalleCompraArticulo;
import com.example.proyecto_final_empresa.modelo.TipoArticulo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ArticuloGetDTO {

    private int codigoArticulo;

    private String nombre;

    private BigDecimal precio;

    private String descripcion;

    private TipoArticuloGetDTO tipoArticulo;

}
