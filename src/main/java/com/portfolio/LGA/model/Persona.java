package com.portfolio.LGA.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

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

    public Persona() {
    }

    public Persona(String nombre, String apellido, String descripcion, String titulo,String sobreMi, String url) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = descripcion;
        this.titulo = titulo;
        this.sobreMi = sobreMi;
        this.url = url;
    }
}
