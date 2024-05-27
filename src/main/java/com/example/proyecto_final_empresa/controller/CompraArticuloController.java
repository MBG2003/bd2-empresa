package com.example.proyecto_final_empresa.controller;

import com.example.proyecto_final_empresa.dto.CompraArticuloDTO;
import com.example.proyecto_final_empresa.dto.FiltroCompraArticuloDTO;
import com.example.proyecto_final_empresa.dto.FiltroHospedajeDTO;
import com.example.proyecto_final_empresa.dto.ReservaHospedajeDTO;
import com.example.proyecto_final_empresa.dto.get.CompraArticuloGetDTO;
import com.example.proyecto_final_empresa.dto.get.CompraPlanGetDTO;
import com.example.proyecto_final_empresa.dto.get.MensajeDTO;
import com.example.proyecto_final_empresa.servicios.interfaces.ArticuloService;
import com.example.proyecto_final_empresa.servicios.interfaces.ClienteService;
import com.example.proyecto_final_empresa.servicios.interfaces.CompraArticuloService;
import com.example.proyecto_final_empresa.servicios.interfaces.EmpleadoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/CompraArticulo")
@CrossOrigin("*")
@AllArgsConstructor
public class CompraArticuloController {

    private CompraArticuloService compraArticuloService;

    private ArticuloService articuloService;
    private ClienteService clienteService;
    private EmpleadoService empleadoService;

    @GetMapping("/listar-compra-articulos")
    public ResponseEntity<MensajeDTO> listarCompraArticulos() throws Exception {
        List<CompraArticuloGetDTO> reservas = compraArticuloService.listar();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO(HttpStatus.OK, false, "lista reservas", reservas));
    }

    @GetMapping("/listar-articulo")
    public String listarArticulos(Model model) throws Exception {
        model.addAttribute("articulos", articuloService.listarArticulos());
        return "listar-articulo";
    }


    @PutMapping("/crear-compra")
    public ResponseEntity<MensajeDTO> crearCompraArticulos() throws Exception {
        List<CompraArticuloGetDTO> reservas = compraArticuloService.listar();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO(HttpStatus.OK, false, "lista reservas", reservas));
    }

    @GetMapping("/comprar-articulo/{codigoArticulo}")
    public String nuevoCompraArticulos(@PathVariable int codigoArticulo, Model model) throws Exception {

        CompraArticuloDTO compraArticulo = new CompraArticuloDTO();
        model.addAttribute("compraArticulo", compraArticulo);
        model.addAttribute("clientes", clienteService.listar());
        model.addAttribute("empleados", empleadoService.listar());
        model.addAttribute("articulo", articuloService.buscarDTO(codigoArticulo));
        return "comprar-articulo";
    }

    @GetMapping("/filtro-compraArticulo")
    public String filtroCompraArticulo(@ModelAttribute("filtro") FiltroCompraArticuloDTO filtro, Model model) throws Exception {

        filtro = new FiltroCompraArticuloDTO();

        model.addAttribute("filtro", filtro);

        return "listar-articulo";
    }
}
