package com.example.IT.support.App.Exceptions;

public class TechnicienNotFoundException extends RuntimeException {

    public TechnicienNotFoundException() {
        super("Technicien not found!");
    }
}
