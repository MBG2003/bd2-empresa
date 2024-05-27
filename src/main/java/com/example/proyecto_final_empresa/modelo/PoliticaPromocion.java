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
@Table(name = "politicapromocion")
public class PoliticaPromocion implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "idpolitica", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "politica_promocion_seq")
    @SequenceGenerator(name = "politica_promocion_seq", sequenceName = "POLITICA_PROMOCION_SEQ", allocationSize = 1)
    private int idPolitica;

    @Column(name = "porcentajedescuento", nullable = false)
    private int porcentajeDescuento;

    @Column(name = "cantidadpersonas", nullable = false)
    private int cantidadPersonas;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "codigoplan", referencedColumnName = "codigoplan", nullable = false, unique = true)
    private Plan plan;
}
