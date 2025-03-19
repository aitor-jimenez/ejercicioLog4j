package com.babelgroup.helloworld.ejercicioLogs.services;

import com.babelgroup.helloworld.ejercicioLogs.entities.Apuesta;
import com.babelgroup.helloworld.ejercicioLogs.entities.Jugador;
import com.babelgroup.helloworld.ejercicioLogs.iomanagers.IOManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    private static final Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);

    private final IOManager ioManager;
    private final JugadorService jugadorService;
    private final ApuestasService apuestaService;
    private final SorteoService sorteoService;

    public MenuServiceImpl(IOManager ioManager,
                           JugadorService jugadorService,
                           ApuestasService apuestaService, SorteoService sorteoService) {
        this.ioManager = ioManager;
        this.jugadorService = jugadorService;
        this.apuestaService = apuestaService;
        this.sorteoService = sorteoService;
    }

    @Override
    public void runMenu() {
        logger.info("Iniciando el menú de la Lotería Primitiva...");
        boolean salir = false;

        while (!salir) {
            buildMenu();
            String opcion = ioManager.read();
            logger.info("El usuario ha seleccionado la opción: {}", opcion);

            switch (opcion) {
                case "1" -> {
                    logger.info("Ejecutando opción: Añadir (o crear) jugador");
                    jugadorService.crearJugador();
                }
                case "2" -> {
                    logger.info("Ejecutando opción: Añadir apuesta a un jugador");
                    añadirApuestaAJugador();
                }
                case "3" -> {
                    logger.info("Ejecutando opción: Mostrar apuestas de todos los jugadores");
                    jugadorService.mostrarApuestas();
                }
                case "4" -> {
                    logger.info("Ejecutando opción: Realizar sorteo");
                }
                case "5" -> {
                    logger.info("El usuario ha decidido salir del programa.");
                    ioManager.write("Saliendo...");
                    salir = true;
                }
                default -> {
                    logger.warn("Opción inválida ingresada en el menú principal: {}", opcion);
                    ioManager.write("Opción no válida. Inténtalo de nuevo.");
                }
            }
        }
        logger.info("Finalizando el menú de la Lotería Primitiva.");
    }

    private void buildMenu() {
        ioManager.write("\n--- Lotería Primitiva ---");
        ioManager.write("1. Añadir jugador");
        ioManager.write("2. Añadir apuesta");
        ioManager.write("3. Ver apuestas");
        ioManager.write("4. Realizar sorteo");
        ioManager.write("5. Salir");
        ioManager.write("Elige una opción:");
    }

    private void añadirApuestaAJugador() {
        List<Jugador> jugadores = jugadorService.getAllJugadores();
        if (jugadores.isEmpty()) {
            ioManager.write("No hay jugadores disponibles. Crea uno primero.");
            return;
        }

        mostrarJugadores(jugadores);

        Jugador jugadorSeleccionado = jugadorService.seleccionarJugador();
        if (jugadorSeleccionado == null) {
            ioManager.write("Jugador no seleccionado o no válido.");
            return;
        }

        Apuesta nuevaApuesta = selectApuesta();
        if (nuevaApuesta == null) {
            ioManager.write("No se pudo crear la apuesta.");
            return;
        }

        boolean added = jugadorService.addApuestaToJugador(jugadorSeleccionado, nuevaApuesta);
        if (added) {
            ioManager.write("Apuesta añadida correctamente al jugador " + jugadorSeleccionado.getNombre());
        } else {
            ioManager.write("Esta apuesta ya existía para el jugador o no se pudo añadir.");
        }
    }

    private void mostrarJugadores(List<Jugador> jugadores) {
        ioManager.write("Jugadores disponibles:");
        for (int i = 0; i < jugadores.size(); i++) {
            ioManager.write((i + 1) + ") " + jugadores.get(i).getNombre());
        }
    }

    private Apuesta selectApuesta() {
        ioManager.write("Selecciona el tipo de apuesta:");
        ioManager.write("   a) Manual");
        ioManager.write("   b) Aleatoria");
        String tipoApuesta = ioManager.read();

        switch (tipoApuesta) {
            case "a" -> {
                logger.info("El usuario ha seleccionado la opción: Apuesta manual");
                return apuestaService.makeApuesta();
                // Este método pedirá por consola 6 números y creará el objeto Apuesta
            }
            case "b" -> {
                logger.info("El usuario ha seleccionado la opción: Apuesta aleatoria");
                return apuestaService.makeApuestaAleatoria();
            }
            default -> {
                logger.warn("Opción inválida al seleccionar tipo de apuesta: {}", tipoApuesta);
                ioManager.write("Opción no válida. Inténtalo de nuevo.");
                return null;
            }
        }
    }
}
