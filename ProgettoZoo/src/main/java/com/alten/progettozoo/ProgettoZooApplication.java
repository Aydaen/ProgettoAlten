package com.alten.progettozoo;

public class ProgettoZooApplication {

    // L'obbiettivo di questa lavorazione era ottimizzare il codice inviato l'ultima volta utilizzando gli stream e velocizzare l'accesso alle liste contenenti solo
    // animali della stessa specie
    public static void main(String[] args) {
        Zoo myZoo = new Zoo();
        myZoo.initializeZoo();

        myZoo.findTallestAnimalAmongASpecie(Eagle.class);
        myZoo.findTallestAnimalAmongASpecie(Tiger.class);
        myZoo.findTallestAnimalAmongASpecie(Lion.class);

        myZoo.findShortestAnimalAmongASpecie(Eagle.class);
        myZoo.findShortestAnimalAmongASpecie(Tiger.class);
        myZoo.findShortestAnimalAmongASpecie(Lion.class);

        myZoo.findHeaviestAnimalAmongASpecie(Eagle.class);
        myZoo.findHeaviestAnimalAmongASpecie(Tiger.class);
        myZoo.findHeaviestAnimalAmongASpecie(Lion.class);

        myZoo.findLightestAnimalAmongASpecie(Eagle.class);
        myZoo.findLightestAnimalAmongASpecie(Tiger.class);
        myZoo.findLightestAnimalAmongASpecie(Lion.class);

        myZoo.findLongestTailAmongTailedAnimals();

        myZoo.findBiggestWingspanAmongWingedAnimals();
    }
}
