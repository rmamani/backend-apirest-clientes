package com.gestion.clientes.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Entity
@Table(name="referencia")
@Getter
@Setter
public class Referencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRef;

    @OneToOne
    @JoinColumn(name="id", nullable = false)
    private Persona persona;

    @ManyToOne
    @JoinColumn(name="id_cliente", nullable=false)
    private Cliente cliente;

}
