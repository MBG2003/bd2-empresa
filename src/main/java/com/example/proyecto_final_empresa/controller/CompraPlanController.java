package com.example.proyecto_final_empresa.controller;


import com.example.proyecto_final_empresa.dto.CompraPlanDTO;
import com.example.proyecto_final_empresa.dto.FiltroCompraPlanDTO;
import com.example.proyecto_final_empresa.dto.FiltroHospedajeDTO;
import com.example.proyecto_final_empresa.dto.FiltroPlanDTO;
import com.example.proyecto_final_empresa.dto.get.CompraPlanGetDTO;
import com.example.proyecto_final_empresa.dto.get.HospedajeGetDTO;
import com.example.proyecto_final_empresa.servicios.interfaces.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/CompraPlan")
@CrossOrigin("*")
@AllArgsConstructor
public class CompraPlanController {

    private CompraPlanService compraPlanService;

    private PlanService planService;

    private ClienteService clienteService;

    private EmpleadoService empleadoService;

    private AgenciaService agenciaService;

    @GetMapping("/listar-compra-plan")
    public String listarCompraPlan(Model model) throws Exception {
        FiltroCompraPlanDTO filtro = new FiltroCompraPlanDTO();

        model.addAttribute("filtro", filtro);
        model.addAttribute("comprasPlan", compraPlanService.listarDetallesComprasSinCancelar());
        return "listar-compra-plan";
    }

    @GetMapping("/listar-plan")
    public String listarPlan(Model model) throws Exception {
        FiltroPlanDTO filtro = new FiltroPlanDTO();

        model.addAttribute("filtro", filtro);
        model.addAttribute("planes", planService.listarPlanes());
        model.addAttribute("tipoPlanes", planService.listarTipoPlanes());

        return "listar-plan";
    }

    @GetMapping("/filtro-compraPlan")
    public String filtroCompraPlan(@ModelAttribute("filtro") FiltroCompraPlanDTO filtro, Model model) throws Exception {
        List<CompraPlanGetDTO> compraPlan = new ArrayList<>();


        filtro = new FiltroCompraPlanDTO();

        model.addAttribute("filtro", filtro);
        //model.addAttribute("comprasPlan", compraPlanService.listarDetallesCompras());

        return "listar-compra-plan";
    }

    @GetMapping("/filtro-plan")
    public String filtroPlan(@ModelAttribute("filtro") FiltroPlanDTO filtro, Model model) throws Exception {

        filtro = new FiltroPlanDTO();

        model.addAttribute("filtro", filtro);
        model.addAttribute("planes", planService.listarPlanes());
        model.addAttribute("tipoPlanes", planService.listarTipoPlanes());

        return "listar-plan";
    }

    @GetMapping("/comprar-plan/{codigoPlan}")
    public String compraPlan(@PathVariable int codigoPlan, Model model) throws Exception {
        CompraPlanDTO compraPlan = new CompraPlanDTO();
        compraPlan.setCodigoPlan(codigoPlan);
        model.addAttribute("compraPlan", compraPlan);
        model.addAttribute("clientes", clienteService.listar());
        model.addAttribute("empleados", empleadoService.listar());
        model.addAttribute("agencias", agenciaService.listar());

        return "comprar-plan";
    }

    @PostMapping("/guardar-compra-plan")
    public String cancelarPlan(@ModelAttribute("compraPlan") CompraPlanDTO compraPlan) throws Exception {
        compraPlanService.crearCompraPlan(compraPlan);
        return "redirect:/CompraPlan/listar-plan";
    }
}
