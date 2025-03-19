package com.babelgroup.helloworld.ejercicioLogs.services;

import com.babelgroup.helloworld.ejercicioLogs.entities.IApuesta;
import com.babelgroup.helloworld.ejercicioLogs.entities.IJugador;

public interface JugadorService {
    public void crearJugador();

    public void añadirApuesta(IJugador jugador, IApuesta apuesta);

    public void mostrarApuestas();

    //public List<Jugador> getAllJugadores();

    public IJugador seleccionarJugador(String nombre);
}
