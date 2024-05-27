package com.example.proyecto_final_empresa.repositorio;

import com.example.proyecto_final_empresa.modelo.ReservaHospedaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ReservaHospedajeRepo extends JpaRepository<ReservaHospedaje, Integer> {

    @Query("SELECT COUNT(rh.codigoReservaHospedaje) FROM ReservaHospedaje rh")
    int consultarCantResgistros();

    @Query(value = "SELECT codigoreservahospedaje FROM ReservaHospedaje " +
            "MINUS " +
            "SELECT codigoreservahospedaje FROM CancelacionHospedaje", nativeQuery = true)
    List<Integer> listarReservasSinCancelar();

}
