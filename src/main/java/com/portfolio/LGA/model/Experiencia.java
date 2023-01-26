package com.portfolio.LGA.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(max = 50, message = "no cumple la longitud")
    private String nombre;
    @Size(max = 50, message = "no cumple la longitud")
    private boolean trabajo;
    @Temporal(TemporalType.DATE)
    private Date inicio;
    @Temporal(TemporalType.DATE)
    private Date fin;
    @Lob
    @Size(max = 5000, message = "no cumple la longitud")
    private String tarea1;
    @Lob
    @Size(max = 5000, message = "no cumple la longitud")
    private String tarea2;
    @Lob
    @Size(max = 5000, message = "no cumple la longitud")
    private String tarea3;
    @Lob
    @Size(max = 5000, message = "no cumple la longitud")
    private String tarea4;

    public Experiencia(String nombre, boolean trabajo, Date inicio, Date fin, String tarea1, String tarea2, String tarea3, String tarea4) {
        this.nombre = nombre;
        this.trabajo = trabajo;
        this.inicio = inicio;
        this.fin = fin;
        this.tarea1 = tarea1;
        this.tarea2 = tarea2;
        this.tarea3 = tarea3;
        this.tarea4 = tarea4;
    }

    public Experiencia() {
    }
}
