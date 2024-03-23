package com.gestion.clientes.service;

import com.gestion.clientes.model.Persona;

import java.util.List;

public interface PersonaService {

    List<Persona> listar();

    Persona crear(Persona per);
}
