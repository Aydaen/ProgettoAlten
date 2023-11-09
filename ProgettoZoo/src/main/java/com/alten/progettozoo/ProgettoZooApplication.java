package com.alten.progettozoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Il main risulta ora costituito solo dall'istanziazione di uno Zoo e dal richiamo dei metodi necessari alle interrogazioni richieste dalla traccia
@SpringBootApplication
public class ProgettoZooApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProgettoZooApplication.class, args);

        Zoo myZoo = new Zoo();
        myZoo.initializeZoo();

        // Effettuo le interrogazioni richieste dall'esercizio tramite i metodi creati in seguito
        myZoo.findTallestAnimalAmongASpecie(myZoo.getEagles());
        myZoo.findTallestAnimalAmongASpecie(myZoo.getTigers());
        myZoo.findTallestAnimalAmongASpecie(myZoo.getLions());

        myZoo.findShortestAnimalAmongASpecie(myZoo.getEagles());
        myZoo.findShortestAnimalAmongASpecie(myZoo.getTigers());
        myZoo.findShortestAnimalAmongASpecie(myZoo.getLions());

        myZoo.findHeaviestAnimalAmongASpecie(myZoo.getEagles());
        myZoo.findHeaviestAnimalAmongASpecie(myZoo.getTigers());
        myZoo.findHeaviestAnimalAmongASpecie(myZoo.getLions());

        myZoo.findLightestAnimalAmongASpecie(myZoo.getEagles());
        myZoo.findLightestAnimalAmongASpecie(myZoo.getTigers());
        myZoo.findLightestAnimalAmongASpecie(myZoo.getLions());

        myZoo.findLongestTailAmongTailedAnimals(myZoo.getAllAnimals());

        myZoo.findBiggestWingspanAmongWingedAnimals(myZoo.getAllAnimals());
    }
}
