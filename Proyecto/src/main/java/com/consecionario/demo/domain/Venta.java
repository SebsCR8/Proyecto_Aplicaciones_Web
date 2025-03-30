/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.consecionario.demo.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Ventas")
@Data
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Venta")
    private Integer idVenta;

    @Column(name = "ID_Usuario", nullable = false)
    private Integer idUsuario;

    @Column(name = "ID_Auto", nullable = false)
    private Integer idAuto;

    @Column(name = "Precio", nullable = false)
    private String precio;

    @Column(name = "Fecha_Venta", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVenta;

    @Column(name = "Total", nullable = false)
    private String total;

    public void setId(Long id) {
    }
}
