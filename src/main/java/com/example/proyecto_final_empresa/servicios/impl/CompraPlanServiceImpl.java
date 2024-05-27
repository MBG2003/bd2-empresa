package com.example.proyecto_final_empresa.servicios.impl;

import com.example.proyecto_final_empresa.dto.CompraPlanDTO;
import com.example.proyecto_final_empresa.dto.get.AgenciaGetDTO;
import com.example.proyecto_final_empresa.dto.get.CompraPlanGetDTO;
import com.example.proyecto_final_empresa.dto.get.DetalleCompraPlanGetDTO;
import com.example.proyecto_final_empresa.modelo.CompraPlan;
import com.example.proyecto_final_empresa.modelo.DetalleCompraPlan;
import com.example.proyecto_final_empresa.repositorio.CompraPlanRepo;
import com.example.proyecto_final_empresa.repositorio.DetalleCompraPlanRepo;
import com.example.proyecto_final_empresa.servicios.interfaces.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class CompraPlanServiceImpl implements CompraPlanService {

    private CompraPlanRepo compraPlanRepo;

    private DetalleCompraPlanRepo detalleCompraPlanRepo;

    private PlanService planService;

    private ClienteService clienteService;

    private EmpleadoService empleadoService;

    private AgenciaService agenciaService;

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<DetalleCompraPlanGetDTO> listarDetallesCompras() throws Exception {
        List<DetalleCompraPlan> detallesCompra = detalleCompraPlanRepo.findAll();
        List<DetalleCompraPlanGetDTO> detallesCompraPlanGetDTO = new ArrayList<>();

        for (DetalleCompraPlan dcp : detallesCompra) {
            detallesCompraPlanGetDTO.add(convertirDetalleCompraPlan(dcp));
        }

        return detallesCompraPlanGetDTO;
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<DetalleCompraPlanGetDTO> listarDetallesComprasSinCancelar() throws Exception {
        List<Integer> detallesCompra = detalleCompraPlanRepo.listarDetalleCompraSinCancelar();
        List<DetalleCompraPlanGetDTO> detallesCompraPlanGetDTO = new ArrayList<>();

        for (Integer codigoDetalle : detallesCompra) {
            for (DetalleCompraPlan dcp : buscarPorCodigoCompra(codigoDetalle))
            detallesCompraPlanGetDTO.add(convertirDetalleCompraPlan(dcp));
        }

        return detallesCompraPlanGetDTO;
    }

    private List<DetalleCompraPlan> buscarPorCodigoCompra(int codigoCompra) {
        return detalleCompraPlanRepo.buscarPorCodigoCompra(codigoCompra);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int crearCompraPlan(CompraPlanDTO compraPlanDTO) throws Exception {
        CompraPlan compra = convertir(compraPlanDTO);
        int codigoCompra = compraPlanRepo.save(compra).getCodigoCompraPlan();

        DetalleCompraPlan detalle = new DetalleCompraPlan();
        detalle.setCompraPlan(compra);
        detalle.setPlan(planService.buscar(compraPlanDTO.getCodigoPlan()));
        detalle.setCantidad(compraPlanDTO.getCantidadPersonas());
        detalle.setDescuento(0);
        detalle.setCosto(new BigDecimal(0));
        detalleCompraPlanRepo.save(detalle);

        return codigoCompra;
    }

    private DetalleCompraPlanGetDTO convertirDetalleCompraPlan(DetalleCompraPlan detalleCompraPlan) throws Exception {
        return new DetalleCompraPlanGetDTO(
                detalleCompraPlan.getCodigoDetalle(),
                detalleCompraPlan.getCosto(),
                detalleCompraPlan.getCantidad(),
                detalleCompraPlan.getDescuento(),
                convertir(detalleCompraPlan.getCompraPlan()),
                planService.buscarDTO(detalleCompraPlan.getPlan().getCodigoPlan())
        );
    }

    private CompraPlanGetDTO convertir(CompraPlan compraPlan) throws Exception {
        AgenciaGetDTO agencia = new AgenciaGetDTO(
                0,
                "N/A",
                0
        );

        if (compraPlan.getAgencia() != null) {
            agencia = agenciaService.buscarDTO(compraPlan.getAgencia().getCodigo());
        }

        return new CompraPlanGetDTO(
                compraPlan.getCodigoCompraPlan(),
                compraPlan.getFechaCompra(),
                clienteService.buscarDTO(compraPlan.getCliente().getIdCliente()),
                //empleadoService.buscarDTO(compraPlan.get),
                agencia
        );
    }

    private CompraPlan convertir(CompraPlanDTO compraPlanDTO) throws Exception {
        CompraPlan compra = new CompraPlan();
        compra.setFechaCompra(new Date());
        compra.setCliente(clienteService.buscar(compraPlanDTO.getCodigoCliente()));
        compra.setAgencia(compraPlanDTO.getCodigoAgencia() == 0 ? null : agenciaService.buscar(compraPlanDTO.getCodigoAgencia()));

        return compra;
    }
}
