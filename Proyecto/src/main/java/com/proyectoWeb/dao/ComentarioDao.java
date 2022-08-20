package com.proyectoWeb.dao;

import com.proyectoWeb.domain.Comentario;
import org.springframework.data.repository.CrudRepository;


public interface ComentarioDao extends CrudRepository<Comentario, Long>{
    
}
