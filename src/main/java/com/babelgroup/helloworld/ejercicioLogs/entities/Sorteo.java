package com.babelgroup.helloworld.ejercicioLogs.entities;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class Sorteo implements ISorteo {

    Map<IJugador, List<IApuesta>> sorteo;

    public Sorteo(Map<IJugador, List<IApuesta>> sorteo) {
        this.sorteo = sorteo;
    }

    public List<IJugador> makeSorteo() {
        List<IJugador> winners = new ArrayList<>();
        List<Integer> winnerNumbers = genWinnerNumbers(6);
        for (IJugador jugador : sorteo.keySet()) {
            List<IApuesta> apuestasJugador = sorteo.get(jugador);
            if (apuestasJugador.equals(winnerNumbers)) {
                winners.add(jugador);
            }
        }
        return winners;
    }

    public void addJugador(IJugador jugador) {
        sorteo.put(jugador, null);
    }

    public void addApuesta(IJugador jugador, IApuesta apuesta) {
        List<IApuesta> apuestas = sorteo.get(jugador);
        if (apuestas == null) {
            apuestas = new ArrayList<>();
        }
        apuestas.add(apuesta);
        sorteo.put(jugador, apuestas);
    }

    private List<Integer> genWinnerNumbers(int size) {
        List<Integer> winnerNumbers = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            winnerNumbers.add((int) (Math.random() * 49));
        }
        return winnerNumbers;
    }
}
