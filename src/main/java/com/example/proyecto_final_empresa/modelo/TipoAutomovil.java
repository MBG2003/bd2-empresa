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
@Table(name = "tipoautomovil")
public class TipoAutomovil implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "codigotipoautomovil", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_automovil_seq")
    @SequenceGenerator(name = "tipo_automovil_seq", sequenceName = "TIPO_AUTOMOVIL_SEQ", allocationSize = 1)
    private int codigoTipoAutomovil;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "codigotipomarcaauto", referencedColumnName = "codigotipomarcaauto", nullable = false)
    private TipoMarcaAuto tipoMarcaAuto;

    @OneToMany(mappedBy = "tipoAutomovil")
    private List<TipoGama> tiposGama;
}
