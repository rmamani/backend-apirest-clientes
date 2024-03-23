package com.gestion.clientes.service.impl;

import com.gestion.clientes.dao.PersonaDao;
import com.gestion.clientes.model.Persona;
import com.gestion.clientes.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    private PersonaDao personaDao;

    @Override
    public List<Persona> listar() {
        return personaDao.findAll();
    }

    @Override
    public Persona crear(Persona per) {
        return personaDao.save(per);
    }
}
