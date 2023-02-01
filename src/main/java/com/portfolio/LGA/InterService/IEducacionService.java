package com.portfolio.LGA.InterService;

import com.portfolio.LGA.dto.EducacionDto;
import com.portfolio.LGA.model.Educacion;

import java.util.List;

public interface IEducacionService {
    public List<Educacion> verEducacion();
    public void crearEducacion(EducacionDto educacionDto);
    public void borrarEducacion(Long id);
    public Educacion buscarEducacion(Long id);
    public Educacion editarEducacion(Long id,EducacionDto educacionDto);

}
