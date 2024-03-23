package com.gestion.clientes.dao;

import com.gestion.clientes.model.Persona;
import com.gestion.clientes.model.Referencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReferenciaDao extends JpaRepository<Referencia, Integer> {
}
