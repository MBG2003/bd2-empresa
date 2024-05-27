package com.example.proyecto_final_empresa.repositorio;

import com.example.proyecto_final_empresa.modelo.CompraPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraPlanRepo extends JpaRepository<CompraPlan,Integer> {

    /**
     * select cp.codigocompraplan from compraplan cp
     * minus
     * select canp.codigocompraplan from cancelacionplan canp;
     */
}
