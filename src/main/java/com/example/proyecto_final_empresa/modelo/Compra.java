package com.example.proyecto_final_empresa.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "compra")
public class Compra implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "codigocompra",nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "compra_seq")
    @SequenceGenerator(name = "compra_seq", sequenceName = "COMPRA_SEQ", allocationSize = 1)
    private int codigoCompra;

    @Column(name = "fechacompra", nullable = false)
    private Date fechaCompra;

    @Column(nullable = false)
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "codigocliente", referencedColumnName = "idcliente", nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "compra")
    private List<DetalleCompraArticulo> detalles;
}
