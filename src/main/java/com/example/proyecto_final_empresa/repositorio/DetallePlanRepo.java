package com.example.proyecto_final_empresa.repositorio;

import com.example.proyecto_final_empresa.modelo.DetallePlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePlanRepo extends JpaRepository<DetallePlan,Integer> {

}
