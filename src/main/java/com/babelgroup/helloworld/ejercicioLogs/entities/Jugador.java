package com.babelgroup.helloworld.ejercicioLogs.entities;

import java.util.List;

public class Jugador implements IJugador {

    String name;
    List<IApuesta> apuestas;

    public Jugador(String name, List<IApuesta> apuestas) {
        this.name = name;
        this.apuestas = apuestas;
    }

    @Override
    public void addApuesta(IApuesta apuestas) {
        this.apuestas.add(apuestas);
    }

    public String getNombre() {
        return this.name;
    }

    public List<IApuesta> getApuestas() {
        return apuestas;
    }
}
