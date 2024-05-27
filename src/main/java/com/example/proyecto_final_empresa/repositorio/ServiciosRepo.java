package com.example.proyecto_final_empresa.repositorio;

import com.example.proyecto_final_empresa.modelo.Instalaciones;
import com.example.proyecto_final_empresa.modelo.Servicios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiciosRepo extends JpaRepository<Servicios, Integer> {

    @Query("SELECT s FROM Servicios s JOIN s.automoviles a WHERE a.codigoAutomovil = :codigoAutomovil")
    List<Servicios> listarServiciosAutomovil(int codigoAutomovil);
}
