package com.portfolio.LGA.service;

import com.portfolio.LGA.InterService.ICursoService;
import com.portfolio.LGA.model.Curso;
import com.portfolio.LGA.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService implements ICursoService {
    @Autowired
    public CursoRepository cursoRepository;
    @Override
    public List<Curso> verCurso() {
        return cursoRepository.findAll();
    }

    @Override
    public void crearCurso(Curso curso) {
        cursoRepository.save(curso);
    }

    @Override
    public void borrarCurso(Long id) {
        cursoRepository.deleteById(id);
    }

    @Override
    public Curso buscarCurso(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    @Override
    public Curso editarCurso(Curso curso) {
        Curso cursos = cursoRepository.findById(curso.getId()).orElse(null);
        cursos.setInstituto(curso.getInstituto());
        cursos.setInicio(curso.getInicio());
        cursos.setFin(curso.getFin());
        cursos.setTitulo(curso.getTitulo());

        return cursoRepository.save(cursos);
    }
}
