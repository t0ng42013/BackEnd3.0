package com.portfolio.LGA.service;

import com.portfolio.LGA.InterService.IProyectoService;
import com.portfolio.LGA.model.Proyecto;
import com.portfolio.LGA.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectoService implements IProyectoService {
    @Autowired
    public ProyectoRepository proyectoRepository;
    @Override
    public List<Proyecto> verProyecto() {
        return proyectoRepository.findAll();
    }

    @Override
    public void crearProyecto(Proyecto proyecto) {
        proyectoRepository.save(proyecto);
    }

    @Override
    public void borrarProyecto(Long id) {
        proyectoRepository.deleteById(id);
    }

    @Override
    public Proyecto buscarProyecto(Long id) {
        return proyectoRepository.findById(id).orElse(null);
    }

    @Override
    public Proyecto editarProyecto(Proyecto proyecto) {
        Proyecto proyectos = proyectoRepository.findById(proyecto.getId()).orElse(null);
        proyecto.setNombre(proyecto.getNombre());
        proyecto.setDescripcion(proyecto.getDescripcion());
        proyecto.setImgUrl(proyecto.getImgUrl());
        proyecto.setVariableI(proyecto.getVariableI());

        return proyectoRepository.save(proyectos);
    }
}
