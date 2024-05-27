package com.example.proyecto_final_empresa.repositorio;

import com.example.proyecto_final_empresa.modelo.DetalleCompraPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DetalleCompraPlanRepo extends JpaRepository<DetalleCompraPlan, Integer> {
    @Query(value = "SELECT codigocompraplan FROM CompraPlan " +
            "MINUS " +
            "SELECT codigocompraplan FROM CancelacionPlan", nativeQuery = true)
    List<Integer> listarDetalleCompraSinCancelar();


    @Query("SELECT dcp FROM DetalleCompraPlan dcp WHERE dcp.compraPlan.codigoCompraPlan = :codigoCompra")
    List<DetalleCompraPlan> buscarPorCodigoCompra(int codigoCompra);
}
