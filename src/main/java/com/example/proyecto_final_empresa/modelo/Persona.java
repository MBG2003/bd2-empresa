package com.example.proyecto_final_empresa.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "persona")
public class Persona implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "codigopersona", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persona_seq")
    @SequenceGenerator(name = "persona_seq", sequenceName = "PERSONA_SEQ", allocationSize = 1)
    private int codigoPersona;

    @Column(nullable = false)
    private String nombre;

    @Column(name = "fechanacimiento", nullable = false)
    private Date fechaNacimiento;

    @Column(nullable = false)
    private String correo;

    @Column(nullable = false)
    private String telefono;

    @OneToMany(mappedBy = "persona")
    private List<Cliente> clientes;

    @OneToMany(mappedBy = "persona")
    private List<Empleado> empleados;
}
