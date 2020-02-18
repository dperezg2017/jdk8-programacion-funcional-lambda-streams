package com.lab.service;

import org.springframework.stereotype.Service;

@Service
public class LambdaServiceImpl implements LambdaService {

    @Override
    public int valor() {
        return 20;
    }

    @Override
    public int valor(int p1, int p2) {
        return p1+p2;
    }

    @Override
    public void inicializa(String[] array, String valor) {
        for (int i = 0; i < array.length; i++) {
            array[i] = valor;
        }
    }
}
