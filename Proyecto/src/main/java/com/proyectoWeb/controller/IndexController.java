package com.proyectoWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {
    
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "/cliente/login";
    }

    @GetMapping("/registro")
    public String registro() {
        return "/cliente/register";
    }

    @GetMapping("/acerca")
    public String acerca() {
        return "/cliente/acercaDe";
    }

    @GetMapping("/contacto")
    public String contacto() {
        return "/cliente/contacto";
    }

    @GetMapping("/carros")
    public String galeria() {
        return "/cliente/galeria";
    }
}   
