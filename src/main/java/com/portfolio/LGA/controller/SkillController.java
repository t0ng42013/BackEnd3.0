package com.portfolio.LGA.controller;

import com.portfolio.LGA.InterService.ISkillService;
import com.portfolio.LGA.dto.Mensaje;
import com.portfolio.LGA.dto.SkillDto;
import com.portfolio.LGA.model.Skill;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skill")
@CrossOrigin(origins = {"https://lga-portfolio.web.app/","http://localhost:4200"})
public class SkillController {
    @Autowired
    private ISkillService skillService;

    @GetMapping("/lista")
    public ResponseEntity<List<Skill>> verSkill() {
        List<Skill> skills = skillService.verSkill();
        return new ResponseEntity(skills, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody SkillDto skillDto) {
        if (StringUtils.isBlank(skillDto.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Skill skill = new Skill(
                skillDto.getNombre(),
                skillDto.getPorcentaje());
        skillService.crearSkill(skill);
        return new ResponseEntity(new Mensaje("Skill creado"), HttpStatus.CREATED);
    }

    @PutMapping("/editar")
    public ResponseEntity<?> editarSkill(@RequestBody Skill skill) {
        skillService.editaSkill(skill);
        return new ResponseEntity(new Mensaje("Skill editado"), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Skill> buscarSkill(@PathVariable Long id) {
        if (skillService.buscarSkill(id) == null) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(skillService.buscarSkill(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void borrarSkill(@PathVariable Long id){
        skillService.borrarSkill(id);
    }
}
