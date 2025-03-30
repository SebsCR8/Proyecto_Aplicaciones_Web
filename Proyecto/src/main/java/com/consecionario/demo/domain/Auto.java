/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.consecionario.demo.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Auto")
@Data
public class Auto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Auto")
    private Integer idAuto; // Primary key

    @Column(name = "Modelo", nullable = false)
    private String modelo;

    @Column(name = "Anno", nullable = false)
    private Integer anno;

    @Column(name = "Precio", nullable = false)
    private String precio; // Changed to String as per your previous request

    @Column(name = "Tipo", nullable = false)
    private String tipo;

    @Column(name = "Especificaciones")
    private String especificaciones;

    @Column(name = "Imagen", nullable = false)
    private String imagen;

    @OneToMany
    @JoinColumn(name = "ID_Auto", updatable = false)
    List<Auto> Auto;

    public Auto() {
    }

    public Auto(String modelo, String especificaciones) {
        this.modelo = modelo;
        this.especificaciones = especificaciones;
    }

    public void setId(Long id) {
    }

}
