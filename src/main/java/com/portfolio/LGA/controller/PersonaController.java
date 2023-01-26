package com.portfolio.LGA.controller;

import com.portfolio.LGA.InterService.IPersonaService;
import com.portfolio.LGA.dto.Mensaje;
import com.portfolio.LGA.model.Persona;
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
    public ResponseEntity<List<Persona>> verPersonas() {
        List<Persona> personas = personaService.verPersonas();
        return new ResponseEntity(personas, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public void agregarPersona(@RequestBody Persona perso){
        personaService.crearPersona(perso);
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
