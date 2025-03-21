package com.babelgroup.helloworld.ejercicioLogs.services;

import com.babelgroup.helloworld.ejercicioLogs.entities.Apuesta;
import com.babelgroup.helloworld.ejercicioLogs.iomanagers.IOManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ApuestasServiceImpl implements ApuestasService {

    private IOManager ioManager;
    private static final Logger logger = LoggerFactory.getLogger(ApuestasServiceImpl.class);

    public ApuestasServiceImpl(IOManager ioManager) {
        this.ioManager = ioManager;
    }

    public Apuesta makeApuesta() {
        List<Integer> apuestas = new ArrayList<>();
        int numero;

        this.ioManager.write("Introduce una nueva apuesta: ");
        for (int i = 0; i < 6; i++) {
            this.ioManager.write("Valor " + (i + 1) + ": ");
            numero = Integer.parseInt(this.ioManager.read());

            while (this.numRepetido(numero, apuestas)) {
                this.ioManager.write("Número repetido. Introduce un número diferente: ");
                numero = Integer.parseInt(this.ioManager.read());
            }

            apuestas.add(numero);
        }

        this.logger.info("Nueva apuesta introducida manualmente");
        return new Apuesta(apuestas);
    }

    public Apuesta makeApuestaAleatoria() {
        List<Integer> apuestas = new ArrayList<>();
        Random random = new Random();
        int numero;

        for (int i = 0; i < 6; i++) {
            numero = random.nextInt(1, 49);

            while (this.numRepetido(numero, apuestas)) {
                numero = random.nextInt(1, 49);
            }

            apuestas.add(numero);
        }

        this.logger.info("Nueva apuesta generada aleatoriamente");
        return new Apuesta(apuestas);
    }

    private boolean numRepetido(int numero, List<Integer> apuestas) {
        return apuestas.contains(numero);
    }

}
