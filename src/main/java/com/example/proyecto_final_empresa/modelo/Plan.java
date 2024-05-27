package com.example.proyecto_final_empresa.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "plan")
public class Plan implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "codigoplan", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "plan_seq")
    @SequenceGenerator(name = "plan_seq", sequenceName = "PLAN_SEQ", allocationSize = 1)
    private int codigoPlan;

    @Column(nullable = false)
    private String nombre;

    @Column(name = "preciounidad", nullable = false)
    private int precioUnidad;

    @Column(name = "cantidadpersona", nullable = false)
    private int cantidadPersona;

    @Column(nullable = false)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "codigo_tipoplan", referencedColumnName = "codigo", nullable = false)
    private TipoPlan tipoPlan;

    @OneToMany(mappedBy = "plan")
    private List<DetallePlan> detalles;

    @OneToMany(mappedBy = "plan")
    private List<PoliticaPromocion> politicasPromocion;

    @OneToMany(mappedBy = "plan")
    private List<DetalleCompraPlan> detallesCompraPlan;
}
