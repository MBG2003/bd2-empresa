package com.example.proyecto_final_empresa.servicios.impl;

import com.example.proyecto_final_empresa.dto.get.AgenciaGetDTO;
import com.example.proyecto_final_empresa.modelo.Agencia;
import com.example.proyecto_final_empresa.repositorio.AgenciaRepo;
import com.example.proyecto_final_empresa.servicios.interfaces.AgenciaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AgenciaServiceImpl implements AgenciaService {

    private AgenciaRepo agenciaRepo;

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<AgenciaGetDTO> listar() throws Exception {
        List<Agencia> agencias = agenciaRepo.findAll();
        List<AgenciaGetDTO> agenciasGetDTO = new ArrayList<>();

        for (Agencia a : agencias) {
            agenciasGetDTO.add(convertir(a));
        }

        return agenciasGetDTO;
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public Agencia buscar(int codigo) throws Exception {
        validar(codigo);
        return agenciaRepo.findById(codigo).get();
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public AgenciaGetDTO buscarDTO(int codigo) throws Exception {
        return convertir(buscar(codigo));
    }

    private AgenciaGetDTO convertir(Agencia agencia) {
        return new AgenciaGetDTO(
                agencia.getCodigo(),
                agencia.getNombre(),
                agencia.getNit()
        );
    }

    private void validar(int codigo) throws Exception {
        if(!agenciaRepo.existsById(codigo)) {
            throw new Exception("No se encontró la agencia: " + codigo);
        }
    }
}
