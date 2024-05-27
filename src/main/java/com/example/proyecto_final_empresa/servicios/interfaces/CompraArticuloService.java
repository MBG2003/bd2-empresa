package com.example.proyecto_final_empresa.servicios.interfaces;

import com.example.proyecto_final_empresa.dto.get.CompraArticuloGetDTO;
import com.example.proyecto_final_empresa.dto.get.ReservaHospedajeGetDTO;

import java.util.List;

public interface CompraArticuloService {

    //toca cambiarlos
    List<CompraArticuloGetDTO> listar() throws Exception;

}
