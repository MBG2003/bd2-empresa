package com.example.proyecto_final_empresa.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "habitacion")
public class Habitacion implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "codigohabitacion", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "habitacion_seq")
    @SequenceGenerator(name = "habitacion_seq", sequenceName = "HABITACION_SEQ", allocationSize = 1)
    private int codigoHabitacion;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, length = 1)
    private char estado;

    @Column(nullable = false)
    private BigDecimal precio;

    @Column(nullable = false)
    private String descripcion;

    @Column(name = "cantidadhabitacion", nullable = false)
    private int cantidadHabitacion;

    @ManyToOne
    @JoinColumn(name = "codigohospedaje", referencedColumnName = "codigohospedaje", nullable = false)
    private Hospedaje hospedaje;

    @ManyToOne
    @JoinColumn(name = "codigonivel", referencedColumnName = "codigonivel", nullable = false)
    private Nivel nivel;

    @OneToMany(mappedBy = "habitacion")
    private List<DetalleReservaHospedaje> detallesReserva;
}
