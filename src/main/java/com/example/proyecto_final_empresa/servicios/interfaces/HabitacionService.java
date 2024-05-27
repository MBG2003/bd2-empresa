package com.example.proyecto_final_empresa.servicios.interfaces;

import com.example.proyecto_final_empresa.dto.get.HabitacionGetDTO;
import com.example.proyecto_final_empresa.dto.get.NivelGetDTO;
import com.example.proyecto_final_empresa.modelo.Habitacion;

import java.util.List;

public interface HabitacionService {

    List<HabitacionGetDTO> listar() throws Exception;

    List<HabitacionGetDTO> listarHabitacionesHospedaje(int codigoHospedaje) throws Exception;

    List<NivelGetDTO> listarNivel() throws Exception;

    Habitacion buscar(int codigoHabitacion) throws Exception;

    HabitacionGetDTO buscarDTO(int codigoHabitacion) throws Exception;
}
