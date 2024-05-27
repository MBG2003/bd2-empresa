package com.example.proyecto_final_empresa.servicios.interfaces;

import com.example.proyecto_final_empresa.dto.ReservaHospedajeDTO;
import com.example.proyecto_final_empresa.dto.get.ReservaHospedajeGetDTO;
import com.example.proyecto_final_empresa.modelo.ReservaHospedaje;

import java.math.BigDecimal;
import java.util.List;

public interface ReservaHospedajeService {

    /**
     * Genera una lista de todas las reservas realizadas
     * @return
     * @throws Exception
     */
    List<ReservaHospedajeGetDTO> listarReservaHospedaje() throws Exception;

    List<ReservaHospedajeGetDTO> listarReservaHospedajeSinCancelar() throws Exception;

    int crearReservaHospedaje(ReservaHospedajeDTO reserva) throws Exception;

    ReservaHospedaje buscar(int codigoReserva) throws Exception;

    ReservaHospedajeGetDTO buscarDTO(int codigoReserva) throws Exception;

    int consultarSigCodigo() throws Exception;
}
