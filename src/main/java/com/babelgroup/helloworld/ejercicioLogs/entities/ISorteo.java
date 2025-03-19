package com.babelgroup.helloworld.ejercicioLogs.entities;

import java.util.List;

public interface ISorteo {

    public List<IJugador> makeSorteo();

    public void addJugador(IJugador jugador);

    public void addApuesta(IJugador jugador, IApuesta apuesta);

}
