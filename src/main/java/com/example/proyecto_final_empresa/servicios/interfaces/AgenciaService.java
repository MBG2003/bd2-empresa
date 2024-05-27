package com.example.proyecto_final_empresa.servicios.interfaces;

import com.example.proyecto_final_empresa.dto.get.AgenciaGetDTO;
import com.example.proyecto_final_empresa.modelo.Agencia;

import java.util.List;

public interface AgenciaService {

    List<AgenciaGetDTO> listar() throws Exception;

    Agencia buscar(int codigo) throws Exception;

    AgenciaGetDTO buscarDTO(int codigo) throws Exception;
}
