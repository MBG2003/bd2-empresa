package com.example.proyecto_final_empresa.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "detallereservahospedaje")
public class DetalleReservaHospedaje implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "iddetalle", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detalle_reserva_hospedaje_seq")
    @SequenceGenerator(name = "detalle_reserva_hospedaje_seq", sequenceName = "DETALLE_RESERVA_HOSPEDAJE_SEQ", allocationSize = 1)
    private int idDetalle;

    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "codigoreservahospedaje", referencedColumnName = "codigoreservahospedaje", nullable = false)
    private ReservaHospedaje reservaHospedaje;

    @ManyToOne
    @JoinColumn(name = "habitacion_codigohabitacion", referencedColumnName = "codigohabitacion", nullable = false)
    private Habitacion habitacion;
}
