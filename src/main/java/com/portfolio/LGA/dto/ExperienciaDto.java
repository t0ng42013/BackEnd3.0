package com.portfolio.LGA.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExperienciaDto implements Serializable {
    @NotBlank
    private String nombre;
    private boolean trabajo;
    private Date inicio;
    private Date fin;
    private String tarea1;
    private String tarea2;
    private String tarea3;
    private String tarea4;
}
