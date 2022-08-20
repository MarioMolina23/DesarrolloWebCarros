package com.proyectoWeb.service;

import com.proyectoWeb.dao.ComentarioDao;
import com.proyectoWeb.domain.Comentario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ComentarioServiceImpl implements ComentarioService {

    @Autowired
    private ComentarioDao comentarioDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Comentario> getComentarios() {
        return (List<Comentario>) comentarioDao.findAll();
    }

    @Override
    @Transactional
    public void save(Comentario comentario) {
        comentarioDao.save(comentario);
    }

    @Override
    @Transactional
    public void delete(Comentario comentario) {
        comentarioDao.delete(comentario);
    }

    @Override
    @Transactional(readOnly = true)
    public Comentario getComentario(Comentario comentario) {
        return comentarioDao.findById(comentario.getId()).orElse(null);
    }
}