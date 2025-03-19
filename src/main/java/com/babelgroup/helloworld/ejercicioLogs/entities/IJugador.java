package com.babelgroup.helloworld.ejercicioLogs.entities;

import java.util.List;

public interface IJugador {

    public void addApuesta(IApuesta apuestas);

    public String getNombre();

    public List<IApuesta> getApuestas();

}
