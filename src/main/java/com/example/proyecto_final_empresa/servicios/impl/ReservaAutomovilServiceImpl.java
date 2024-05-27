package com.example.proyecto_final_empresa.servicios.impl;

import com.example.proyecto_final_empresa.dto.ReservaAutomovilDTO;
import com.example.proyecto_final_empresa.dto.get.*;
import com.example.proyecto_final_empresa.modelo.AutomovilReserva;
import com.example.proyecto_final_empresa.modelo.DetalleReservaAutomovil;
import com.example.proyecto_final_empresa.modelo.Servicios;
import com.example.proyecto_final_empresa.repositorio.AutomovilReservaRepo;
import com.example.proyecto_final_empresa.repositorio.DetalleReservaAutomovilRepo;
import com.example.proyecto_final_empresa.servicios.interfaces.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservaAutomovilServiceImpl implements ReservaAutomovilService {

    private AutomovilReservaRepo automovilReservaRepo;

    private DetalleReservaAutomovilRepo detalleReservaAutomovilRepo;

    private AutomovilService automovilService;

    private ServicioService servicioService;

    private ClienteService clienteService;

    private EmpleadoService empleadoService;

    private AgenciaService agenciaService;

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<ReservaAutomovilGetDTO> listarReservaAutomovil() throws Exception {
        List<AutomovilReserva> reservas = automovilReservaRepo.findAll();
        List<ReservaAutomovilGetDTO> reservasAutomovilGetDTO = new ArrayList<>();

        for(AutomovilReserva ar : reservas) {
            reservasAutomovilGetDTO.add(convertir(ar));
        }

        return reservasAutomovilGetDTO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int crearReservaAutomovil(ReservaAutomovilDTO reserva) throws Exception {
        AutomovilReserva automovilReserva = convertir(reserva);
        List<Servicios> servicios = new ArrayList<>();

        int codigoReserva = automovilReservaRepo.save(automovilReserva).getCodigoReserva();

        DetalleReservaAutomovil dra = new DetalleReservaAutomovil();

        dra.setAutomovil(automovilService.buscar(reserva.getCodigoAutomovil()));
        dra.setAutomovilReserva(automovilReserva);
        dra.setPrecioTotal(new BigDecimal(0));
        dra.setFecha(new Date());

        detalleReservaAutomovilRepo.save(dra);

        for (int codigoServicio : reserva.getCodServicios()) {
            servicios.add(servicioService.buscar(codigoServicio));
        }

        automovilReserva.setServicios(servicios);
        automovilReserva.setDetallesReserva(Arrays.asList(dra));

        return codigoReserva;
    }

    private ReservaAutomovilGetDTO convertir(AutomovilReserva reserva) throws Exception {
        AgenciaGetDTO agencia = new AgenciaGetDTO(
                0,
                "N/A",
                0
        );

        EmpleadoGetDTO empleado = new EmpleadoGetDTO(
                0,
                'I',
                null,
                null,
                new PersonaGetDTO(
                        0,
                        "N/A",
                        null,
                        null,
                        null
                )
        );

        ClienteGetDTO cliente = clienteService.buscarDTO(reserva.getCliente().getIdCliente());
        List<ServiciosGetDTO> serviciosReserva = new ArrayList<>();
        List<DetalleReservaAutomovilGetDTO> detalles = new ArrayList<>();

        for (Servicios s : reserva.getServicios()) {
            serviciosReserva.add(convertirServicio(s));
        }

        for (DetalleReservaAutomovil dra : reserva.getDetallesReserva()) {
            detalles.add(convertirDetalle(dra));
        }

        if(reserva.getAgencia() != null) {
            agencia = agenciaService.buscarDTO(reserva.getAgencia().getCodigo());
        }

        if (reserva.getEmpleado() != null) {
            empleado = empleadoService.buscarDTO(reserva.getEmpleado().getCodigoEmpleado());
        }
        return new ReservaAutomovilGetDTO(
                reserva.getCodigoReserva(),
                reserva.getCostoMoraDia(),
                reserva.getFechaReserva(),
                agencia,
                empleado,
                cliente,
                serviciosReserva,
                detalles
        );
    }

    private AutomovilReserva convertir(ReservaAutomovilDTO reserva) throws Exception {
        AutomovilReserva automovilReserva = new AutomovilReserva();
        automovilReserva.setFechaReserva(reserva.getFechaReserva());
        automovilReserva.setFechaEntrega(reserva.getFechaEntrega());
        automovilReserva.setCostoMoraDia(reserva.getCostoMoraDia());
        automovilReserva.setCliente(clienteService.buscar(reserva.getCodigoCliente()));
        automovilReserva.setEmpleado(reserva.getCodigoEmpleado() == 0 ? null : empleadoService.buscar(reserva.getCodigoEmpleado()));
        automovilReserva.setAgencia(reserva.getCodigoAgencia() == 0 ? null : agenciaService.buscar(reserva.getCodigoAgencia()));

        return automovilReserva;
    }

    private ServiciosGetDTO convertirServicio(Servicios servicio) {
        return new ServiciosGetDTO(
                servicio.getCodigoServicio(),
                servicio.getNombre(),
                servicio.getPrecio(),
                servicio.getDescripcion()
        );
    }

    private DetalleReservaAutomovilGetDTO convertirDetalle(DetalleReservaAutomovil detalle) throws Exception {
        return new DetalleReservaAutomovilGetDTO(
                detalle.getCodigo(),
                detalle.getPrecioTotal(),
                detalle.getFecha(),
                automovilService.buscarDTO(detalle.getAutomovil().getCodigoAutomovil())
        );
    }
}
