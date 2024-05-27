package com.example.proyecto_final_empresa.servicios.interfaces;

import com.example.proyecto_final_empresa.dto.get.ServiciosGetDTO;
import com.example.proyecto_final_empresa.modelo.Servicios;

import java.util.List;

public interface ServicioService {

    List<ServiciosGetDTO> listarServicios() throws Exception;

    List<ServiciosGetDTO> listarServiciosAutomovil(int codigoAutomovil) throws Exception;

    Servicios buscar(int codigoServicio) throws Exception;

    ServiciosGetDTO buscarDTO(int codigoServicio) throws Exception;
}
