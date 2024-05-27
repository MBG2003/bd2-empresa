package com.example.proyecto_final_empresa.controller;

import com.example.proyecto_final_empresa.dto.get.CancelarHospedajeGetDTO;
import com.example.proyecto_final_empresa.dto.get.MensajeDTO;
import com.example.proyecto_final_empresa.dto.get.ReservaHospedajeGetDTO;
import com.example.proyecto_final_empresa.servicios.interfaces.CancelarHospedajeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/CancelarHospedaje")
@CrossOrigin("*")
@AllArgsConstructor
public class CancelarHospedajeController {

    private CancelarHospedajeService cancelarHospedajeService;

    @PostMapping("/listar-cancelacion")
    public ResponseEntity<MensajeDTO> listarCancelar() throws Exception {
        List<CancelarHospedajeGetDTO> reservas = cancelarHospedajeService.listar();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO(HttpStatus.OK, false, "lista reservas", reservas));
    }
    @PostMapping("/crear-cancelacion")
    public ResponseEntity<MensajeDTO> listarHospedaje() throws Exception {
        List<CancelarHospedajeGetDTO> reservas = cancelarHospedajeService.listar();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO(HttpStatus.OK, false, "lista reservas", reservas));
    }

    @GetMapping("/cancelar-hospedaje")
    public String cancelacionHospedaje() {

        return "cancelar-hospedaje";
    }
}
