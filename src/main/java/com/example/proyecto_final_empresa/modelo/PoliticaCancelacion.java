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
@Table(name = "politicacancelacion")
public class PoliticaCancelacion implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "idpolitica", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "politica_cancelacion_seq")
    @SequenceGenerator(name = "politica_cancelacion_seq", sequenceName = "POLITICA_CANCELACION_SEQ", allocationSize = 1)
    private int idPolitica;

    @Column(name = "precionochepersona", nullable = false)
    private BigDecimal precioNochePersona;

    @Column(name = "fechapoliticadias", nullable = false)
    private int fechaPoliticaDias;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "plan_codigoplan", referencedColumnName = "codigoplan", nullable = false)
    private Plan plan;
}
