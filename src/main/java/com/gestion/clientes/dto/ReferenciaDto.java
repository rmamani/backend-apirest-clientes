package com.gestion.clientes.dto;

import com.gestion.clientes.model.Persona;
import com.gestion.clientes.model.Referencia;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.boot.jaxb.hbm.internal.RepresentationModeConverter;

import java.util.List;

@Getter
@Setter
public class ReferenciaDto extends RepresentationModeConverter {

    private int idCliente;
    private List<Persona> referenciaList;
}
