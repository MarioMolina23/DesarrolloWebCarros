package com.proyectoWeb.service;

import com.proyectoWeb.domain.Vehiculo;
import java.util.List;


public interface VehiculoService {
    public List<Vehiculo> getVehiculos();
    
    public void save (Vehiculo vehiculo);
    
    public void delete (Vehiculo vehiculo);
    
    public Vehiculo getVehiculo (Vehiculo vehiculo);
}
