package com.example.proyecto_final_empresa.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "detallereservaautomovil")
public class DetalleReservaAutomovil implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "codigo", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detalle_reserva_automovil_seq")
    @SequenceGenerator(name = "detalle_reserva_automovil_seq", sequenceName = "DETALLE_RESERVA_AUTOMOVIL_SEQ", allocationSize = 1)
    private int codigo;

    @Column(name = "preciototal")
    private BigDecimal precioTotal;

    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "codigoreservaautomovil", referencedColumnName = "codigoreserva", nullable = false)
    private AutomovilReserva automovilReserva;

    @ManyToOne
    @JoinColumn(name = "codigoautomovil", referencedColumnName = "codigoautomovil", nullable = false)
    private Automovil automovil;
}
