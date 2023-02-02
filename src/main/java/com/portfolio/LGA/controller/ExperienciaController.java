package com.portfolio.LGA.controller;

import com.portfolio.LGA.dto.ExperienciaDto;
import com.portfolio.LGA.dto.Mensaje;
import com.portfolio.LGA.model.Experiencia;
import com.portfolio.LGA.service.ExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experiencia")
@CrossOrigin(origins = {"https://lga-portfolio.web.app/","http://localhost:4200"})
public class ExperienciaController {
    @Autowired
    private ExperienciaService experienciaService;


    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> verExperiencia() {
        List<Experiencia> experiencias = experienciaService.verExperiencia();
        return new ResponseEntity(experiencias, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<ExperienciaDto> crearExperiencia(@RequestBody ExperienciaDto experienciaDto){
        experienciaService.crearExperiencia(experienciaDto);
        return new ResponseEntity(new Mensaje("Experiencia Creada"), HttpStatus.CREATED);
    }

    @PutMapping("/editar")
    public ResponseEntity<ExperienciaDto> editarExperiencia(@RequestBody ExperienciaDto experienciaDto) {
        experienciaService.editarExperiencia(experienciaDto);

        return new ResponseEntity(new Mensaje("Experiencia editada"), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Experiencia> buscarExperiencia(@PathVariable Long id) {
        if (experienciaService.buscarExperiencia(id) == null) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(experienciaService.buscarExperiencia(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void borrarExperiencia(@PathVariable Long id){
        experienciaService.borrarExperiencia(id);
    }
}
