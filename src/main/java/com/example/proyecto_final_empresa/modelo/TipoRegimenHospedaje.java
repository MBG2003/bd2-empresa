package com.example.proyecto_final_empresa.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tiporegimen_hospedaje")
public class TipoRegimenHospedaje implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "codigo", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_regimen_hospedaje_seq")
    @SequenceGenerator(name = "tipo_regimen_hospedaje_seq", sequenceName = "TIPO_REGIMEN_HOSPEDAJE_SEQ", allocationSize = 1)
    private int codigo;

    @Column(nullable = false)
    private BigDecimal precio;

    @ManyToOne
    @JoinColumn(name = "codigohospedaje", referencedColumnName = "codigohospedaje", nullable = false)
    private Hospedaje hospedaje;

    @ManyToOne
    @JoinColumn(name = "codigotiporegimen", referencedColumnName = "codigotiporegimen", nullable = false)
    private TiposRegimen tiposRegimen;
}
