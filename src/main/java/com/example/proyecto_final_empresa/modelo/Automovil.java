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
@Table(name = "automovil")
public class Automovil implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "codigoautomovil", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "automovil_seq")
    @SequenceGenerator(name = "automovil_seq", sequenceName = "AUTOMOVIL_SEQ", allocationSize = 1)
    private int codigoAutomovil;

    @Column(nullable = false)
    private String nombre;

    @Column(name = "capacidadmax", nullable = false)
    private int capacidadMax;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false, length = 1)
    private char disponible;

    @Column(nullable = false)
    private BigDecimal precio;

    @ManyToOne
    @JoinColumn(name = "codigotipogama", referencedColumnName = "codigotipogama", nullable = false)
    private TipoGama tipoGama;

    @ManyToMany
    @JoinTable(name = "automovilservicio",
            joinColumns = {@JoinColumn(name = "automovil_codigoautomovil", referencedColumnName = "codigoautomovil")},
            inverseJoinColumns = {@JoinColumn(name = "servicios_codigoseguro", referencedColumnName = "codigoservicio")})
    private List<Servicios> servicios;

    @OneToMany(mappedBy = "automovil")
    private List<DetalleReservaAutomovil> detallesReserva;
}
