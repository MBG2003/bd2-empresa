package com.example.proyecto_final_empresa.repositorio;

import com.example.proyecto_final_empresa.modelo.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloRepo extends JpaRepository<Articulo, Integer> {
}
