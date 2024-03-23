package com.gestion.clientes.service.impl;

import com.gestion.clientes.dao.ClienteDao;
import com.gestion.clientes.dao.PersonaDao;
import com.gestion.clientes.dao.ReferenciaDao;
import com.gestion.clientes.dto.ReferenciaDto;
import com.gestion.clientes.model.Cliente;
import com.gestion.clientes.model.Referencia;
import com.gestion.clientes.service.ReferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Service
public class ReferenciaServiceImpl implements ReferenciaService {
    @Autowired
    private ReferenciaDao referenciaDao;

    @Autowired
    private PersonaDao personaDao;

    @Autowired
    private ClienteDao clienteDao;

    @Override
    public List<Referencia> listar() {

        return referenciaDao.findAll();
    }

    @Transactional
    @Override
    public Referencia crear(ReferenciaDto ref) throws ParseException {
        Cliente cliente = clienteDao.findById(ref.getIdCliente()).get();
        ref.getReferenciaList().forEach(d -> {
            Referencia r = new Referencia();
                r.setCliente(cliente);
            personaDao.save(d);
            r.setPersona(d);
            referenciaDao.save(r);
        });
        cliente.setEstado("ACTIVO");
        clienteDao.save(cliente);
        return null;
    }
}
