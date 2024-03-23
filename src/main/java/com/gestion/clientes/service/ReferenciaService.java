package com.gestion.clientes.service;

import com.gestion.clientes.dto.ReferenciaDto;
import com.gestion.clientes.model.Referencia;

import java.text.ParseException;
import java.util.List;

public interface ReferenciaService {
    List<Referencia> listar();

    Referencia crear(ReferenciaDto cli) throws ParseException;

}
