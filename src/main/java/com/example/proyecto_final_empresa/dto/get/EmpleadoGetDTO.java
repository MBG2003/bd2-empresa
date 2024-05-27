package com.example.proyecto_final_empresa.dto.get;


import com.example.proyecto_final_empresa.modelo.Persona;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class EmpleadoGetDTO {

    private int codigoEmpleado;
    private char estado;
    private Date fechaContrato;
    private BigDecimal salario;
    private PersonaGetDTO persona;

}
