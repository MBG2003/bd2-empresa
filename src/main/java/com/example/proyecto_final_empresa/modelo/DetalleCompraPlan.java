package com.example.proyecto_final_empresa.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "detallecompraplan")
public class DetalleCompraPlan implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "codigodetalle", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detalle_compra_plan_seq")
    @SequenceGenerator(name = "detalle_compra_plan_seq", sequenceName = "DETALLE_COMPRA_PLAN_SEQ", allocationSize = 1)
    private int codigoDetalle;

    @Column(nullable = false)
    private BigDecimal costo;

    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = false)
    private int descuento;

    @ManyToOne
    @JoinColumn(name = "codigocompraplan", referencedColumnName = "codigocompraplan", nullable = false)
    private CompraPlan compraPlan;

    @ManyToOne
    @JoinColumn(name = "codigoplan", referencedColumnName = "codigoplan", nullable = false)
    private Plan plan;
}
