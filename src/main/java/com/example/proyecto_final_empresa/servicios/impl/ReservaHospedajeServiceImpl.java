package com.example.proyecto_final_empresa.servicios.impl;

import com.example.proyecto_final_empresa.dto.ReservaHospedajeDTO;
import com.example.proyecto_final_empresa.dto.get.*;
import com.example.proyecto_final_empresa.modelo.Cliente;
import com.example.proyecto_final_empresa.modelo.DetalleReservaHospedaje;
import com.example.proyecto_final_empresa.modelo.ReservaHospedaje;
import com.example.proyecto_final_empresa.repositorio.DetalleReservaHospedajeRepo;
import com.example.proyecto_final_empresa.repositorio.ReservaHospedajeRepo;
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
public class ReservaHospedajeServiceImpl implements ReservaHospedajeService {

    private ReservaHospedajeRepo reservaHospedajeRepo;

    private DetalleReservaHospedajeRepo detalleReservaHospedajeRepo;

    private AgenciaService agenciaService;

    private ClienteService clienteService;

    private EmpleadoService empleadoService;

    private HabitacionService habitacionService;

    @Override
    @Transactional(readOnly = true)
    public List<ReservaHospedajeGetDTO> listarReservaHospedaje() throws Exception {
        List<ReservaHospedaje> reservas = reservaHospedajeRepo.findAll();
        List<ReservaHospedajeGetDTO> reservasHospedajeGetDTO = new ArrayList<>();

        for(ReservaHospedaje r : reservas) {
            reservasHospedajeGetDTO.add(convertir(r));
        }

        return reservasHospedajeGetDTO;
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<ReservaHospedajeGetDTO> listarReservaHospedajeSinCancelar() throws Exception {
        List<Integer> reservasCodigo = reservaHospedajeRepo.listarReservasSinCancelar();
        List<ReservaHospedajeGetDTO> reservasHospedajeGetDTO = new ArrayList<>();

        for(Integer r : reservasCodigo) {
            reservasHospedajeGetDTO.add(convertir(buscar(r)));
        }

        return reservasHospedajeGetDTO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int crearReservaHospedaje(ReservaHospedajeDTO reserva) throws Exception {
        ReservaHospedaje reservaHospedaje = convertir(reserva);
        reservaHospedaje.setFechaRealizacion(new Date());
        int codReserva = reservaHospedajeRepo.save(reservaHospedaje).getCodigoReservaHospedaje();
        for (int codigoHab : reserva.getCodHabitaciones()) {
            DetalleReservaHospedaje d = new DetalleReservaHospedaje();
            d.setReservaHospedaje(reservaHospedaje);
            d.setHabitacion(habitacionService.buscar(codigoHab));
            d.setFecha(new Date());
            detalleReservaHospedajeRepo.save(d);
        }
        return codReserva;
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public ReservaHospedaje buscar(int codigoReserva) throws Exception {
        return reservaHospedajeRepo.findById(codigoReserva).get();
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public ReservaHospedajeGetDTO buscarDTO(int codigoReserva) throws Exception {
        return convertir(buscar(codigoReserva));
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public int consultarSigCodigo() throws Exception {
        return reservaHospedajeRepo.consultarCantResgistros() + 1;
    }

    private ReservaHospedajeGetDTO convertir(ReservaHospedaje reserva) throws Exception {
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
        //EmpleadoGetDTO empleado = empleadoService.buscarDTO(reserva.getEmpleado().getCodigoEmpleado());

        if(reserva.getAgencia() != null) {
            agencia = agenciaService.buscarDTO(reserva.getAgencia().getCodigo());
        }

        if (reserva.getEmpleado() != null) {
            empleado = empleadoService.buscarDTO(reserva.getEmpleado().getCodigoEmpleado());
        }

        return new ReservaHospedajeGetDTO(
                reserva.getCodigoReservaHospedaje(),
                agencia,
                empleado,
                cliente,
                reserva.getPoliticaCancelacion() == null ? 0 : reserva.getPoliticaCancelacion().getIdPolitica(),
                reserva.getCostoMoraDia(),
                reserva.getCantidadPersonas(),
                reserva.getFechaReserva(),
                reserva.getFechaRealizacion(),
                reserva.getFechaFinEntrega()
        );
    }

    private ReservaHospedaje convertir(ReservaHospedajeDTO reservaHospedajeDTO) throws Exception {
        ReservaHospedaje reservaHospedaje = new ReservaHospedaje();

        reservaHospedaje.setCostoMoraDia(reservaHospedajeDTO.getCostoMoraDia());
        reservaHospedaje.setFechaReserva(reservaHospedajeDTO.getFechaReserva());
        reservaHospedaje.setFechaFinEntrega(reservaHospedajeDTO.getFechaFinEntrega());
        reservaHospedaje.setCantidadPersonas(reservaHospedajeDTO.getCantidadPersonas());
        reservaHospedaje.setCliente(clienteService.buscar(reservaHospedajeDTO.getCodigoCliente()));
        reservaHospedaje.setEmpleado(reservaHospedajeDTO.getCodigoEmpleado() == 0 ? null : empleadoService.buscar(reservaHospedajeDTO.getCodigoEmpleado()));
        reservaHospedaje.setAgencia(reservaHospedajeDTO.getCodigoAgencia() == 0 ? null : agenciaService.buscar(reservaHospedajeDTO.getCodigoAgencia()));
        return reservaHospedaje;
    }
}
