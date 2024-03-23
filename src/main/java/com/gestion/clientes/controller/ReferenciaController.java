package com.gestion.clientes.controller;


import com.gestion.clientes.dto.ReferenciaDto;
import com.gestion.clientes.model.Referencia;
import com.gestion.clientes.service.ReferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/referencia")
public class ReferenciaController {

    @Autowired
    ReferenciaService referenciaService;

    @GetMapping
    public ResponseEntity<List<Referencia>> listar(){
        List<Referencia> referencias = new ArrayList<>();
        referencias = referenciaService.listar();
        return new ResponseEntity<List<Referencia>>(referencias, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Referencia registrar(@RequestBody ReferenciaDto cli) throws ParseException {
        return referenciaService.crear(cli);
    }
}

