package com.babelgroup.helloworld.ejercicioLogs.services;

import com.babelgroup.helloworld.ejercicioLogs.entities.Apuesta;
import com.babelgroup.helloworld.ejercicioLogs.entities.Jugador;
import com.babelgroup.helloworld.ejercicioLogs.entities.Sorteo;
import com.babelgroup.helloworld.ejercicioLogs.iomanagers.IOManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class JugadorServiceImpl implements JugadorService {

    private IOManager ioManager;
    private Sorteo sorteo;
    private static final Logger logger = LoggerFactory.getLogger(ApuestasServiceImpl.class);

    public JugadorServiceImpl(Sorteo sorteo) {
        this.ioManager = ioManager;
        this.sorteo = sorteo;
    }

    public Jugador crearJugador() {
        this.ioManager.write("Introduce el nombre del jugador: ");
        String nombre = this.ioManager.read();
        this.logger.info("Nuevo jugador creado: " + nombre);
        return new Jugador(nombre);
    }

    public void añadirApuesta(Jugador jugador, Apuesta apuesta) {
        if (this.apuestaRepetida(jugador, apuesta)) {
            this.logger.warn("Apuesta repetida. No se ha añadido al jugador " + jugador.getNombre());
        } else {
            jugador.addApuesta(apuesta);
            this.logger.info("Nueva apuesta añadida al jugador " + jugador.getNombre());
        }
    }

    private boolean apuestaRepetida(Jugador jugador, Apuesta apuesta) {
        return jugador.getApuestas().contains(apuesta);
    }

    public void mostrarApuestas() {
        for (Jugador jugador : this.getAllJugadores()) {
            this.ioManager.write("Apuesta de " + jugador.getNombre() + ": ");
            for (Apuesta apuesta : jugador.getApuestas()) {
                this.ioManager.write(apuesta.getApuestas().toString());
            }
            this.logger.info("Apuestas del jugador " + jugador.getNombre() + " mostradas");
        }
    }

    public List<Jugador> getAllJugadores() {
        return this.sorteo.getJugadores();
    }

    public Jugador selectJugador(String nombre) {
        for (Jugador jugador : this.getAllJugadores()) {
            if (jugador.getNombre().equals(nombre)) {
                this.logger.info("Jugador " + jugador.getNombre() + " seleccionado");
                return jugador;
            }
        }
        this.logger.warn("Jugador " + nombre + " no encontrado");
        return null;
    }

}
