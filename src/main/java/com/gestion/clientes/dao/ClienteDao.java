package com.gestion.clientes.dao;

import com.gestion.clientes.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteDao extends JpaRepository<Cliente, Integer> {
}
