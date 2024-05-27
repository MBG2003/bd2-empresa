package com.example.proyecto_final_empresa.servicios.interfaces;

import com.example.proyecto_final_empresa.dto.get.*;

import java.math.BigDecimal;
import java.util.List;

public interface HospedajeService {

    List<TipoRegimenGetDTO> listarTipoRegimen() throws Exception;

    List<HospedajeGetDTO> listarHospedaje() throws Exception;

    List<HospedajeGetDTO> filtroInstalaciones(int codigoInstalaciones) throws Exception;

    List<HospedajeGetDTO> filtroTipoHotel(int codigoTipoHotel) throws Exception;

    List<HospedajeGetDTO> filtroPrecioMin(BigDecimal precioMin) throws Exception;

    List<HospedajeGetDTO> filtroPrecioMax(BigDecimal precioMax) throws Exception;

    List<HospedajeGetDTO> filtroRangoPrecio(BigDecimal precioMin, BigDecimal precioMax) throws Exception;

    List<TipoHospedajeGetDTO> listarTipoHospedaje() throws Exception;

    List<InstalacionesGetDTO> listarInstalaciones() throws Exception;
}
