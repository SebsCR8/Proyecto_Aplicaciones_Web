package com.consecionario.demo.services;

import com.consecionario.demo.domain.Citas;
import java.util.List;

public interface CitasService {
    Citas crearCitas(Citas citas);
    void save(Citas citas);
    void delete(Citas citas);
    List<Citas> getCitas(boolean activas);
    Citas getCitas(Citas citas);
    List<Citas> obtenerTodasLasCitas();
    void guardarCitas(Citas citas); 
}