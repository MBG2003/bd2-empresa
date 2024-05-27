package com.example.proyecto_final_empresa.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Slf4j
@RequestMapping("/")
@CrossOrigin("*")
public class HomeController {

    @GetMapping("/")
    public String inicio() {
        return "index";
    }
}
