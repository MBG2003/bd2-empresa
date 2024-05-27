package com.example.proyecto_final_empresa.controller;

import com.example.proyecto_final_empresa.dto.FiltroAutomovilDTO;
import com.example.proyecto_final_empresa.dto.FiltroHospedajeDTO;
import com.example.proyecto_final_empresa.dto.ReservaAutomovilDTO;
import com.example.proyecto_final_empresa.dto.get.HospedajeGetDTO;
import com.example.proyecto_final_empresa.dto.get.MensajeDTO;
import com.example.proyecto_final_empresa.dto.get.ReservaAutomovilGetDTO;
import com.example.proyecto_final_empresa.servicios.interfaces.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ReservaAutomovil")
@CrossOrigin("*")
@AllArgsConstructor
public class ReservaAutomovilController {

    private ReservaAutomovilService reservaAutomovilService;

    private AutomovilService automovilService;

    private ClienteService clienteService;

    private EmpleadoService empleadoService;

    private ServicioService servicioService;

    private AgenciaService agenciaService;

    @GetMapping("/listar-reserva-automovil")
    public String listarReservaAutomovil(Model model) throws Exception {
        model.addAttribute("reservas", reservaAutomovilService.listarReservaAutomovil());
        return "reservar-automovil";
    }

    @GetMapping("/listar-automovil")
    public String listarAutomovil(Model model) throws Exception {
        FiltroHospedajeDTO filtro = new FiltroHospedajeDTO();

        model.addAttribute("filtro", filtro);
        model.addAttribute("automoviles", automovilService.listarAutomoviles());

        return "listar-automovil";
    }

    @GetMapping("/filtro-automovil")
    public String filtroReservaAutomovil(@ModelAttribute("filtro") FiltroAutomovilDTO filtro, Model model) throws Exception {
        filtro = new FiltroAutomovilDTO();

        model.addAttribute("filtro", filtro);

        return "listar-automovil";
    }

    @GetMapping("/nuevo-reserva-automovil/{codigoAuto}")
    public String nuevoReservaAutomovil(@PathVariable int codigoAuto, Model model) throws Exception {
        ReservaAutomovilDTO reserva = new ReservaAutomovilDTO();
        reserva.setCodigoAutomovil(codigoAuto);
        model.addAttribute("reserva", reserva);
        model.addAttribute("servicios", servicioService.listarServiciosAutomovil(codigoAuto));
        model.addAttribute("clientes", clienteService.listar());
        model.addAttribute("empleados", empleadoService.listar());
        model.addAttribute("agencias", agenciaService.listar());
        return "nuevo-reserva-automovil";
    }

    @PostMapping("/guardar-reserva-automovil")
    public String guardarReservaHospedaje(@ModelAttribute("reserva") ReservaAutomovilDTO reserva, @RequestParam(value = "servicios", required = false) int[] servicios) throws Exception {
        if (servicios != null) {
            reserva.setCodServicios(new ArrayList<>());
            for (int codigoServicio : servicios) {
                reserva.getCodServicios().add(codigoServicio);
            }
        }
        reservaAutomovilService.crearReservaAutomovil(reserva);
        return "redirect:/ReservaAutomovil/listar-automovil";
    }

    @PostMapping("/crear-reserva-automovil")
    public ResponseEntity<MensajeDTO> crearReservaAutomovil() throws Exception {
        List<ReservaAutomovilGetDTO> reservas = reservaAutomovilService.listarReservaAutomovil();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO(HttpStatus.OK, false, "lista reservas", reservas));
    }

    @PutMapping("/actualizar-reserva-automovil")
    public ResponseEntity<MensajeDTO> actualizarReservaAutomovil() throws Exception {
        List<ReservaAutomovilGetDTO> reservas = reservaAutomovilService.listarReservaAutomovil();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO(HttpStatus.OK, false, "lista reservas", reservas));
    }

}
