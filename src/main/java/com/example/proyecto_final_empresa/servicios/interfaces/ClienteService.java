package com.example.proyecto_final_empresa.servicios.interfaces;

import com.example.proyecto_final_empresa.dto.get.ClienteGetDTO;
import com.example.proyecto_final_empresa.modelo.Cliente;
import java.util.List;

public interface ClienteService {

    List<ClienteGetDTO> listar() throws Exception;

    Cliente buscar(int codigoCliente) throws Exception;

    ClienteGetDTO buscarDTO(int codigoCliente) throws Exception;

}
