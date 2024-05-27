package com.example.proyecto_final_empresa.servicios.impl;

import com.example.proyecto_final_empresa.dto.get.ClienteGetDTO;
import com.example.proyecto_final_empresa.dto.get.PersonaGetDTO;
import com.example.proyecto_final_empresa.modelo.Cliente;
import com.example.proyecto_final_empresa.repositorio.ClienteRepo;
import com.example.proyecto_final_empresa.servicios.interfaces.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepo clienteRepo;

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<ClienteGetDTO> listar() throws Exception {
        List<Cliente> clientes = clienteRepo.findAll();
        List<ClienteGetDTO> clientesGetDTO = new ArrayList<>();

        for (Cliente c : clientes) {
            clientesGetDTO.add(convertir(c));
        }
        return clientesGetDTO;
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public Cliente buscar(int codigoCliente) throws Exception {
        validar(codigoCliente);
        return clienteRepo.findById(codigoCliente).get();
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public ClienteGetDTO buscarDTO(int codigoCliente) throws Exception {
        return convertir(buscar(codigoCliente));
    }

    private ClienteGetDTO convertir(Cliente cliente) {
        return new ClienteGetDTO(
                cliente.getIdCliente(),
                new PersonaGetDTO(
                        cliente.getPersona().getCodigoPersona(),
                        cliente.getPersona().getNombre(),
                        cliente.getPersona().getFechaNacimiento(),
                        cliente.getPersona().getCorreo(),
                        cliente.getPersona().getTelefono()
                )
        );
    }

    private void validar(int codigoCliente) throws Exception {
        if(!clienteRepo.existsById(codigoCliente)) {
            throw new Exception("No se encontró el cliente: " + codigoCliente);
        }
    }
}
