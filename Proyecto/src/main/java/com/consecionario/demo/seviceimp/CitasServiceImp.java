package com.consecionario.demo.seviceimp;

import com.consecionario.demo.repositories.CitasRepository;
import com.consecionario.demo.domain.Citas;
import com.consecionario.demo.services.CitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class CitasServiceImp implements CitasService {

    @Autowired
    private CitasRepository citasRepository;

   
    @Override
    public Citas crearCitas(Citas citas) {
        return citasRepository.save(citas);
    }

   
    @Override
    public void save(Citas citas) {
        citasRepository.save(citas);
    }

   
    @Override
    public void delete(Citas citas) {
        citasRepository.delete(citas);
    }

   
    @Override
    public List<Citas> getCitas(boolean activas) {
       
        return citasRepository.findAll();
    }

    
    @Override
    public Citas getCitas(Citas citas) {
        return citasRepository.findById(citas.getIdCitas()).orElse(null);
    }

   
    @Override
    public List<Citas> obtenerTodasLasCitas() {
        return citasRepository.findAll();
    }

  
    @Override
    public void guardarCitas(Citas citas) {
        try {
           
            if (citas.getFechaCita() != null) {
                LocalDateTime fechaHoraLocal = citas.getFechaCita().toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime();
                Date fechaCita = Date.from(fechaHoraLocal.atZone(ZoneId.systemDefault()).toInstant());
                citas.setFechaCita(fechaCita);
            }
            citasRepository.save(citas);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar la cita: " + e.getMessage());
        }
    }
}


