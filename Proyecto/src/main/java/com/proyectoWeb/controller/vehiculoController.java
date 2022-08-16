package com.proyectoWeb.controller;

import com.proyectoWeb.service.VehiculoServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j

public class vehiculoController {
    
    @Autowired
    private VehiculoServiceImpl vehiculoService;

    @GetMapping("/administrador/modificarVehiculo")
    public String inicio(Model model){
        log.info("Estamos aqui");
        var vehiculos=vehiculoService.getVehiculos();
        model.addAttribute("vehiculos", vehiculos);
        return "/administrador/modificarVehiculo";
    }
}   
