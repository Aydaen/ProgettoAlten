package com.alten.progettozoo;

import org.springframework.boot.SpringApplication;

// Sostituire i cicli con degli stream
//
public class ProgettoZooApplication {

    public static void main(String[] args) {
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
