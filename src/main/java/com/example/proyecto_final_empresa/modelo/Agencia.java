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
@Table(name = "agencia")
public class Agencia implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "codigo", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agencia_seq")
    @SequenceGenerator(name = "agencia_seq", sequenceName = "AGENCIA_SEQ", allocationSize = 1)
    private int codigo;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private int nit;

    @OneToMany(mappedBy = "agencia")
    private List<ReservaHospedaje> reservasHospedaje;

    @OneToMany(mappedBy = "agencia")
    private List<AutomovilReserva> reservasAutomovil;
}
