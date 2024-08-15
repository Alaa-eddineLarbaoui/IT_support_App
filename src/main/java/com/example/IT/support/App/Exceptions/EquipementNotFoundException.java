package com.example.IT.support.App.Exceptions;

public class EquipementNotFoundException extends RuntimeException{

    public EquipementNotFoundException(){
        super(("Equipement not found !"));
    }
}