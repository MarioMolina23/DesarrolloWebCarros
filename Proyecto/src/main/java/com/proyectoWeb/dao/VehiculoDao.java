package com.proyectoWeb.dao;

import com.proyectoWeb.domain.Vehiculo;
import org.springframework.data.repository.CrudRepository;


public interface VehiculoDao extends CrudRepository<Vehiculo, Long>{
    
}
