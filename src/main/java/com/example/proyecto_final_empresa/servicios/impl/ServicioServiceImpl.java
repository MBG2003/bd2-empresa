package com.example.proyecto_final_empresa.servicios.impl;

import com.example.proyecto_final_empresa.dto.get.ServiciosGetDTO;
import com.example.proyecto_final_empresa.modelo.Servicios;
import com.example.proyecto_final_empresa.repositorio.ServiciosRepo;
import com.example.proyecto_final_empresa.servicios.interfaces.ServicioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ServicioServiceImpl implements ServicioService {

    private ServiciosRepo serviciosRepo;

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<ServiciosGetDTO> listarServicios() throws Exception {
        List<Servicios> servicios = serviciosRepo.findAll();
        List<ServiciosGetDTO> serviciosGetDTO = new ArrayList<>();

        for (Servicios s : servicios) {
            serviciosGetDTO.add(convertir(s));
        }

        return serviciosGetDTO;
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<ServiciosGetDTO> listarServiciosAutomovil(int codigoAutomovil) throws Exception {
        List<Servicios> servicios = serviciosRepo.listarServiciosAutomovil(codigoAutomovil);
        List<ServiciosGetDTO> serviciosGetDTO = new ArrayList<>();

        for (Servicios s : servicios) {
            serviciosGetDTO.add(convertir(s));
        }

        return serviciosGetDTO;
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public Servicios buscar(int codigoServicio) throws Exception {
        validar(codigoServicio);
        return serviciosRepo.findById(codigoServicio).get();
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public ServiciosGetDTO buscarDTO(int codigoServicio) throws Exception {
        return convertir(buscar(codigoServicio));
    }

    private ServiciosGetDTO convertir(Servicios servicio) {
        return new ServiciosGetDTO(
                servicio.getCodigoServicio(),
                servicio.getNombre(),
                servicio.getPrecio(),
                servicio.getDescripcion()
        );
    }

    private void validar(int codigoServicio) throws Exception {
        if(!serviciosRepo.existsById(codigoServicio)) {
            throw new Exception("No se encontró el servicio: " + codigoServicio);
        }
    }
}
