package com.gestion.clientes.dao;

import com.gestion.clientes.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ClienteDao extends JpaRepository<Cliente, Integer> {

    @org.springframework.data.jpa.repository.Query(value = "SELECT COUNT(*) FROM referencia WHERE id_cliente = :idcliente ", nativeQuery = true)
    int listarAccesibilidad(@Param("idcliente") int idcliente);
}
