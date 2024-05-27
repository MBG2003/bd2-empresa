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
@Table(name = "cancelacionplan")
public class CancelacionPlan implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "codigo",nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cancelacion_plan_seq")
    @SequenceGenerator(name = "cancelacion_plan_seq", sequenceName = "CANCELACION_PLAN_SEQ", allocationSize = 1)
    private int codigo;

    @Column(name = "fechapolitica", nullable = false)
    private Date fechaPolitica;

    @Column(nullable = false)
    private BigDecimal costo;

    @ManyToOne
    @JoinColumn(name = "codigocompraplan", referencedColumnName = "codigocompraplan", nullable = false)
    private CompraPlan compraPlan;
}
