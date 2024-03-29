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
        return "/administrador/modificarVehiculo";
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
        return "/administrador/modificarVehiculo";
    }
    
    @GetMapping("/eliminarVehiculo/{id}")
    public String eliminarVehiculo(Vehiculo vehiculo){
        vehiculoService.delete(vehiculo);
        return "redirect:/";
    }

}