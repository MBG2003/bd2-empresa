package com.example.proyecto_final_empresa.dto.get;

import com.example.proyecto_final_empresa.modelo.Agencia;
import com.example.proyecto_final_empresa.modelo.CancelacionPlan;
import com.example.proyecto_final_empresa.modelo.Cliente;
import com.example.proyecto_final_empresa.modelo.DetalleCompraPlan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CompraPlanGetDTO {

    private int codigoCompraPlan;
    private Date fechaCompra;
    private ClienteGetDTO cliente;
    //private EmpleadoGetDTO Empleado;
    private AgenciaGetDTO agencia;
}
