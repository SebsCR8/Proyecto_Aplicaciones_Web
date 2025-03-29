/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.consecionario.demo.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "Usuario")
@Data
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Usuario")
    private Integer idUsuario;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "Correo", nullable = false, unique = true)
    private String correo;

    @Column(name = "Contrasenna", nullable = false)
    private String contrasenna;

    @Column(name = "ID_Rol", nullable = false)
    private String rol;

    public void setId(Long id) {
       
    }
}
