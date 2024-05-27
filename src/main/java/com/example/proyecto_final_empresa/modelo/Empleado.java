package com.example.proyecto_final_empresa.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "empleado")
public class Empleado implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "codigoempleado", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empleado_seq")
    @SequenceGenerator(name = "empleado_seq", sequenceName = "EMPLEADO_SEQ", allocationSize = 1)
    private int codigoEmpleado;

    @Column(nullable = false, length = 1)
    private char estado;

    @Column(name = "fechacontrato", nullable = false)
    private Date fechaContrato;

    @Column(nullable = false)
    private BigDecimal salario;

    @ManyToOne
    @JoinColumn(name = "codigopersona", referencedColumnName = "codigopersona", nullable = false, unique = true)
    private Persona persona;

    @OneToMany(mappedBy = "empleado")
    private List<ReservaHospedaje> reservaHospedajes;

    @OneToMany(mappedBy = "empleado")
    private List<AutomovilReserva> automovilReservas;
}
