package com.example.proyecto_final_empresa.dto.get;

import com.example.proyecto_final_empresa.modelo.ReservaHospedaje;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class CancelarHospedajeGetDTO {

    private int codigo;
    private Date fecha;
    private BigDecimal costo;
    //private ReservaHospedajeGetDTO reservaHospedaje;
    private int reservaHospedaje;




}
