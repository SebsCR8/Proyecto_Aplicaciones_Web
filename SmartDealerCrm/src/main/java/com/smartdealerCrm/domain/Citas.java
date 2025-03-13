package com.smartdealerCrm.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Transient;

@Entity
@Table(name = "Citas")
@Data
@NoArgsConstructor
public class Citas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCita; 
    
    @Column(name = "id_carro")
    private Integer idCarro;
    
    @Column(name = "fecha_cita", nullable = false)
    private Date fechaCita;
    
    @Column(name = "tipo_servicio")
    private String tipoServicio;
    
    @Column(name = "notas")
    private String notas;
    
    // Campos transitorios (no en BD)
    @Transient private String marca;
    @Transient private String modelo;
    @Transient private String año;
    @Transient private String placa;
    @Transient private String telefonoContacto;
    @Transient private String motivo;

    public Citas(int idCarro, Date fechaCita, String tipoServicio, String notas) {
        this.idCarro = idCarro;
        this.fechaCita = fechaCita;
        this.tipoServicio = tipoServicio;
        this.notas = notas;
    }
}

