package com.portfolio.LGA.controller;

import com.portfolio.LGA.InterService.IProyectoService;
import com.portfolio.LGA.dto.Mensaje;
import com.portfolio.LGA.dto.ProyectoDto;
import com.portfolio.LGA.model.Proyecto;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyecto")
@CrossOrigin(origins = {"https://lga-portfolio.web.app/","http://localhost:4200"})
public class ProyectoController {
    @Autowired
    private IProyectoService proyectoService;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> verProyecto() {
        List<Proyecto> proyectos = proyectoService.verProyecto();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody ProyectoDto proyectoDto) {
        if (StringUtils.isBlank(proyectoDto.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Proyecto proyecto = new Proyecto(
                proyectoDto.getNombre(),
                proyectoDto.getDescripcion(),
                proyectoDto.getImgUrl(),
                proyectoDto.getVariableI());
        proyectoService.crearProyecto(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto creado"), HttpStatus.CREATED);
    }

    @PutMapping("/editar")
    public ResponseEntity<?> editarProyecto(@RequestBody Proyecto proyecto) {
        proyectoService.editarProyecto(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto editado"), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Proyecto> buscarProyecto(@PathVariable Long id) {
        if (proyectoService.buscarProyecto(id) == null) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(proyectoService.buscarProyecto(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void borrarProyecto(@PathVariable Long id){
        proyectoService.borrarProyecto(id);
    }
}
