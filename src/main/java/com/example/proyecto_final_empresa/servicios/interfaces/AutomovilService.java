package com.example.proyecto_final_empresa.servicios.interfaces;

import com.example.proyecto_final_empresa.dto.get.AutomovilGetDTO;
import com.example.proyecto_final_empresa.modelo.Automovil;

import java.util.List;

public interface AutomovilService {

    List<AutomovilGetDTO> listarAutomoviles() throws Exception;

    Automovil buscar(int codigoAutomovil) throws Exception;

    AutomovilGetDTO buscarDTO(int codigoAutomovil) throws Exception;


}
