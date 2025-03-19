package com.babelgroup.helloworld.ejercicioLogs.services;

import com.babelgroup.helloworld.ejercicioLogs.entities.IApuesta;
import com.babelgroup.helloworld.ejercicioLogs.entities.IJugador;

import java.util.List;

public interface SorteoService {
    List<IJugador> makeSorteo();

    IApuesta getApuestaGanadora();

    List<IJugador> getAllGanadores(IApuesta apuestaGanadora);
}
