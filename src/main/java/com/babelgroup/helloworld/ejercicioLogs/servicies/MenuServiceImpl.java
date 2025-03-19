package com.babelgroup.helloworld.ejercicioLogs.servicies;

import com.babelgroup.helloworld.ejercicioLogs.iomanagers.IOManager;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {

    private static final Logger logger = LoggerFactory.getLogger(LoteriaPrimitivaApplication.class);

    private IOManager ioManager;
    private final JugadorService jugadorService;
    private final ApuestaService apuestaService;
    private final SorteoService sorteoService;

    public MenuServiceImpl(IOManager ioManager, JugadorService jugadorService, ApuestaService apuestaService, SorteoService sorteoService) {
        this.ioManager = ioManager;
        this.jugadorService = jugadorService;
        this.apuestaService = apuestaService;
        this.sorteoService = sorteoService;
    }

    @Override
    public void runMenu() {
        logger.info("Iniciando el menú de la Lotería Primitiva");
        boolean salir = false;
        while (!salir) {
            buildMenu();
            String opcion = ioManager.read();
            logger.info("El usuario ha seleccionado la opción: {}", opcion);
            salir = manejarOpcion(opcion);
        }
    }

    private void buildMenu() {
        ioManager.write("\n--- Lotería Primitiva ---");
        ioManager.write("1. Añadir jugador");
        ioManager.write("2. Añadir apuesta");
        ioManager.write("3. Ver apuestas");
        ioManager.write("4. Realizar sorteo");
        ioManager.write("5. Salir");
    }

    private boolean manejarOpcion(String opcion) {
        switch (opcion) {
            case 1 -> {
                logger.info("Ejecutando opción: Añadir jugador");
                jugadorService.añadirJugador();
            }
            case 2 -> {
                logger.info("Ejecutando opción: Añadir apuesta");
                apuestaService.añadirApuesta();
            }
            case 3 -> {
                logger.info("Ejecutando opción: Mostrar apuestas");
                apuestaService.mostrarApuestas();
            }
            case 4 -> {
                logger.info("Ejecutando opción: Realizar sorteo");
                sorteoService.realizarSorteo();
            }
            case 5 -> {
                logger.info("El usuario ha decidido salir del programa.");
                ioManager.write("Saliendo...");
                return true;
            }
            default -> {
                logger.warn("Opción inválida ingresada: {}", opcion);
                ioManager.write("Opción no válida. Inténtalo de nuevo.");
            }
        }
        logger.info("Menú finalizado.");
        return false;
    }
}
