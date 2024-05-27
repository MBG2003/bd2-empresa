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
@Table(name = "cancelacionhospedaje")
public class CancelacionHospedaje implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "codigo", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cancelacion_hospedaje_seq")
    @SequenceGenerator(name = "cancelacion_hospedaje_seq", sequenceName = "CANCELACION_HOSPEDAJE_SEQ", allocationSize = 1)
    private int codigo;

    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private BigDecimal costo;

    @ManyToOne
    @JoinColumn(name = "codigoreservahospedaje", referencedColumnName = "codigoreservahospedaje", nullable = false, unique = true)
    private ReservaHospedaje reservaHospedaje;
}
