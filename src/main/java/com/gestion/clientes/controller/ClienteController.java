package com.gestion.clientes.controller;

import com.gestion.clientes.dto.ClienteDto;
import com.gestion.clientes.model.Cliente;
import com.gestion.clientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listar(){
        List<Cliente> clientes = new ArrayList<>();
        clientes = clienteService.listar();
        return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Cliente registrar(@RequestBody ClienteDto cli) throws ParseException {

        return clienteService.crear(cli);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public String listarAccesibilidad(@PathVariable("id") Integer id){

        return clienteService.listarAccesibilidad(id);
    }
}
