package com.example.proyecto_final_empresa.repositorio;

import com.example.proyecto_final_empresa.modelo.Hospedaje;
import com.example.proyecto_final_empresa.modelo.ReservaHospedaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface HospedajeRepo extends JpaRepository<Hospedaje, Integer> {

    @Query("SELECT h FROM Hospedaje h JOIN h.instalaciones i WHERE i.codigoInstalaciones = :codigoInstalaciones")
    List<Hospedaje> filtroInstalaciones(int codigoInstalaciones);

    @Query("SELECT h FROM Hospedaje h WHERE h.tipoHospedaje.codigoTipoHospedaje = :codigoTipoHotel")
    List<Hospedaje> filtroTipoHotel(int codigoTipoHotel);

    @Query("SELECT h FROM Hospedaje h JOIN h.habitaciones hab WHERE hab.precio > :precioMin")
    List<Hospedaje> filtroPrecioMin(BigDecimal precioMin);

    @Query("SELECT h FROM Hospedaje h JOIN h.habitaciones hab WHERE hab.precio < :precioMax")
    List<Hospedaje> filtroPrecioMax(BigDecimal precioMax);

    @Query("SELECT h FROM Hospedaje h JOIN h.habitaciones hab WHERE hab.precio BETWEEN :precioMin AND :precioMax")
    List<Hospedaje> filtroRangoPrecio(BigDecimal precioMin, BigDecimal precioMax);
}
