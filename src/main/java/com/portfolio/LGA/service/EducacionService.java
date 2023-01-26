package com.portfolio.LGA.service;

import com.portfolio.LGA.InterService.IEducacionService;
import com.portfolio.LGA.model.Educacion;
import com.portfolio.LGA.repository.EducacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducacionService implements IEducacionService {
    @Autowired
    public EducacionRepository educacionRepository;
    @Override
    public List<Educacion> verEducacion() {
        return educacionRepository.findAll();
    }

    @Override
    public void crearEducacion(Educacion educacion) {
        educacionRepository.save(educacion);
    }

    @Override
    public void borrarEducacion(Long id) {
        educacionRepository.deleteById(id);
    }

    @Override
    public Educacion buscarEducacion(Long id) {
        return educacionRepository.findById(id).orElse(null);
    }

    @Override
    public Educacion editarEducacion(Educacion educacion) {
        Educacion educacions = educacionRepository.findById(educacion.getId()).orElse(null);
        educacion.setInstituto(educacion.getInstituto());
        educacion.setInicio(educacion.getInicio());
        educacion.setFin(educacion.getFin());
        educacion.setTitulo(educacion.getTitulo());

        return educacionRepository.save(educacions);
    }
}
