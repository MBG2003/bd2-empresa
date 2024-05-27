package com.example.proyecto_final_empresa.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "detallecompra_articulo")
public class DetalleCompraArticulo implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "codigodetalle", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detalle_compra_articulo_seq")
    @SequenceGenerator(name = "detalle_compra_articulo_seq", sequenceName = "DETALLE_COMPRA_ARTICULO_SEQ", allocationSize = 1)
    private int codigoDetalle;

    @Column(nullable = false)
    private int cantidad;

    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "codigoarticulo", referencedColumnName = "codigoarticulo", nullable = false)
    private Articulo articulo;

    @ManyToOne
    @JoinColumn(name = "codigocompra", referencedColumnName = "codigocompra", nullable = false)
    private Compra compra;
}
