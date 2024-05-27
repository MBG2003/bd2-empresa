package com.example.proyecto_final_empresa.dto.get;

import com.example.proyecto_final_empresa.modelo.Articulo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class TipoArticuloGetDTO {
    private int codigo;
    private String nombre;
    private String descripcion;
}
