package com.consecionario.demo.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Citas")
@Data
public class Citas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Citas")
    private Integer idCitas;

    @ManyToOne
    @JoinColumn(name = "ID_Usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "ID_Auto", nullable = false)
    private Auto auto;

    @Column(name = "Enganche", nullable = false)
    private String enganche;

    @Column(name = "TasaInteres", nullable = false)
    private String tasaInteres;

    @Column(name = "Plazo", nullable = false)
    private Integer plazo;

    @Column(name = "PagoMensual", nullable = false)
    private String pagoMensual;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FechaCita", nullable = false)
    private Date fechaCita;


    public Citas(Usuario usuario, Auto auto, String enganche, String tasaInteres, Integer plazo, String pagoMensual, Date fechaCita) {
        this.usuario = usuario;
        this.auto = auto;
        this.enganche = enganche;
        this.tasaInteres = tasaInteres;
        this.plazo = plazo;
        this.pagoMensual = pagoMensual;
        this.fechaCita = fechaCita;
    }
    
    

    public Citas() {
    }

}
