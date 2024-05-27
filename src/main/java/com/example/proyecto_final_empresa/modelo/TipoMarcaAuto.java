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
@Table(name = "tipomarcaauto")
public class TipoMarcaAuto implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "codigotipomarcaauto", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_marca_auto_seq")
    @SequenceGenerator(name = "tipo_marca_auto_seq", sequenceName = "TIPO_MARCA_AUTO_SEQ", allocationSize = 1)
    private int codigoTipoMarcaAuto;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @OneToMany(mappedBy = "tipoMarcaAuto")
    private List<TipoAutomovil> tiposAutomovil;
}
