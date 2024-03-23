package com.gestion.clientes.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="cliente")
@Getter
@Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;

    @Column(name = "email")
    private String email;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "ocupacion")
    private String ocupacion;

    @Column(name = "accesibilidad")
    private String accesibilidad = "NULA";

    @OneToOne
    @JoinColumn(name="id", nullable = false)
    private Persona persona;

    @Column(name = "estado")
    private String estado = "CREADO";
}
