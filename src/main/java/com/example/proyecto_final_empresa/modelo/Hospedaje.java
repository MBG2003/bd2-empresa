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
@Table(name = "hospedaje")
public class Hospedaje implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "codigohospedaje", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hospedaje_seq")
    @SequenceGenerator(name = "hospedaje_seq", sequenceName = "HOSPEDAJE_SEQ", allocationSize = 1)
    private int codigoHospedaje;

    @ManyToOne
    @JoinColumn(name = "codigotipohospedaje", referencedColumnName = "codigotipohospedaje", nullable = false)
    private TipoHospedaje tipoHospedaje;

    @OneToMany(mappedBy = "hospedaje")
    private List<TipoRegimenHospedaje> tipoRegimenHospedajes;

    @OneToMany(mappedBy = "hospedaje")
    private List<Habitacion> habitaciones;

    @ManyToMany
    @JoinTable(name = "instalaciones_hospedaje",
            joinColumns = {@JoinColumn(name = "codigohospedaje", referencedColumnName = "codigohospedaje", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "codigoinstalaciones", referencedColumnName = "codigoinstalaciones", nullable = false)})
    private List<Instalaciones> instalaciones;
}
