package com.gestion.clientes.service;

import com.gestion.clientes.dto.ClienteDto;
import com.gestion.clientes.model.Cliente;
import org.springframework.data.repository.query.Param;

import java.text.ParseException;
import java.util.List;

public interface ClienteService {

    List<Cliente> listar();

    String listarAccesibilidad(@Param("idcliente") int idcliente);

    Cliente crear(ClienteDto cli) throws ParseException;
}
