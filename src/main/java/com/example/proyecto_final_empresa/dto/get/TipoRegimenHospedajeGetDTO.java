package com.example.proyecto_final_empresa.dto.get;

import com.example.proyecto_final_empresa.modelo.Hospedaje;
import com.example.proyecto_final_empresa.modelo.TiposRegimen;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class TipoRegimenHospedajeGetDTO {
    private int codigo;
    private BigDecimal precio;
    private TipoRegimenGetDTO tiposRegimen;
}
