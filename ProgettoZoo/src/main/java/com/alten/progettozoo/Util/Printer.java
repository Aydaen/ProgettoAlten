package com.alten.progettozoo.Util;

import com.alten.progettozoo.Animal;

import java.util.List;

public class Printer {
    public void printAnimalsInformation (List<? extends Animal> animals) {
        if (animals == null) {
            System.out.println("Nessun animale presente nella specie indicata");
            return;
        }

        animals
                .forEach(animal -> {
                    System.out.println(animal.getName());
                });

        System.out.println("----------");
    }
}
