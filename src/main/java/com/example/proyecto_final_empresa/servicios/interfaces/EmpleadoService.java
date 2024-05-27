package com.example.proyecto_final_empresa.servicios.interfaces;

import com.example.proyecto_final_empresa.dto.get.EmpleadoGetDTO;
import com.example.proyecto_final_empresa.modelo.Empleado;

import java.util.List;

public interface EmpleadoService {

    List<EmpleadoGetDTO> listar() throws Exception;

    Empleado buscar(int codigoEmpleado) throws Exception;

    EmpleadoGetDTO buscarDTO(int codigoEmpleado) throws Exception;
}
