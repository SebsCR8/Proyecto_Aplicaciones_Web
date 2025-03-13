package com.smartdealerCrm.service.impl;

import com.smartdealerCrm.dao.CitasDao;
import com.smartdealerCrm.domain.Citas;
import com.smartdealerCrm.service.CitasService;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitasServiceImpl implements CitasService {

    @Autowired
    private CitasDao citasRepository;

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
        return citasRepository.findById(citas.getIdCita()).orElse(null);
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

            citas.setIdCarro(1);
            citas.setNotas(citas.getMotivo());
            citas.setTipoServicio(citas.getMarca());

            citasRepository.save(citas);
        } catch (DateTimeParseException e) {
            throw new RuntimeException("Error al parsear la fecha: " + e.getMessage());
        }
    } 
} 



