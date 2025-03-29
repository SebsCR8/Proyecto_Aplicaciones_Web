/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.consecionario.demo.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;


@Entity
@Table(name = "Auto")
@Data
public class Auto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Auto")
    private Integer idAuto;

    @Column(name = "Modelo", nullable = false)
    private String modelo;

    @Column(name = "Anno", nullable = false)
    private Integer anno;

    @Column(name = "Precio", nullable = false)
    private String precio;

    @Column(name = "Tipo", nullable = false)
    private String tipo;

    @Column(name = "Especificaciones")
    private String especificaciones;

    @Column(name = "Imagen", nullable = false)
    private String imagen;

    @ManyToOne
    @JoinColumn(name = "ID_Auto", nullable = false)
    private Auto auto;

    public void setId(Long id) {
       
    }
}
