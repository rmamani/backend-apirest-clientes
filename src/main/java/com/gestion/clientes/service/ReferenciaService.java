package com.gestion.clientes.service;

import com.gestion.clientes.dto.ReferenciaDto;
import com.gestion.clientes.model.Referencia;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface ReferenciaService {
    List<Referencia> listar();

    Referencia crear(ReferenciaDto cli) throws ParseException;

    void eliminar(int id);

    Optional<Referencia> buscarPorId(int id);

}
