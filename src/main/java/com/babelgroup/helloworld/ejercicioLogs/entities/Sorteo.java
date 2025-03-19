package com.babelgroup.helloworld.ejercicioLogs.entities;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Sorteo implements ISorteo {

    List<IJugador> sorteo;

    public Sorteo(List<IJugador> sorteo) {
        this.sorteo = sorteo;
    }

    public void addJugador(IJugador jugador) {
        sorteo.add(jugador);
    }

    public List<IJugador> getJugadores() {
        return sorteo;
    }
}
