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
@Table(name = "servicios")
public class Servicios implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "codigoservicio", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "servicios_seq")
    @SequenceGenerator(name = "servicios_seq", sequenceName = "SERVICIOS_SEQ", allocationSize = 1)
    private int codigoServicio;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private BigDecimal precio;

    @Column(nullable = false)
    private String descripcion;

    @ManyToMany(mappedBy = "servicios")
    private List<Automovil> automoviles;

    @ManyToMany(mappedBy = "servicios")
    private List<AutomovilReserva> automovilReservas;
}
