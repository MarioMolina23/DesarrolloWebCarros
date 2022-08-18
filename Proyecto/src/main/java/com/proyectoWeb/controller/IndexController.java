package com.proyectoWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {
    
    @GetMapping("/index")
    public String inicio() {
        return "index";
    }
    
    @GetMapping("/cliente/galeria")
    public String galeria (){
        return "/cliente/galeria";
    }
    
    @GetMapping("/cliente/contacto")
    public String contacto() {
        return "/cliente/contacto";
    }
    
    @GetMapping("/cliente/acercaDe")
    public String acercaDe() {
        return "/cliente/acercaDe";
    }
    
    @GetMapping("/cliente/terminosCondiciones")
    public String terminosCondiciones() {
        return "/cliente/terminosCondiciones";
    }
    
    @GetMapping("/cliente/login")
    public String login() {
        return "/cliente/login";
    }

    @GetMapping("/cliente/register")
    public String registro() {
        return "/cliente/register";
    }

    @GetMapping("/carros/audi")
    public String carroAudi() {
        return "/carros/audi";
    }

    @GetMapping("/carros/bmw")
    public String carrobmw() {
        return "/carros/bmw";
    }

    @GetMapping("/carros/honda")
    public String carroHonda() {
        return "/carros/honda";
    }

    @GetMapping("/carros/mitsubishi")
    public String carroMitsubishi() {
        return "/carros/mitsubishi";
    }

    @GetMapping("/carros/toyota")
    public String carroToyota() {
        return "/carros/toyota";
    }

    @GetMapping("/carros/volvo")
    public String carroVolvo() {
        return "/carros/volvo";
    }
    
    @GetMapping("/comprar/compra")
    public String compra() {
        return "/comprar/compra";
    }
    
    @GetMapping("/administrador/vehiculos")
    public String admiVehiculo() {
        return "/administrador/vehiculos";
    }
}