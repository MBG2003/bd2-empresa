package com.example.proyecto_final_empresa.dto.get;

import com.example.proyecto_final_empresa.modelo.Cliente;
import com.example.proyecto_final_empresa.modelo.Empleado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PersonaGetDTO {

    private int codigoPersona;
    private String nombre;
    private Date fechaNacimiento;
    private String correo;
    private String telefono;
}
