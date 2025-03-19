package com.babelgroup.helloworld.ejercicioLogs.iomanagers;

import java.util.Scanner;

public class ConsoleIOManager implements IOManager {

    public void write(String msg) {
        System.out.println(msg);
    }

    public String read() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
