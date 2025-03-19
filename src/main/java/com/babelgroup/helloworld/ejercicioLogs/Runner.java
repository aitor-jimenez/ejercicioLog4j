package com.babelgroup.helloworld.ejercicioLogs;

import com.babelgroup.helloworld.ejercicioLogs.services.MenuService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class Runner implements CommandLineRunner {

    private final MenuService menu;

    public Runner(MenuService menu) {
        this.menu = menu;
    }

    @Override
    public void run(String... args) throws Exception {
        menu.runMenu();
    }
}
