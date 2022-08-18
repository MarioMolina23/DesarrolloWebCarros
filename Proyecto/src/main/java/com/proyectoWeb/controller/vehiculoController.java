package com.proyectoWeb.controller;

import com.proyectoWeb.domain.Vehiculo;
import com.proyectoWeb.service.VehiculoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j

public class vehiculoController {
    
    @Autowired
    private VehiculoService vehiculoService;
    
    @GetMapping("/")
    public String inicio(Model model){
        log.info("Administrador está en el área de vehículos");
        var vehiculos=vehiculoService.getVehiculos();
        model.addAttribute("vehiculos", vehiculos);
        return "/administrador/vehiculos";
    }
    
    @GetMapping("/nuevoVehiculo")
    public String nuevoVehiculo(Vehiculo vehiculo){
        return "/administrador/vehiculos";
    }
    
    @PostMapping("/guardarVehiculo")
    public String guardarVehiculo (Vehiculo vehiculo){
        vehiculoService.save(vehiculo);
        return "redirect:/";
    }
    
    @GetMapping("/modificarVehiculo/{id}")
    public String modificarVehiculo(Vehiculo vehiculo, Model model){
        vehiculo = vehiculoService.getVehiculo(vehiculo);
        model.addAttribute("vehiculo", vehiculo);
        return "/administrador/vehiculos";
    }
    
    @GetMapping("/eliminarVehiculo/{id}")
    public String eliminarVehiculo(Vehiculo vehiculo){
        vehiculoService.delete(vehiculo);
        return "redirect:/";
    }
        
    @GetMapping("/Galeria")
    public String galeria (){
        return "/cliente/galeria";
    }
    
    @GetMapping("/AcercaDe")
    public String acercaDe() {
        return "/cliente/acercaDe";
    }
        
    @GetMapping("/Contacto")
    public String contacto() {
        return "/cliente/contacto";
    }

    @GetMapping("/Login")
    public String login() {
        return "/cliente/login";
    }

    @GetMapping("/Register")
    public String register() {
        return "/cliente/register";
    }
    
    @GetMapping("/TerminosCondiciones")
    public String terminosCondiciones() {
        return "/cliente/terminosCondiciones";
    }
}