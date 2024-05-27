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
@Table(name = "automovil_reserva")
public class AutomovilReserva implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "codigoreserva", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "automovil_reserva_seq")
    @SequenceGenerator(name = "automovil_reserva_seq", sequenceName = "AUTOMOVIL_RESERVA_SEQ", allocationSize = 1)
    private int codigoReserva;

    @Column(name = "costomoradia", nullable = false)
    private String costoMoraDia;

    @Column(name = "fechareserva", nullable = false)
    private Date fechaReserva;

    @Column(name = "fechaentrega", nullable = false)
    private Date fechaEntrega;

    @ManyToOne
    @JoinColumn(name = "codigoagencia", referencedColumnName = "codigo")
    private Agencia agencia;

    @ManyToOne
    @JoinColumn(name = "codigoempleado", referencedColumnName = "codigoempleado")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "codigocliente", referencedColumnName = "idcliente", nullable = false)
    private Cliente cliente;

    @ManyToMany
    @JoinTable(name = "reservaservicio",
            joinColumns = {@JoinColumn(name = "automovil_reserva", referencedColumnName = "codigoreserva")},
            inverseJoinColumns = {@JoinColumn(name = "codigoservicio", referencedColumnName = "codigoservicio")})
    private List<Servicios> servicios;

    @OneToMany(mappedBy = "automovilReserva")
    private List<DetalleReservaAutomovil> detallesReserva;
}
