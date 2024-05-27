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
@Table(name = "reservahospedaje")
public class ReservaHospedaje implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "codigoreservahospedaje", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reserva_hospedaje_seq")
    @SequenceGenerator(name = "reserva_hospedaje_seq", sequenceName = "RESERVA_HOSPEDAJE_SEQ", allocationSize = 1)
    private int codigoReservaHospedaje;

    @Column(name = "costomoradia", nullable = false)
    private BigDecimal costoMoraDia;

    @Column(name = "fechareserva", nullable = false)
    private Date fechaReserva;

    @Column(name = "fecharealizacion")
    private Date fechaRealizacion;

    @Column(name = "fechafinentrega", nullable = false)
    private Date fechaFinEntrega;

    @Column(name = "cantidadpersonas", nullable = false)
    private int cantidadPersonas;

    @ManyToOne
    @JoinColumn(name = "codigoagencia", referencedColumnName = "codigo")
    private Agencia agencia;

    @ManyToOne
    @JoinColumn(name = "codigoempleado", referencedColumnName = "codigoempleado")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "cliente_codigocliente", referencedColumnName = "idcliente", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idpoliticacancelacion", referencedColumnName = "idpolitica")
    private PoliticaCancelacion politicaCancelacion;

    @OneToMany(mappedBy = "reservaHospedaje")
    private List<DetalleReservaHospedaje> detalles;

    @OneToMany(mappedBy = "reservaHospedaje")
    private List<CancelacionHospedaje> cancelaciones;
}
