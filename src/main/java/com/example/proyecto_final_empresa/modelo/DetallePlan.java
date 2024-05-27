package com.example.proyecto_final_empresa.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "detalleplan")
public class DetallePlan implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "codigodetalleplan", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detalle_plan_seq")
    @SequenceGenerator(name = "detalle_plan_seq", sequenceName = "DETALLE_PLAN_SEQ", allocationSize = 1)
    private int codigoDetallePlan;

    @Column(name = "fechainicio", nullable = false)
    private Date fechaInicio;

    @Column(name = "fechafin", nullable = false)
    private Date fechaFin;

    @ManyToOne
    @JoinColumn(name = "codigoplan", referencedColumnName = "codigoplan", nullable = false, unique = true)
    private Plan plan;
}
