package com.example.proyecto_final_empresa.servicios.interfaces;

import com.example.proyecto_final_empresa.dto.get.PlanGetDTO;
import com.example.proyecto_final_empresa.dto.get.TipoPlanGetDTO;
import com.example.proyecto_final_empresa.modelo.Plan;

import java.util.List;

public interface PlanService {

    List<PlanGetDTO> listarPlanes() throws Exception;
    List<PlanGetDTO> listarPlanesSinCancelar() throws Exception;

    Plan buscar(int codigoPlan) throws Exception;

    PlanGetDTO buscarDTO(int codigoPlan) throws Exception;

    List<TipoPlanGetDTO> listarTipoPlanes()throws Exception;
}
