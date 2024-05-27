package com.example.proyecto_final_empresa.servicios.impl;

import com.example.proyecto_final_empresa.dto.get.EmpleadoGetDTO;
import com.example.proyecto_final_empresa.dto.get.PersonaGetDTO;
import com.example.proyecto_final_empresa.modelo.Empleado;
import com.example.proyecto_final_empresa.repositorio.EmpleadoRepo;
import com.example.proyecto_final_empresa.servicios.interfaces.EmpleadoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService {

    private EmpleadoRepo empleadoRepo;

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<EmpleadoGetDTO> listar() throws Exception {
        List<Empleado> empleados = empleadoRepo.findAll();
        List<EmpleadoGetDTO> empleadosGetDTO = new ArrayList<>();

        for (Empleado e : empleados) {
            empleadosGetDTO.add(convertir(e));
        }

        return empleadosGetDTO;
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public Empleado buscar(int codigoEmpleado) throws Exception {
        validar(codigoEmpleado);
        return empleadoRepo.findById(codigoEmpleado).get();
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public EmpleadoGetDTO buscarDTO(int codigoEmpleado) throws Exception {
        return convertir(buscar(codigoEmpleado));
    }

    private EmpleadoGetDTO convertir(Empleado e) {
        return new EmpleadoGetDTO(
                e.getCodigoEmpleado(),
                e.getEstado(),
                e.getFechaContrato(),
                e.getSalario(),
                new PersonaGetDTO(
                        e.getPersona().getCodigoPersona(),
                        e.getPersona().getNombre(),
                        e.getPersona().getFechaNacimiento(),
                        e.getPersona().getCorreo(),
                        e.getPersona().getTelefono()
                )
        );
    }

    private void validar(int codigoEmpleado) throws Exception {
        if(!empleadoRepo.existsById(codigoEmpleado)) {
            throw new Exception("No se encontró el empleado: " + codigoEmpleado);
        }
    }
}
