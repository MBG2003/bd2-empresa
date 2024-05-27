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
@Table(name = "tipoplan")
public class TipoPlan implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "codigo", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_plan_seq")
    @SequenceGenerator(name = "tipo_plan_seq", sequenceName = "TIPO_PLAN_SEQ", allocationSize = 1)
    private int codigo;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @OneToMany(mappedBy = "tipoPlan")
    private List<Plan> planes;
}
