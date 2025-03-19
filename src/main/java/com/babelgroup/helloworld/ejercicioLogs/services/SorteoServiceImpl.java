package com.babelgroup.helloworld.ejercicioLogs.services;

import com.babelgroup.helloworld.ejercicioLogs.entities.IApuesta;
import com.babelgroup.helloworld.ejercicioLogs.entities.IJugador;
import com.babelgroup.helloworld.ejercicioLogs.entities.ISorteo;
import com.babelgroup.helloworld.ejercicioLogs.iomanagers.IOManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class SorteoServiceImpl implements SorteoService {

    IOManager ioManager;
    Random rnd;
    ISorteo sorteo;

    public SorteoServiceImpl(ISorteo sorteo, IOManager ioManager) {
        this.sorteo = sorteo;
        this.ioManager = ioManager;
        rnd = new Random();
    }

    public List<IJugador> makeSorteo() {
        IApuesta apuestaGanadora = getApuestaGanadora();

        return getAllGanadores(apuestaGanadora);
    }

    public IApuesta getApuestaGanadora() {
        int rnd1 = rnd.nextInt(sorteo.getJugadores().size());
        IJugador firstRandParam = sorteo.getJugadores().get(rnd1);
        int rnd2 = rnd.nextInt(firstRandParam.getApuestas().size());

        IApuesta ganadora = firstRandParam.getApuestas().get(rnd2);

        ioManager.write("El número ganador es: " + ganadora);

        return ganadora;
    }

    public List<IJugador> getAllGanadores(IApuesta apuestaGanadora) {
        List<IJugador> ganadores = new ArrayList<>();
        for (IJugador jugador : sorteo.getJugadores()) {
            for (IApuesta apuestas : jugador.getApuestas()) {
                if (apuestas.equals(apuestaGanadora)) {
                    ganadores.add(jugador);
                }
            }
        }

        ioManager.write("Los ganadores son: " + ganadores);

        return ganadores;
    }
}
