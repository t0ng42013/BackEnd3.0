package com.portfolio.LGA.dto;

public class PersonaNotFoundException extends RuntimeException{
    public PersonaNotFoundException(Long id) {
        super("User with ID " + id + " not found.");
    }
}
