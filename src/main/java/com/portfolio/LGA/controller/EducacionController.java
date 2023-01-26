package com.portfolio.LGA.controller;

import com.portfolio.LGA.InterService.IEducacionService;
import com.portfolio.LGA.dto.EducacionDto;
import com.portfolio.LGA.dto.Mensaje;
import com.portfolio.LGA.model.Educacion;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/educacion")
@CrossOrigin(origins = {"https://lga-portfolio.web.app","http://localhost:4200"})
public class EducacionController {
    @Autowired
    private IEducacionService educacionService;

    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> verEducacion() {
        List<Educacion> educacions = educacionService.verEducacion();
        return new ResponseEntity(educacions, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody EducacionDto educacionDto) {
        if (StringUtils.isBlank(educacionDto.getInstituto())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = new Educacion(
                educacionDto.getInstituto(),
                (Date) educacionDto.getInicio(),
                (Date) educacionDto.getFin(),
                educacionDto.getTitulo());
        educacionService.crearEducacion(educacion);
        return new ResponseEntity(new Mensaje("Educacion creada"), HttpStatus.CREATED);
    }

    @PutMapping("/editar")
    public ResponseEntity<?> editarEducacion(@RequestBody Educacion educacion) {
        educacionService.editarEducacion(educacion);
        return new ResponseEntity(new Mensaje("Educacion editada"), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Educacion> buscarEducacion(@PathVariable Long id) {
        if (educacionService.buscarEducacion(id) == null) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(educacionService.buscarEducacion(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void borrarEducacion(@PathVariable Long id){
        educacionService.borrarEducacion(id);
    }
}
