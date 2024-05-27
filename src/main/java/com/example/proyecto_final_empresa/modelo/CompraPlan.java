package com.example.proyecto_final_empresa.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "compraplan")
public class CompraPlan implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "codigocompraplan",nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "compra_plan_seq")
    @SequenceGenerator(name = "compra_plan_seq", sequenceName = "COMPRAPLAN_SEQ", allocationSize = 1)
    private int codigoCompraPlan;

    @Column(name = "fechacompra", nullable = false)
    private Date fechaCompra;

    @ManyToOne
    @JoinColumn(name = "codigocliente", referencedColumnName = "idcliente", nullable = false)
    private Cliente cliente;

    /*@ManyToOne
    @JoinColumn(name = "codigoempleado", referencedColumnName = "codigoempleado", nullable = false)
    private Empleado empleado;*/

    @ManyToOne
    @JoinColumn(name = "codigo_agencia", referencedColumnName = "codigo")
    private Agencia agencia;

    @OneToMany(mappedBy = "compraPlan")
    private List<CancelacionPlan> cancelaciones;

    @OneToMany(mappedBy = "compraPlan")
    private List<DetalleCompraPlan> detallesCompraPlan;
}
