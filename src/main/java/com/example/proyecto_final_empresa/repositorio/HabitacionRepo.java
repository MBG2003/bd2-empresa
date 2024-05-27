package com.example.proyecto_final_empresa.repositorio;

import com.example.proyecto_final_empresa.modelo.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitacionRepo extends JpaRepository<Habitacion, Integer> {

    @Query("SELECT h FROM Habitacion h WHERE h.hospedaje.codigoHospedaje = :codigoHospedaje")
    List<Habitacion> listarHabitacionesHospedaje(int codigoHospedaje);
}
