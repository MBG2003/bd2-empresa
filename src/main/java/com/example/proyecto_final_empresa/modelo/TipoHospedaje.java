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
@Table(name = "tipohospedaje")
public class TipoHospedaje implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "codigotipohospedaje", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_hospedaje_seq")
    @SequenceGenerator(name = "tipo_hospedaje_seq", sequenceName = "TIPO_HOSPEDAJE_SEQ", allocationSize = 1)
    private int codigoTipoHospedaje;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @OneToMany(mappedBy = "tipoHospedaje")
    private List<Hospedaje> hospedajes;
}
