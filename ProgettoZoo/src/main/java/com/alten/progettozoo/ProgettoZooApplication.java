package com.alten.progettozoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ProgettoZooApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProgettoZooApplication.class, args);

        Zoo altenZoo = new Zoo();
        altenZoo.initializeZoo();

        // Effettuo le interrogazioni richieste dall'esercizio tramite i metodi creati in seguito
        altenZoo.findTallestAnimalAmongASpecie(altenZoo.getEagles());
        altenZoo.findTallestAnimalAmongASpecie(altenZoo.getTigers());
        altenZoo.findTallestAnimalAmongASpecie(altenZoo.getLions());

        altenZoo.findShortestAnimalAmongASpecie(altenZoo.getEagles());
        altenZoo.findShortestAnimalAmongASpecie(altenZoo.getTigers());
        altenZoo.findShortestAnimalAmongASpecie(altenZoo.getLions());

        altenZoo.findHeaviestAnimalAmongASpecie(altenZoo.getEagles());
        altenZoo.findHeaviestAnimalAmongASpecie(altenZoo.getTigers());
        altenZoo.findHeaviestAnimalAmongASpecie(altenZoo.getLions());

        altenZoo.findLightestAnimalAmongASpecie(altenZoo.getEagles());
        altenZoo.findLightestAnimalAmongASpecie(altenZoo.getTigers());
        altenZoo.findLightestAnimalAmongASpecie(altenZoo.getLions());

        altenZoo.findLongestTailAmongTailedAnimals(altenZoo.getAllAnimals());

        altenZoo.findBiggestWingspanAmongWingedAnimals(altenZoo.getAllAnimals());
    }
}
