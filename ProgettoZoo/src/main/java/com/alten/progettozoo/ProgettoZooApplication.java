package com.alten.progettozoo;

import com.alten.progettozoo.Util.Printer;

public class ProgettoZooApplication {

    // L'obbiettivo di questa lavorazione era ottimizzare il codice inviato l'ultima volta utilizzando gli stream e velocizzare l'accesso alle liste contenenti solo
    // animali della stessa specie
    public static void main(String[] args) {
        Zoo myZoo = new Zoo();
        myZoo.initializeZoo();

        Printer myPrinter = new Printer();

        System.out.println("ANIMALI PIU' ALTI");
        myPrinter.printAnimalsInformation(myZoo.findTallestAnimalsBySpecies(Eagle.class));
        myPrinter.printAnimalsInformation(myZoo.findTallestAnimalsBySpecies(Tiger.class));
        myPrinter.printAnimalsInformation(myZoo.findTallestAnimalsBySpecies(Lion.class));

//        System.out.println("ANIMALI PIU' BASSI");
//        myPrinter.printAnimalsInformation(myZoo.findShortestAnimalsBySpecies(Eagle.class));
//        myPrinter.printAnimalsInformation(myZoo.findShortestAnimalsBySpecies(Tiger.class));
//        myPrinter.printAnimalsInformation(myZoo.findShortestAnimalsBySpecies(Lion.class));

        System.out.println("ANIMALI PIU' PESANTI");
        myPrinter.printAnimalsInformation(myZoo.findHeaviestAnimalsBySpecie(Eagle.class));
        myPrinter.printAnimalsInformation(myZoo.findHeaviestAnimalsBySpecie(Tiger.class));
        myPrinter.printAnimalsInformation(myZoo.findHeaviestAnimalsBySpecie(Lion.class));

        System.out.println("ANIMALI PIU' LEGGERI");
        myPrinter.printAnimalsInformation(myZoo.findLightestAnimalsBySpecie(Eagle.class));
        myPrinter.printAnimalsInformation(myZoo.findLightestAnimalsBySpecie(Tiger.class));
        myPrinter.printAnimalsInformation(myZoo.findLightestAnimalsBySpecie(Lion.class));

        System.out.println("ANIMALI CON LA CODA PIU' LUNGA");
        myPrinter.printAnimalsInformation(myZoo.findLongestTails());

        System.out.println("ANIMALI CON L'APERTURA ALARE MAGGIORE");
        myPrinter.printAnimalsInformation(myZoo.findBiggestWingspans());
    }
}
