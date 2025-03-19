package com.babelgroup.helloworld.ejercicioLogs.services;

import com.babelgroup.helloworld.ejercicioLogs.entities.IApuesta;
import com.babelgroup.helloworld.ejercicioLogs.entities.IJugador;
import com.babelgroup.helloworld.ejercicioLogs.entities.Jugador;
import com.babelgroup.helloworld.ejercicioLogs.entities.Sorteo;
import com.babelgroup.helloworld.ejercicioLogs.iomanagers.IOManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JugadorServiceImpl implements JugadorService {

    private IOManager ioManager;
    private Sorteo sorteo;
    private static final Logger logger = LoggerFactory.getLogger(ApuestasServiceImpl.class);

    public JugadorServiceImpl(IOManager ioManager, Sorteo sorteo) {
        this.ioManager = ioManager;
        this.sorteo = sorteo;
    }

    public void crearJugador() {
        this.ioManager.write("Introduce el nombre del jugador: ");
        String nombre = this.ioManager.read();
        this.logger.info("Nuevo jugador creado: " + nombre);
        sorteo.addJugador(new Jugador(nombre, new ArrayList<>()));
    }

    public void añadirApuesta(IJugador jugador, IApuesta apuesta) {
        if (this.apuestaRepetida(jugador, apuesta)) {
            this.logger.warn("Apuesta repetida. No se ha añadido al jugador " + jugador.getNombre());
        } else {
            jugador.addApuesta(apuesta);
            this.logger.info("Nueva apuesta añadida al jugador " + jugador.getNombre());
        }
    }

    private boolean apuestaRepetida(IJugador jugador, IApuesta apuesta) {
        return jugador.getApuestas().contains(apuesta);
    }

    public void mostrarApuestas() {
        for (IJugador jugador : sorteo.getJugadores()) {
            this.ioManager.write("Apuesta de " + jugador.getNombre() + ": ");
            for (IApuesta apuesta : jugador.getApuestas()) {
                this.ioManager.write(apuesta.getApuestas().toString());
            }
            this.logger.info("Apuestas del jugador " + jugador.getNombre() + " mostradas");
        }
    }

    /*public List<IJugador> getAllJugadores() {
        return this.sorteo.getJugadores();
    }*/

    public IJugador seleccionarJugador(String nombre) {
        for (IJugador jugador : sorteo.getJugadores()) {
            if (jugador.getNombre().equals(nombre)) {
                this.logger.info("Jugador " + jugador.getNombre() + " seleccionado");
                return jugador;
            }
        }
        this.logger.warn("Jugador " + nombre + " no encontrado");
        return null;
    }

}
