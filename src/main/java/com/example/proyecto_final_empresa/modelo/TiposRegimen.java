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
@Table(name = "tiposregimen")
public class TiposRegimen implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "codigotiporegimen", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_regimen_seq")
    @SequenceGenerator(name = "tipo_regimen_seq", sequenceName = "TIPO_REGIMEN_SEQ", allocationSize = 1)
    private int codigoTipoRegimen;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @OneToMany(mappedBy = "tiposRegimen")
    private List<TipoRegimenHospedaje> tipoRegimenHospedajes;
}
