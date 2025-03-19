package com.babelgroup.helloworld.ejercicioLogs.entities;

import java.util.List;

public interface ISorteo {
    void addJugador(IJugador jugador);

    List<IJugador> getJugadores();
}
