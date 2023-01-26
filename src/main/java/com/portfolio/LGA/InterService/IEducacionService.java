package com.portfolio.LGA.InterService;

import com.portfolio.LGA.model.Educacion;

import java.util.List;

public interface IEducacionService {
    public List<Educacion> verEducacion();

    public void crearEducacion(Educacion educacion);

    public void borrarEducacion(Long id);

    public Educacion buscarEducacion(Long id);

    public Educacion editarEducacion(Educacion educacion);

}
