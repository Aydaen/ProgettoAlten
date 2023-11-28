package com.alten.progettozoo;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Zoo {

    private final Map<Class<? extends Animal>, List<Animal>> allAnimals = new HashMap<>();

    public void addAnimal(Animal animal) {
        Class<? extends Animal> species = animal.getClass();
        allAnimals.computeIfAbsent(species, key -> new ArrayList<>()).add(animal);
    }

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

    public <T extends Animal> List<T> getAllAnimalsBySpecies(Class<T> species) {
        if (allAnimals.get(species) != null) {
            return (List<T>) allAnimals.get(species);
        }

        return allAnimals.values().stream()
                .filter(species::isInstance)
                .map(species::cast)
                .collect(Collectors.toList());
    }

    public <T extends Animal> List<T> getAllAnimalsByTrait(Class<T> trait) {
        return allAnimals.values().stream()
                .flatMap(Collection::stream)
                .filter(trait::isInstance)
                .map(trait::cast)
                .toList();
    }

    public <T extends Animal> List<T> findTallestAnimalsBySpecies(Class<T> species) {
        List<T> filteredAnimals = getAllAnimalsBySpecies(species);

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

    public <T extends Animal> List<T> findShortestAnimalsBySpecies(Class<T> species) {
        List<T> filteredAnimals = getAllAnimalsBySpecies(species);

        if (filteredAnimals.isEmpty()) {
            return null;
        }

        double minHeight = filteredAnimals.stream()
                .mapToDouble(Animal::getHeight)
                .min()
                .orElse(0.0);

        return filteredAnimals.stream()
                .filter(animal -> animal.getHeight() == minHeight)
                .collect(Collectors.toList());
    }

    public <T extends Animal> List<T> findHeaviestAnimalsBySpecie(Class<T> species) {
        List<T> filteredAnimals = getAllAnimalsBySpecies(species);

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

    public <T extends Animal> List<T> findLightestAnimalsBySpecie(Class<T> species) {
        List<T> filteredAnimals = getAllAnimalsBySpecies(species);

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

    public List<TailedAnimal> findLongestTails() {
        List<TailedAnimal> tailedAnimals = getAllAnimalsByTrait(TailedAnimal.class);

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

    public List<WingedAnimal> findBiggestWingspans() {
        List<WingedAnimal> wingedAnimals = getAllAnimalsByTrait(WingedAnimal.class);

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