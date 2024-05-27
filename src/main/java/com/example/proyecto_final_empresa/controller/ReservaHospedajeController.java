package com.example.proyecto_final_empresa.controller;

import com.example.proyecto_final_empresa.dto.FiltroHospedajeDTO;
import com.example.proyecto_final_empresa.dto.ReservaHospedajeDTO;
import com.example.proyecto_final_empresa.dto.get.HospedajeGetDTO;
import com.example.proyecto_final_empresa.dto.get.MensajeDTO;
import com.example.proyecto_final_empresa.dto.get.ReservaHospedajeGetDTO;
import com.example.proyecto_final_empresa.modelo.Habitacion;
import com.example.proyecto_final_empresa.modelo.ReservaHospedaje;
import com.example.proyecto_final_empresa.servicios.interfaces.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/reservaHospedaje")
@CrossOrigin("*")
@AllArgsConstructor
public class ReservaHospedajeController {

    private ReservaHospedajeService reservaHospedajeService;

    private AgenciaService agenciaService;

    private HospedajeService hospedajeService;

    private HabitacionService habitacionService;

    private ClienteService clienteService;

    private EmpleadoService empleadoService;

    List<Integer> habitaciones = new ArrayList<>();

    @GetMapping("/listar-hospedaje")
    public String listarHospedaje(Model model) throws Exception {
        FiltroHospedajeDTO filtro = new FiltroHospedajeDTO();

        model.addAttribute("filtro", filtro);
        model.addAttribute("tiposHospedaje", hospedajeService.listarTipoHospedaje());
        model.addAttribute("instalaciones", hospedajeService.listarInstalaciones());
        model.addAttribute("hospedajes", hospedajeService.listarHospedaje());
        return "listar-hospedaje";
    }

    @GetMapping("/listar-reserva-hospedaje")
    public String listarReservaHospedaje(Model model) throws Exception {
        model.addAttribute("reservas", reservaHospedajeService.listarReservaHospedajeSinCancelar());
        return "listar-reserva-hospedaje";
    }

    @GetMapping("/filtro-hospedaje")
    public String filtroReservaHospedaje(@ModelAttribute("filtro") FiltroHospedajeDTO filtro, Model model) throws Exception {
        List<HospedajeGetDTO> hospedajes = new ArrayList<>();

        if(filtro.getCodigoInstalaciones() != 0) {
            hospedajes = hospedajeService.filtroInstalaciones(filtro.getCodigoInstalaciones());
        } else if (filtro.getCodigoTipoHospedaje() != 0) {
            hospedajes = hospedajeService.filtroTipoHotel(filtro.getCodigoTipoHospedaje());
        } else if(filtro.getPrecioMin() != null && filtro.getPrecioMax() == null) {
            hospedajes = hospedajeService.filtroPrecioMin(filtro.getPrecioMin());
        } else if (filtro.getPrecioMax() != null && filtro.getPrecioMin() == null) {
            hospedajes = hospedajeService.filtroPrecioMax(filtro.getPrecioMax());
        } else if (filtro.getPrecioMin() != null && filtro.getPrecioMax() != null){
            hospedajes = hospedajeService.filtroRangoPrecio(filtro.getPrecioMin(), filtro.getPrecioMax());
        }

        filtro = new FiltroHospedajeDTO();

        model.addAttribute("filtro", filtro);
        model.addAttribute("tiposHospedaje", hospedajeService.listarTipoHospedaje());
        model.addAttribute("instalaciones", hospedajeService.listarInstalaciones());
        model.addAttribute("hospedajes", hospedajes);
        return "listar-hospedaje";
    }

    @GetMapping("/nuevo-reserva-hospedaje/{codigoHospedaje}")
    public String nuevoReservaHospedaje(@PathVariable int codigoHospedaje, Model model) throws Exception {
        System.out.println("hospedaje: " + codigoHospedaje);
        ReservaHospedajeDTO reserva = new ReservaHospedajeDTO();
        model.addAttribute("reserva", reserva);
        model.addAttribute("tiposRegimen", hospedajeService.listarTipoRegimen());
        model.addAttribute("tiposHabitacion", habitacionService.listarHabitacionesHospedaje(codigoHospedaje));
        model.addAttribute("clientes", clienteService.listar());
        model.addAttribute("empleados", empleadoService.listar());
        model.addAttribute("agencias", agenciaService.listar());
        return "nuevo-reserva-hospedaje";
    }

    @GetMapping("/modificar-reserva-hospedaje/{codigoHospedaje}")
    public String modificarReservaHospedaje(@PathVariable int codigoHospedaje, Model model) throws Exception {
        ReservaHospedajeDTO reserva = new ReservaHospedajeDTO();
        model.addAttribute("reserva", reserva);
        model.addAttribute("tiposRegimen", hospedajeService.listarTipoRegimen());
        model.addAttribute("tiposHabitacion", habitacionService.listarHabitacionesHospedaje(codigoHospedaje));
        model.addAttribute("clientes", clienteService.listar());
        model.addAttribute("empleados", empleadoService.listar());
        model.addAttribute("agencias", agenciaService.listar());
        return "actualizar-reserva-hospedaje";
    }



    @PostMapping("/guardar-reserva-hospedaje")
    public String guardarReservaHospedaje(@ModelAttribute("reserva") ReservaHospedajeDTO reserva, @RequestParam(value = "habitaciones", required = false) int[] habitaciones) throws Exception {
        if (habitaciones != null) {
            reserva.setCodHabitaciones(new ArrayList<>());
            for (int codigoHab : habitaciones) {
                reserva.getCodHabitaciones().add(codigoHab);
            }
        }
        reservaHospedajeService.crearReservaHospedaje(reserva);
        return "redirect:/reservaHospedaje/listar-reserva-hospedaje";
    }

    @PutMapping("/actualizar-reserva-Hospedaje")
    public ResponseEntity<MensajeDTO> actualizarReservaHospedaje() throws Exception {
        List<ReservaHospedajeGetDTO> reservas = reservaHospedajeService.listarReservaHospedaje();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO(HttpStatus.OK, false, "lista reservas", reservas));
    }

    @PutMapping("/cancelar-reserva-Hospedaje")
    public ResponseEntity<MensajeDTO> cancelarReservaHospedaje() throws Exception {
        List<ReservaHospedajeGetDTO> reservas = reservaHospedajeService.listarReservaHospedaje();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO(HttpStatus.OK, false, "lista reservas", reservas));
    }

}
