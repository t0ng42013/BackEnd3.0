package com.portfolio.LGA.controller;

import com.portfolio.LGA.InterService.ICursoService;
import com.portfolio.LGA.dto.CursoDto;
import com.portfolio.LGA.dto.Mensaje;
import com.portfolio.LGA.model.Curso;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/curso")
@CrossOrigin(origins = {"https://lga-portfolio.web.app","http://localhost:4200"})
public class CursoController {
    @Autowired
    private ICursoService cursoService;

    @GetMapping("/lista")
    public ResponseEntity<List<Curso>> verCurso() {
        List<Curso> cursos = cursoService.verCurso();
        return new ResponseEntity(cursos, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody CursoDto cursoDto) {
        if (StringUtils.isBlank(cursoDto.getInstituto())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Curso curso = new Curso(
                cursoDto.getInstituto(),
                (Date) cursoDto.getInicio(),
                (Date) cursoDto.getFin(),
                cursoDto.getTitulo());
        cursoService.crearCurso(curso);
        return new ResponseEntity(new Mensaje("Curso creado"), HttpStatus.CREATED);
    }

    @PutMapping("/editar")
    public ResponseEntity<?> editarCurso(@RequestBody Curso curso) {
        cursoService.editarCurso(curso);
        return new ResponseEntity(new Mensaje("Curso editado"), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Curso> buscarCurso(@PathVariable Long id) {
        if (cursoService.buscarCurso(id) == null) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(cursoService.buscarCurso(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void borrarCurso(@PathVariable Long id){
        cursoService.borrarCurso(id);
    }
}
