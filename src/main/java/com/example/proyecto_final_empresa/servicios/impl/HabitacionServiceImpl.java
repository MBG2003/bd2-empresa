package com.example.proyecto_final_empresa.servicios.impl;

import com.example.proyecto_final_empresa.dto.get.HabitacionGetDTO;
import com.example.proyecto_final_empresa.dto.get.NivelGetDTO;
import com.example.proyecto_final_empresa.modelo.Habitacion;
import com.example.proyecto_final_empresa.modelo.Nivel;
import com.example.proyecto_final_empresa.repositorio.HabitacionRepo;
import com.example.proyecto_final_empresa.repositorio.NivelRepo;
import com.example.proyecto_final_empresa.servicios.interfaces.HabitacionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class HabitacionServiceImpl implements HabitacionService {

    private HabitacionRepo habitacionRepo;

    private NivelRepo nivelRepo;

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<HabitacionGetDTO> listar() throws Exception {
        List<Habitacion> habitaciones = habitacionRepo.findAll();
        List<HabitacionGetDTO> habitacionesGetDTO = new ArrayList<>();

        for (Habitacion h : habitaciones) {
            habitacionesGetDTO.add(convertir(h));
        }

        return habitacionesGetDTO;
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<HabitacionGetDTO> listarHabitacionesHospedaje(int codigoHospedaje) throws Exception {
        List<Habitacion> habitaciones = habitacionRepo.listarHabitacionesHospedaje(codigoHospedaje);
        List<HabitacionGetDTO> habitacionesGetDTO = new ArrayList<>();

        for (Habitacion h : habitaciones) {
            habitacionesGetDTO.add(convertir(h));
        }

        return habitacionesGetDTO;
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<NivelGetDTO> listarNivel() throws Exception {
        List<Nivel> niveles = nivelRepo.findAll();
        List<NivelGetDTO> nivelesGetDTO = new ArrayList<>();

        for (Nivel n : niveles) {
            nivelesGetDTO.add(convertirNivel(n));
        }

        return nivelesGetDTO;
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public Habitacion buscar(int codigoHabitacion) throws Exception {
        validar(codigoHabitacion);
        return habitacionRepo.findById(codigoHabitacion).get();
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public HabitacionGetDTO buscarDTO(int codigoHabitacion) throws Exception {
        return convertir(buscar(codigoHabitacion));
    }

    private HabitacionGetDTO convertir(Habitacion habitacion) {
        return new HabitacionGetDTO(
                habitacion.getCodigoHabitacion(),
                convertirNivel(habitacion.getNivel()),
                habitacion.getHospedaje().getCodigoHospedaje(),
                habitacion.getNombre(),
                habitacion.getEstado(),
                habitacion.getPrecio(),
                habitacion.getDescripcion(),
                habitacion.getCantidadHabitacion()
        );
    }

    private NivelGetDTO convertirNivel(Nivel nivel) {
        return new NivelGetDTO(
                nivel.getCodigoNivel(),
                nivel.getNombre(),
                nivel.getDescripcion()
        );
    }

    private void validar(int codigoHabitacion) throws Exception {
        if(!habitacionRepo.existsById(codigoHabitacion)) {
            throw new Exception("No se encontró la habitación: " + codigoHabitacion);
        }
    }
}
