package com.portfolio.LGA.controller;

import com.portfolio.LGA.InterService.IEducacionService;
import com.portfolio.LGA.dto.EducacionDto;
import com.portfolio.LGA.dto.Mensaje;
import com.portfolio.LGA.dto.PersonaDto;
import com.portfolio.LGA.model.Educacion;
import com.portfolio.LGA.model.Persona;
import com.portfolio.LGA.repository.EducacionRepository;
import com.portfolio.LGA.service.EducacionService;
import io.micrometer.common.util.StringUtils;
import org.modelmapper.ModelMapper;
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
    @Autowired
    private EducacionRepository educacionRepository;

    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> verEducacion() {
        List<Educacion> educacion = educacionService.verEducacion();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<EducacionDto> crear(@RequestBody EducacionDto educacionDto) {
        if (StringUtils.isBlank(educacionDto.getInstituto())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = new ModelMapper().map(educacionDto, Educacion.class);
        educacionRepository.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion creada"), HttpStatus.CREATED);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarEducacion(@PathVariable Long id,@RequestBody EducacionDto educacionDto) {
        Educacion educacion = new ModelMapper().map(educacionDto, Educacion.class);
        educacionService.editarEducacion(id,educacionDto);
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
    public ResponseEntity<Void> borrarEducacion(@PathVariable Long id){
        educacionService.borrarEducacion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
