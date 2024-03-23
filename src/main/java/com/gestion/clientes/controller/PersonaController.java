package com.gestion.clientes.controller;

import com.gestion.clientes.model.Cliente;
import com.gestion.clientes.model.Persona;
import com.gestion.clientes.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {
    @Autowired
    PersonaService personaService;

    @GetMapping
    public ResponseEntity<List<Persona>> listar(){
        List<Persona> personas = new ArrayList<>();
        personas = personaService.listar();
        return new ResponseEntity<List<Persona>>(personas, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registrar(@RequestBody Persona per){
        Persona p = personaService.crear(per);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(p.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
