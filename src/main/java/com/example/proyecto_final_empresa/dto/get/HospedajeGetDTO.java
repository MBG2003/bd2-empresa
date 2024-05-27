package com.example.proyecto_final_empresa.dto.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public class HospedajeGetDTO {

    private int codigoHospedaje;
    private TipoHospedajeGetDTO tipoHospedaje;
    private List<TipoRegimenHospedajeGetDTO> tipoRegimenHospedajes;
    private List<HabitacionGetDTO> habitaciones;
    private List<InstalacionesGetDTO> instalaciones;


}
