package com.portfolio.LGA.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50, message = "no cumple la longitud")
    private String nombre;
    @Size(max = 50, message = "no cumple la longitud")
    private String apellido;
    @Size(max = 100, message = "no cumple la longitud")
    private String domicilio;
    @Size(max = 50, message = "no cumple la longitud")
    private String titulo;
    @Lob
    @Size(max = 5000, message = "no cumple la longitud")
    private String sobreMi;
    @Size(max = 100, message = "no cumple la longitud")
    private  String url;
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String domicilio, String titulo, String sobreMi, String url, Date fechaCreacion) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.titulo = titulo;
        this.sobreMi = sobreMi;
        this.url = url;
        this.fechaCreacion = fechaCreacion;
    }
}
