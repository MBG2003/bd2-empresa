package com.example.proyecto_final_empresa.repositorio;

import com.example.proyecto_final_empresa.modelo.DetalleCompraArticulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleCompraArticuloRepo extends JpaRepository<DetalleCompraArticulo,Integer> {
}
