package com.example.proyecto_final_empresa.servicios.interfaces;

import com.example.proyecto_final_empresa.dto.get.ArticuloGetDTO;
import com.example.proyecto_final_empresa.modelo.Articulo;

import java.util.List;

public interface ArticuloService {

    List<ArticuloGetDTO> listarArticulos() throws Exception;

    Articulo buscar(int codigoArticulo) throws Exception;

    ArticuloGetDTO buscarDTO(int codigoArticulo) throws Exception;
}
