package com.portfolio.LGA.controller;

import com.portfolio.LGA.InterService.IPersonaService;
import com.portfolio.LGA.dto.Mensaje;
import com.portfolio.LGA.dto.PersonaDto;
import com.portfolio.LGA.model.Persona;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persona")
@CrossOrigin(origins = {"https://lga-portfolio.web.app","http://localhost:4200"})
public class PersonaController {
    @Autowired
    private IPersonaService personaService;

    @GetMapping("/lista")
    @ResponseBody
    public ResponseEntity<List<Persona>> verPersonas() {
        List<Persona> personas = personaService.verPersonas();
        return new ResponseEntity(personas, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody PersonaDto personaDto) {
        if (StringUtils.isBlank(personaDto.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Persona persona = new Persona(
                personaDto.getNombre(),
                personaDto.getApellido(),
                personaDto.getTitulo(),
                personaDto.getSobreMi(),
                personaDto.getDomicilio(),
                personaDto.getUrl(),
        personaDto.getFechaCreacion());
        personaService.crearPersona(persona);
        return new ResponseEntity(new Mensaje("Persona creada"), HttpStatus.CREATED);
    }
    @PutMapping("/editar")
    public ResponseEntity<?> editarPersona(@RequestBody Persona persona) {
        personaService.editarPersona(persona);
        return new ResponseEntity(new Mensaje("Persona editada"), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Persona> buscarPersona(@PathVariable Long id) {
        if (personaService.buscarPersona(id) == null) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(personaService.buscarPersona(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void borrarPersona(@PathVariable Long id){
        personaService.borrarPersona(id);
    }
}
