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
@Table(name = "instalaciones")
public class Instalaciones implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "codigoinstalaciones", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "instalaciones_seq")
    @SequenceGenerator(name = "instalaciones_seq", sequenceName = "INSTALACIONES_SEQ", allocationSize = 1)
    private int codigoInstalaciones;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @ManyToMany(mappedBy = "instalaciones")
    private List<Hospedaje> hospedajes;
}
