package com.portfolio.LGA.service;

import com.portfolio.LGA.InterService.IExperienciaService;
import com.portfolio.LGA.dto.ExperienciaDto;
import com.portfolio.LGA.model.Experiencia;
import com.portfolio.LGA.repository.ExperienciaRepository;
import com.portfolio.LGA.repository.PersonaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienciaService implements IExperienciaService {
    private final ExperienciaRepository experienciaRepository;
    private final ModelMapper modelMapper;

    public ExperienciaService(ExperienciaRepository experienciaRepository, ModelMapper modelMapper) {
        this.experienciaRepository = experienciaRepository;
        this.modelMapper = modelMapper;
    }

    @Autowired

    @Override
    public List<Experiencia> verExperiencia() {
        return experienciaRepository.findAll();
    }

    @Override
    public void crearExperiencia(ExperienciaDto experienciaDto) {
        Experiencia experiencia = modelMapper.map(experienciaDto, Experiencia.class);
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
    public Experiencia editarExperiencia(ExperienciaDto experienciaDto) {
        Experiencia experiencia = experienciaRepository.findById(experienciaDto.getId()).orElse(null);
        modelMapper.map(experienciaDto, experiencia);
        return experienciaRepository.save(experiencia);
    }
}
