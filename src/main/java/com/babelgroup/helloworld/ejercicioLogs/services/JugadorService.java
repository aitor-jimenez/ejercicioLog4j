package com.babelgroup.helloworld.ejercicioLogs.services;

import com.babelgroup.helloworld.ejercicioLogs.entities.Apuesta;
import com.babelgroup.helloworld.ejercicioLogs.entities.Jugador;

import java.util.List;

public interface JugadorService {
    public Jugador crearJugador();

    public void añadirApuesta(Jugador jugador, Apuesta apuesta);

    public void mostrarApuestas();

    public List<Jugador> getAllJugadores();

    public Jugador seleccionarJugador(String nombre);
}
