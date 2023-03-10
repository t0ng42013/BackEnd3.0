package com.portfolio.LGA.InterService;

import com.portfolio.LGA.model.Experiencia;

import java.util.List;

public interface IExperienciaService {
    public List<Experiencia> verExperiencia();

    public void crearExperiencia(Experiencia experiencia);

    public void borrarExperiencia(Long id);

    public Experiencia buscarExperiencia(Long id);

    public Experiencia editarExperiencia(Experiencia experiencia);
}
