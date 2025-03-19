package com.babelgroup.helloworld.ejercicioLogs.entities;

import java.util.List;

public class Apuesta implements IApuesta {

    private List<Integer> apuestas;

    public Apuesta(List<Integer> apuestas) {
        this.apuestas = apuestas;
    }

    public List<Integer> getApuestas() {
        return this.apuestas;
    }

}
