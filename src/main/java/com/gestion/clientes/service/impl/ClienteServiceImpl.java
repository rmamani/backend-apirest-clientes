package com.gestion.clientes.service.impl;

import com.gestion.clientes.dao.ClienteDao;
import com.gestion.clientes.dao.PersonaDao;
import com.gestion.clientes.dao.ReferenciaDao;
import com.gestion.clientes.dto.ClienteDto;
import com.gestion.clientes.model.Cliente;
import com.gestion.clientes.service.ClienteService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteDao clienteDao;

    @Autowired
    private PersonaDao personaDao;

    EntityManager entityManager;

    @Override
    public List<Cliente> listar() {
        return clienteDao.findAll();
    }

    @Override
    public String listarAccesibilidad(int idCliente) {
        Query query = entityManager.createQuery("SELECT COUNT(*) FROM referencia WHERE id_cliente = ?1 AND estado = 'ACTIVO'");
        query.setParameter(1, idCliente);
        long nroReferencias = (long) query.getSingleResult();
        if(nroReferencias>=2)
            return "BUENA";
        else if(nroReferencias==1)
            return "REGULAR";
        else if(nroReferencias==1)
            return "MALA";
        else if(nroReferencias==0)
            return "NULA";
        return "";
    }

    @Transactional
    @Override
    public Cliente crear(ClienteDto cli){
        personaDao.findById(cli.getPersona().getId());
       if(calculaEdad(cli.getPersona().getFechaNacimiento())<20)
           return null;
    Cliente c = new Cliente();
    c.setEmail(cli.getEmail());
    c.setTelefono(cli.getTelefono());
    c.setOcupacion(cli.getOcupacion());
    c.setPersona(cli.getPersona());
    personaDao.save(c.getPersona());
    return clienteDao.save(c);
    }
    public int calculaEdad(LocalDate fechanac){
        /*LocalDate d3 = LocalDate.parse("2008-05-06", DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate d4 = LocalDate.parse("2022-01-23", DateTimeFormatter.ISO_LOCAL_DATE);*/
        LocalDate fechaActual = LocalDate.now();
        Period period = Period.between(fechanac, fechaActual);

        int years = Math.abs(period.getYears());
        int months = Math.abs(period.getMonths());
        int days = Math.abs(period.getDays());
        System.out.println(
                "Diffrence is : " + years + " year, " + months + " months, " + days + " days");
        return years;
    }
}
