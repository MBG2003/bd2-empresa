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
@Table(name = "cliente")
public class Cliente implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "idcliente", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq")
    @SequenceGenerator(name = "cliente_seq", sequenceName = "CLIENTE_SEQ", allocationSize = 1)
    private int idCliente;

    @OneToMany(mappedBy = "cliente")
    private List<ReservaHospedaje> reservasHospedaje;

    @OneToMany(mappedBy = "cliente")
    private List<AutomovilReserva> reservasAutomovil;

    @ManyToOne
    @JoinColumn(name = "codigopersona", referencedColumnName = "codigopersona", nullable = false, unique = true)
    private Persona persona;
}
