package com.portfolio.LGA.service;

import com.portfolio.LGA.InterService.IPersonaService;
import com.portfolio.LGA.model.Persona;
import com.portfolio.LGA.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements IPersonaService {
    @Autowired
    public PersonaRepository personaRepository;

    @Override
    public List<Persona> verPersonas() {
        return personaRepository.findAll();
    }

    @Override
    public void crearPersona(Persona persona) {
        personaRepository.save(persona);
    }

    @Override
    public void borrarPersona(Long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public Persona buscarPersona(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    public Persona editarPersona(Persona persona) {
        Persona personas = personaRepository.findById(persona.getId()).orElse(null);
        personas.setNombre(persona.getNombre());
        personas.setApellido(persona.getApellido());
        personas.setTitulo(persona.getTitulo());
        personas.setDomicilio(persona.getDomicilio());
        personas.setSobreMi(persona.getSobreMi());
        personas.setUrl(persona.getUrl());
        return personaRepository.save(personaEditada);
    }
}
