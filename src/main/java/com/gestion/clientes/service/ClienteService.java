package com.gestion.clientes.service;

import com.gestion.clientes.dto.ClienteDto;
import com.gestion.clientes.model.Cliente;

import java.text.ParseException;
import java.util.List;

public interface ClienteService {

    List<Cliente> listar();

    String listarAccesibilidad(int idCliente);

    Cliente crear(ClienteDto cli) throws ParseException;
}
