package com.example.proyecto_final_empresa.servicios.interfaces;

import com.example.proyecto_final_empresa.dto.get.CancelarHospedajeGetDTO;
import com.example.proyecto_final_empresa.dto.get.ReservaHospedajeGetDTO;

import java.util.List;

public interface CancelarHospedajeService {

    //Se debe cambiar
    List<CancelarHospedajeGetDTO> listar() throws Exception;

}
