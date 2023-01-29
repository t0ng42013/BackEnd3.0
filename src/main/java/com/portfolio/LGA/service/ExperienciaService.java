package com.portfolio.LGA.service;

import com.portfolio.LGA.InterService.IExperienciaService;
import com.portfolio.LGA.model.Experiencia;
import com.portfolio.LGA.repository.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienciaService implements IExperienciaService {
    @Autowired
    public ExperienciaRepository experienciaRepository;
    @Override
    public List<Experiencia> verExperiencia() {
        return experienciaRepository.findAll();
    }

    @Override
    public void crearExperiencia(Experiencia experiencia) {
        experienciaRepository.save(experiencia);
    }

    @Override
    public void borrarExperiencia(Long id) {
        experienciaRepository.deleteById(id);
    }

    @Override
    public Experiencia buscarExperiencia(Long id) {
        return experienciaRepository.findById(id).orElse(null);
    }

    @Override
    public Experiencia editarExperiencia(Experiencia experiencia) {
        Experiencia experiencias = experienciaRepository.findById(experiencia.getId()).orElse(null);
        experiencias.setNombre(experiencia.getNombre());
        experiencias.setInicio(experiencia.getInicio());
        experiencias.setFin(experiencia.getFin());
        experiencias.setTrabajo(true);
        experiencias.setTarea1(experiencia.getTarea1());
        experiencias.setTarea2(experiencia.getTarea2());
        experiencias.setTarea3(experiencia.getTarea3());
        experiencias.setTarea4(experiencia.getTarea4());
        return experienciaRepository.save(experiencias);
    }
}
