package com.lab.service;

import com.lab.Entity.Persona;

public class LambdaMethodImpl implements LambdaMethodService{
    @Override
    public String saluda(Persona persona) {
        return "Hola" + persona.getNombre();
    }
}
