package com.babelgroup.helloworld.ejercicioLogs.iomanagers;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ConsoleIOManager implements IOManager {

    public void write(String msg) {
        System.out.println(msg);
    }

    public String read() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
