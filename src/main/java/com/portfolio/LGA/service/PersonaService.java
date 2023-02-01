package com.portfolio.LGA.service;

import com.portfolio.LGA.InterService.IPersonaService;
import com.portfolio.LGA.dto.PersonaDto;
import com.portfolio.LGA.dto.PersonaNotFoundException;
import com.portfolio.LGA.model.Persona;
import com.portfolio.LGA.repository.PersonaRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class PersonaService implements IPersonaService {
    private final PersonaRepository personaRepository;
    private final ModelMapper modelMapper;
    @Autowired
    public PersonaService(PersonaRepository personaRepository, ModelMapper modelMapper) {
    this.personaRepository = personaRepository;
    this.modelMapper = modelMapper;
    }
    @Override
    public List<PersonaDto> verPersonas() {
        List<Persona> personas = personaRepository.findAll();
        Type listType = new TypeToken<List<PersonaDto>>(){}.getType();
        List<PersonaDto> personaDTOs = modelMapper.map(personas, listType);
        return personaDTOs;
    }

    @Override
    public void crearPersona(PersonaDto personaDto) {
        Persona persona = modelMapper.map(personaDto, Persona.class);
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
<<<<<<< HEAD
    public Persona editarPersona(Long id, PersonaDto personaDto) {
        Persona persona = personaRepository.findById(id).orElseThrow(() -> new PersonaNotFoundException(id));
        modelMapper.map(personaDto, persona);
        return personaRepository.save(persona);
=======
    public Persona editarPersona(Persona persona) {
        Persona personas = personaRepository.findById(persona.getId()).orElse(null);
        personas.setNombre(persona.getNombre());
        personas.setApellido(persona.getApellido());
        personas.setTitulo(persona.getTitulo());
        personas.setDomicilio(persona.getDomicilio());
        personas.setSobreMi(persona.getSobreMi());
        personas.setUrl(persona.getUrl());
        return personaRepository.save(personas);
>>>>>>> d3ee361917a95698a9fe65813feefa3f77315eba
    }

}
