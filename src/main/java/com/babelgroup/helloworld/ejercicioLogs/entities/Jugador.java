package com.babelgroup.helloworld.ejercicioLogs.entities;

import org.springframework.stereotype.Component;

@Component
public class Jugador {

    String name;

    public Jugador(String name) {
        this.name = name;
    }
}
