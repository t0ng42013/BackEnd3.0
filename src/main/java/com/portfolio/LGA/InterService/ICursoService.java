package com.portfolio.LGA.InterService;

import com.portfolio.LGA.model.Curso;

import java.util.List;

public interface ICursoService {
    public List<Curso> verCurso();

    public void crearCurso(Curso curso);

    public void borrarCurso(Long id);

    public Curso buscarCurso(Long id);

    public Curso editarCurso(Curso curso);
}
