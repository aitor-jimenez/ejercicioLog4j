package com.babelgroup.helloworld.ejercicioLogs.entities;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class Sorteo implements ISorteo {

    List<IJugador> sorteo;
    Random rnd;

    public Sorteo(List<IJugador> sorteo) {
        this.sorteo = sorteo;
        rnd = new Random();
    }

    public List<IJugador> makeSorteo() {
        IApuesta apuestaGanadora = getApuestaGanadora();

        return getAllGanadores(apuestaGanadora);
    }

    public void addJugador(IJugador jugador) {
        sorteo.add(jugador);
    }

    private IApuesta getApuestaGanadora() {
        IApuesta winnerNumbers;
        int rnd1 = rnd.nextInt(sorteo.size());
        IJugador firstRandParam = sorteo.get(rnd1);
        int rnd2 = rnd.nextInt(firstRandParam.getApuestas().size());

        return firstRandParam.getApuestas().get(rnd2);
    }

    private List<IJugador> getAllGanadores(IApuesta apuestaGanadora) {
        List<IJugador> ganadores = new ArrayList<>();
        for (IJugador jugador : sorteo) {
            for (IApuesta apuestas : jugador.getApuestas()) {
                if (apuestas.equals(apuestaGanadora)) {
                    ganadores.add(jugador);
                }
            }
        }

        return ganadores;
    }
}
