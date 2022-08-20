package com.proyectoWeb.controller;

import com.proyectoWeb.domain.Comentario;
import com.proyectoWeb.service.ComentarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class comentarioController {
    
    @Autowired
    private ComentarioService comentarioService;
    
    @GetMapping("/administrador/comentarios")
    public String inicio(Model model){
        log.info("Administrador está en el área de comentarios");
        var comentarios=comentarioService.getComentarios();
        model.addAttribute("comentarios", comentarios);
        return "/administrador/comentarios";
    }
    
    @GetMapping("/nuevoComentario")
    public String nuevoComentario(Comentario comentario){
        return "/cliente/contacto";
    }
    
    @PostMapping("/guardarComentario")
    public String guardarComentario (Comentario comentario){
        comentarioService.save(comentario);
        return "/index";
    }
    
    @GetMapping("/eliminarComentario/{id}")
    public String eliminarComentario(Comentario comentario){
        comentarioService.delete(comentario);
        return "redirect:/administrador/comentarios";
    }

}