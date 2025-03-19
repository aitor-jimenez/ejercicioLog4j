package com.babelgroup.helloworld.ejercicioLogs.entities;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Apuesta {

    private List<Integer> apuestas;

    public Apuesta(List<Integer> apuestas) {
        this.apuestas = apuestas;
    }

    public List<Integer> getApuestas() {
        return this.apuestas;
    }

}
