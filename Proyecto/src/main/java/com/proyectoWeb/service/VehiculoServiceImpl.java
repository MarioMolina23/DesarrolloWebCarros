package com.proyectoWeb.service;

import com.proyectoWeb.dao.VehiculoDao;
import com.proyectoWeb.domain.Vehiculo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    private VehiculoDao vehiculoDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Vehiculo> getVehiculos() {
        return (List<Vehiculo>) vehiculoDao.findAll();
    }

    @Override
    @Transactional()
    public void save(Vehiculo vehiculo) {
        vehiculoDao.save(vehiculo);
    }

    @Override
    @Transactional()
    public void delete(Vehiculo vehiculo) {
        vehiculoDao.delete(vehiculo);
    }

    @Override
    @Transactional(readOnly = true)
    public Vehiculo getVehiculo(Vehiculo vehiculo) {
        return vehiculoDao.findById(vehiculo.getId()).orElse(null);
    }
}