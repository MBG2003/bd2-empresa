package com.example.proyecto_final_empresa.servicios.interfaces;

import com.example.proyecto_final_empresa.dto.ReservaAutomovilDTO;
import com.example.proyecto_final_empresa.dto.get.AutomovilGetDTO;
import com.example.proyecto_final_empresa.dto.get.ReservaAutomovilGetDTO;

import java.util.List;

public interface ReservaAutomovilService {

    List<ReservaAutomovilGetDTO> listarReservaAutomovil() throws Exception;

    int crearReservaAutomovil(ReservaAutomovilDTO reserva) throws Exception;
}
