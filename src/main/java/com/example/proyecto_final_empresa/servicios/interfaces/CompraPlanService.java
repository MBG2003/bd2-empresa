package com.example.proyecto_final_empresa.servicios.interfaces;

import com.example.proyecto_final_empresa.dto.CompraPlanDTO;
import com.example.proyecto_final_empresa.dto.get.DetalleCompraPlanGetDTO;

import java.util.List;

public interface CompraPlanService {

    List<DetalleCompraPlanGetDTO> listarDetallesCompras() throws Exception;

    List<DetalleCompraPlanGetDTO> listarDetallesComprasSinCancelar() throws Exception;

    int crearCompraPlan(CompraPlanDTO compraPlanDTO) throws Exception;

}
