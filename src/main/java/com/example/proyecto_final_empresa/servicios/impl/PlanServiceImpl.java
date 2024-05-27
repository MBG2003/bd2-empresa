package com.example.proyecto_final_empresa.servicios.impl;

import com.example.proyecto_final_empresa.dto.get.*;
import com.example.proyecto_final_empresa.modelo.*;
import com.example.proyecto_final_empresa.repositorio.PlanRepo;
import com.example.proyecto_final_empresa.repositorio.TipoPlanRepo;
import com.example.proyecto_final_empresa.servicios.interfaces.PlanService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PlanServiceImpl implements PlanService {

    private PlanRepo planRepo;

    private TipoPlanRepo tipoPlanRepo;

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<PlanGetDTO> listarPlanes() throws Exception {
        List<Plan> planes = planRepo.findAll();
        List<PlanGetDTO> planesGetDTO = new ArrayList<>();

        for (Plan p : planes) {
            planesGetDTO.add(convertir(p));
        }

        return planesGetDTO;
    }



    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<PlanGetDTO> listarPlanesSinCancelar() throws Exception {
        List<Plan> planes = planRepo.findAll();
        List<PlanGetDTO> planesGetDTO = new ArrayList<>();

        for (Plan p : planes) {
            planesGetDTO.add(convertir(p));
        }

        return planesGetDTO;
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public Plan buscar(int codigoPlan) throws Exception {
        validar(codigoPlan);
        return planRepo.findById(codigoPlan).get();
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public PlanGetDTO buscarDTO(int codigoPlan) throws Exception {
        return convertir(buscar(codigoPlan));
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<TipoPlanGetDTO> listarTipoPlanes() throws Exception {
        List<TipoPlan> tiposPlan = tipoPlanRepo.findAll();
        List<TipoPlanGetDTO> tiposPlanGetDTO = new ArrayList<>();

        for (TipoPlan tp : tiposPlan) {
            tiposPlanGetDTO.add(convertirTipoPlan(tp));
        }

        return tiposPlanGetDTO;
    }

    private PlanGetDTO convertir(Plan plan) {

        List<DetallePlanGetDTO> detalles = new ArrayList<>();
        List<PoliticaPromocionGetDTO> politicasPromo = new ArrayList<>();

        if(plan.getDetalles() != null) {
            for (DetallePlan dp : plan.getDetalles()) {
                detalles.add(convertirDetallePlan(dp));
            }
        }

        if(plan.getPoliticasPromocion() != null) {
            for (PoliticaPromocion pp : plan.getPoliticasPromocion()) {
                politicasPromo.add(convertirPoliticaPromo(pp));
            }
        }

        return new PlanGetDTO(
                plan.getCodigoPlan(),
                plan.getNombre(),
                plan.getPrecioUnidad(),
                plan.getCantidadPersona(),
                plan.getDescripcion(),
                convertirTipoPlan(plan.getTipoPlan()),
                detalles,
                politicasPromo
        );
    }

    private TipoPlanGetDTO convertirTipoPlan(TipoPlan tipoPlan) {
        return new TipoPlanGetDTO(
                tipoPlan.getCodigo(),
                tipoPlan.getNombre(),
                tipoPlan.getDescripcion()
        );
    }

    private DetallePlanGetDTO convertirDetallePlan(DetallePlan dp) {
        return new DetallePlanGetDTO(
                dp.getCodigoDetallePlan(),
                dp.getPlan().getCodigoPlan(),
                dp.getFechaInicio(),
                dp.getFechaFin()
        );
    }

    private PoliticaPromocionGetDTO convertirPoliticaPromo(PoliticaPromocion pp) {
        return new PoliticaPromocionGetDTO(
                pp.getIdPolitica(),
                pp.getPlan().getCodigoPlan(),
                pp.getPorcentajeDescuento(),
                pp.getCantidadPersonas(),
                pp.getDescripcion()
        );
    }

    private void validar(int codigoPlan) throws Exception {
        if(!planRepo.existsById(codigoPlan)) {
            throw new Exception("No se encontró el plan: " + codigoPlan);
        }
    }
}
