package com.proyectoWeb.service;

import com.proyectoWeb.domain.Comentario;
import java.util.List;


public interface ComentarioService {
    public List<Comentario> getComentarios();
    
    public void save (Comentario comentario);
    
    public void delete (Comentario comentario);
    
    public Comentario getComentario (Comentario comentario);
}
