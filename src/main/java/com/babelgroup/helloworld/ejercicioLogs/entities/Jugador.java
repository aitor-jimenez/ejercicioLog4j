package com.babelgroup.helloworld.ejercicioLogs.entities;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Jugador {

    String name;
    List<Apuesta> apuestas;

    public Jugador(String name, List<Apuesta> apuestas) {
        this.name = name;
        this.apuestas = apuestas;
    }

    public void addApuesta(Apuesta apuestas) {
        this.apuestas.add(apuestas);
    }

    public String getNombre() {
        return this.name;
    }

    public List<Apuesta> getApuestas() {
        return apuestas;
    }
}
