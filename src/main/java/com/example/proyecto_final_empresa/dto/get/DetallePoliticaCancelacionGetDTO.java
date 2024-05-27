package com.example.proyecto_final_empresa.dto.get;

import com.example.proyecto_final_empresa.modelo.PoliticaCancelacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DetallePoliticaCancelacionGetDTO {
    private int codigoDetalle;
    private PoliticaCancelacionGetDTO politicaCancelacion;

}
