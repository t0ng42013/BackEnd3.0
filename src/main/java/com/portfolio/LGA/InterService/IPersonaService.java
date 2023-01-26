package com.portfolio.LGA.InterService;

import com.portfolio.LGA.model.Persona;

import java.util.List;

public interface IPersonaService {
    public List<Persona> verPersonas();
    public void crearPersona(Persona persona);
    public void borrarPersona(Long id);
    public Persona buscarPersona(Long id);
    public Persona editarPersona(Persona persona);
}
