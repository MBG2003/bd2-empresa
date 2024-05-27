package com.example.proyecto_final_empresa.repositorio;

import com.example.proyecto_final_empresa.modelo.Agencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenciaRepo extends JpaRepository<Agencia, Integer> {

}