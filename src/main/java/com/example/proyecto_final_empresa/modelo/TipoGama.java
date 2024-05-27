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
@Table(name = "tipogama")
public class TipoGama implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "codigotipogama", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_gama_seq")
    @SequenceGenerator(name = "tipo_gama_seq", sequenceName = "TIPO_GAMA_SEQ", allocationSize = 1)
    private int codigoTipoGama;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "codigotipoautomovil", referencedColumnName = "codigotipoautomovil", nullable = false)
    private TipoAutomovil tipoAutomovil;

    @OneToMany(mappedBy = "tipoGama")
    private List<Automovil> automoviles;
}
