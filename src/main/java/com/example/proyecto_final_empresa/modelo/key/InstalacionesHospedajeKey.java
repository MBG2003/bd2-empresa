package com.example.proyecto_final_empresa.modelo.key;

import com.example.proyecto_final_empresa.modelo.Hospedaje;
import com.example.proyecto_final_empresa.modelo.Instalaciones;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class InstalacionesHospedajeKey implements Serializable {

    @ManyToOne
    @EqualsAndHashCode.Include
    @JoinColumn(name = "codigohospedaje", referencedColumnName = "codigohospedaje", nullable = false)
    private Hospedaje hospedaje;

    @ManyToOne
    @EqualsAndHashCode.Include
    @JoinColumn(name = "codigoinstalaciones", referencedColumnName = "codigoinstalaciones", nullable = false)
    private Instalaciones instalaciones;
}
