package com.alten.progettozoo;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Zoo {

    private final Map<Class<? extends Animal>, List<Animal>> allAnimals = new HashMap<>();

    // Il seguente metodo serve ad aggiungere gli animali alle rispettive liste nella mappa. Se si cerca di aggiungere un animale di una specie inesistente, l'array della
    // suddetta specie viene creato
    public void addAnimal(Animal animal) {
        Class<? extends Animal> species = animal.getClass();
        allAnimals.computeIfAbsent(species, key -> new ArrayList<>()).add(animal);
    }

    // Grazie al metodo addAnimal ora non è più necessario creare a mano le liste in base alle specie all'interno del metodo initializeZoo
    public void initializeZoo() {
        addAnimal(new Eagle("Baldy", "Fish", 5, LocalDate.of(2020, 3, 15), 5.0, 0.5, 2.0));
        addAnimal(new Eagle("Titty", "Fish", 3, LocalDate.of(2022, 6, 10), 3.0, 0.4, 1.8));
        addAnimal(new Eagle("Olimpia", "Fish", 4, LocalDate.of(2021, 9, 5), 4.5, 0.45, 2.2));

        addAnimal(new Tiger("Tigro", "Meat", 6, LocalDate.of(2019, 7, 20), 180.0, 2.0, 1.2));
        addAnimal(new Tiger("L'uomo tigre", "Meat", 7, LocalDate.of(2018, 5, 12), 175.0, 2.0, 1.1));
        addAnimal(new Tiger("Fuffy", "Meat", 5, LocalDate.of(2020, 2, 25), 190.0, 1.3, 1.3));

        addAnimal(new Lion("Simba", "Meat", 8, LocalDate.of(2017, 11, 10), 200.0, 2.0, 1.2));
        addAnimal(new Lion("Nala", "Meat", 7, LocalDate.of(2018, 8, 18), 190.0, 0.9, 1.3));
        addAnimal(new Lion("Mufasa", "Meat", 10, LocalDate.of(2015, 12, 3), 220.0, 1.1, 0.9));
    }

    // Metodo commentato poiché inutilizzato nella nuova versione del codice
//    public String speciesNamesTranslation(Class<? extends Animal> species) {
//        Map<Class<? extends Animal>, String> speciesNames = Map.of(
//                Eagle.class, "aquila",
//                Tiger.class, "tigre",
//                Lion.class, "leone"
//        );
//
//        return speciesNames.getOrDefault(species, "Specie sconosciuta");
//    }

    public List<Animal> getAllAnimalsBySpecies(Class<? extends Animal> species) {
        return allAnimals.get(species);
    }

    public <T extends Animal> List<T> getAllAnimalsWithASpecifiedTrait(Class<T> trait) {
        return allAnimals.values().stream()
                .flatMap(Collection::stream)
                .filter(trait::isInstance)
                .map(trait::cast)
                .toList();
    }

    // Seguendo il principio di separazione comando-interazione i metodi che seguono non comprendono più la stampa della lista di animali, bensì ritornano la lista che viene
    // invece stampata dai metodi della classe Printer
    public List<Animal> findTallestAnimalsBySpecies(Class<? extends Animal> species) {
        List<Animal> filteredAnimals = getAllAnimalsBySpecies(species);

        if (filteredAnimals.isEmpty()) {
            return null;
        }

        double maxHeight = filteredAnimals.stream()
                .mapToDouble(Animal::getHeight)
                .max()
                .orElse(0.0);

        return filteredAnimals.stream()
                .filter(animal -> animal.getHeight() == maxHeight)
                .collect(Collectors.toList());
    }

    // Questo metodo differisce dagli altri a causa di dubbi da esporre a Davide il giorno della correzione, al momento risulta inutilizzato
    public <T extends Animal> List<T> findShortestAnimalsBySpecies(Class<T> species) {
        List<? extends Animal> filteredAnimals = getAllAnimalsBySpecies(species);

        if (filteredAnimals.isEmpty()) {
            return null;
        }

        double minHeight = filteredAnimals.stream()
                .mapToDouble(Animal::getHeight)
                .min()
                .orElse(0.0);

        return filteredAnimals.stream()
                .filter(animal -> animal.getHeight() == minHeight)
                .map(species::cast)
                .toList();
    }

    public List<Animal> findHeaviestAnimalsBySpecie(Class<? extends Animal> species) {
        List<Animal> filteredAnimals = getAllAnimalsBySpecies(species);

        if (filteredAnimals.isEmpty()) {
            return null;
        }

        double maxWeight = filteredAnimals.stream()
                .mapToDouble(Animal::getWeight)
                .max()
                .orElse(0.0);

        return filteredAnimals.stream()
                .filter(animal -> animal.getWeight() == maxWeight)
                .collect(Collectors.toList());
    }

    public List<Animal> findLightestAnimalsBySpecie(Class<? extends Animal> species) {
        List<Animal> filteredAnimals = getAllAnimalsBySpecies(species);

        if (filteredAnimals.isEmpty()) {
            return null;
        }

        double minWeight = filteredAnimals.stream()
                .mapToDouble(Animal::getWeight)
                .min()
                .orElse(0.0);

        return filteredAnimals.stream()
                .filter(animal -> animal.getWeight() == minWeight)
                .collect(Collectors.toList());
    }

    public List<Animal> findLongestTails() {
        List<TailedAnimal> tailedAnimals = getAllAnimalsWithASpecifiedTrait(TailedAnimal.class);

        if (tailedAnimals.isEmpty()) {
            return null;
        }

        double longestTail = tailedAnimals.stream()
                .mapToDouble(TailedAnimal::getTailLength)
                .max()
                .orElse(0.0);

        return tailedAnimals.stream()
                .filter(animal -> animal.getTailLength() == longestTail)
                .collect(Collectors.toList());
    }

    public List<Animal> findBiggestWingspans() {
        List<WingedAnimal> wingedAnimals = getAllAnimalsWithASpecifiedTrait(WingedAnimal.class);

        if (wingedAnimals.isEmpty()) {
            return null;
        }

        double longestTail = wingedAnimals.stream()
                .mapToDouble(WingedAnimal::getWingspan)
                .max()
                .orElse(0.0);

        return wingedAnimals.stream()
                .filter(animal -> animal.getWingspan() == longestTail)
                .collect(Collectors.toList());
    }
}