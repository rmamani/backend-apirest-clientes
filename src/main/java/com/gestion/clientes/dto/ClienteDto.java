package com.gestion.clientes.dto;

import com.gestion.clientes.model.Persona;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.boot.jaxb.hbm.internal.RepresentationModeConverter;

@Getter
@Setter
public class ClienteDto extends RepresentationModeConverter {

    private String email;
    private String telefono;
    private String ocupacion;
    private Persona persona;
}
