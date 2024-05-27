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
@Table(name = "nivel")
public class Nivel implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "codigonivel", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nivel_seq")
    @SequenceGenerator(name = "nivel_seq", sequenceName = "NIVEL_SEQ", allocationSize = 1)
    private int codigoNivel;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @OneToMany(mappedBy = "nivel")
    private List<Habitacion> habitaciones;
}
