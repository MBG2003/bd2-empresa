package com.example.proyecto_final_empresa.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "detallepoliticacancelacion")
public class DetallePoliticaCancelacion implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "codigodetalle", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detalle_poli_cancel_seq")
    @SequenceGenerator(name = "detalle_poli_cancel_seq", sequenceName = "DETALLE_POLI_CANCEL_SEQ", allocationSize = 1)
    private int codigoDetalle;

    @ManyToOne
    @JoinColumn(name = "idpoliticacancelacion", referencedColumnName = "idpolitica", nullable = false)
    private PoliticaCancelacion politicaCancelacion;
}
