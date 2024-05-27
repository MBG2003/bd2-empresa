package com.example.proyecto_final_empresa.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "articulo")
public class Articulo implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "codigoarticulo", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "articulo_seq")
    @SequenceGenerator(name = "articulo_seq", sequenceName = "ARTICULO_SEQ", allocationSize = 1)
    private int codigoArticulo;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private BigDecimal precio;

    @Column(nullable = false)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "tipoarticulo_codigo", referencedColumnName = "codigo", nullable = false)
    private TipoArticulo tipoArticulo;

    @OneToMany(mappedBy = "articulo")
    private List<DetalleCompraArticulo> detalles;
}
