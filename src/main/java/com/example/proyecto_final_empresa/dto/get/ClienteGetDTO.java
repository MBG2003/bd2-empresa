package com.example.proyecto_final_empresa.dto.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClienteGetDTO {

    private int codigoCliente;

    private PersonaGetDTO persona;
}
