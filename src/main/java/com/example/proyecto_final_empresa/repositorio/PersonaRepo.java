package com.example.proyecto_final_empresa.repositorio;

import com.example.proyecto_final_empresa.modelo.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepo extends JpaRepository<Persona,Integer> {
}
