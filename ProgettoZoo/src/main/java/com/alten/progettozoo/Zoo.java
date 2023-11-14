package com.alten.progettozoo;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Zoo {
    private final List<Eagle> eagles = new ArrayList<>();
    private final List<Lion> lions = new ArrayList<>();
    private final List<Tiger> tigers = new ArrayList<>();
    private final Map<Class<? extends Animal>, List<? extends Animal>> allAnimals = new HashMap<>();

    public void initializeZoo() {
        Eagle eagle1 = new Eagle("Baldy", "Fish", 5, LocalDate.of(2020, 3, 15), 5.0, 0.5, 2.0);
        Eagle eagle2 = new Eagle("Titty", "Fish", 3, LocalDate.of(2022, 6, 10), 3.0, 0.4, 1.8);
        Eagle eagle3 = new Eagle("Olimpia", "Fish", 4, LocalDate.of(2021, 9, 5), 4.5, 0.45, 2.2);
        eagles.add(eagle1);
        eagles.add(eagle2);
        eagles.add(eagle3);

        Tiger tiger1 = new Tiger("Tigro", "Meat", 6, LocalDate.of(2019, 7, 20), 180.0, 2.0, 1.2);
        Tiger tiger2 = new Tiger("L'uomo tigre", "Meat", 7, LocalDate.of(2018, 5, 12), 175.0, 2.0, 1.1);
        Tiger tiger3 = new Tiger("Fuffy", "Meat", 5, LocalDate.of(2020, 2, 25), 190.0, 1.3, 1.3);
        tigers.add(tiger1);
        tigers.add(tiger2);
        tigers.add(tiger3);

        Lion lion1 = new Lion("Simba", "Meat", 8, LocalDate.of(2017, 11, 10), 200.0, 2.0, 1.2);
        Lion lion2 = new Lion("Nala", "Meat", 7, LocalDate.of(2018, 8, 18), 190.0, 0.9, 1.3);
        Lion lion3 = new Lion("Mufasa", "Meat", 10, LocalDate.of(2015, 12, 3), 220.0, 1.1, 0.9);
        lions.add(lion1);
        lions.add(lion2);
        lions.add(lion3);

        allAnimals.put(Eagle.class, eagles);
        allAnimals.put(Tiger.class, tigers);
        allAnimals.put(Lion.class, lions);
    }

    // Il seguente metodo crea una mappa che ad ogni chiave, rappresentata dalle classi degli animali presenti nel sistema, associa il nome dell'animale tradotto ai fini
    // di una stampa più comprensibile. Nel caso in cui al metodo venga passato come parametro una specie non presente nel sistema questo metodo ritornerà "specie sconosciuta"
    public String speciesNamesTranslation(Class<? extends Animal> specie) {
        Map<Class<? extends Animal>, String> speciesNames = Map.of(
                Eagle.class, "aquila",
                Tiger.class, "tigre",
                Lion.class, "leone"
        );

        return speciesNames.getOrDefault(specie, "Specie sconosciuta");
    }

    public List<? extends Animal> getAllAnimalsOfASpecifiedSpecie(Class<? extends Animal> specie) {
        return allAnimals.get(specie);
    }

    public List<? extends Animal> getAllAnimalsWithASpecifiedTrait(Class<? extends Animal> trait) {
        List<? extends Animal> filteredAnimals;

        filteredAnimals = allAnimals.values().stream()
                // .flatMap(Collection::stream) in questo contesto mi permette di estrarre gli elementi delle collezioni che compongono allAnimals per trasferirli in una map
                .flatMap(Collection::stream)
                .filter(trait::isInstance)
                .collect(Collectors.toList());

        return filteredAnimals;
    }

    public void findTallestAnimalAmongASpecie(Class<? extends Animal> specie) {
        // Recupero la lista degli animali filtrati grazie al metodo getAllAnimalsOfASpecifiedSpecie
        List<? extends Animal> filteredAnimals = getAllAnimalsOfASpecifiedSpecie(specie);

        // Se la lista risulta non vuota procedo al confronto tra le altezze
        if (!filteredAnimals.isEmpty()) {
            double maxHeight = filteredAnimals.stream()
                    .mapToDouble(Animal::getHeight)
                    .max()
                    .orElse(0.0);

            // Creo la lista contenente i nomi degli animali più alti che ottengo effettuando una stream sugli animali filtrati in base alla specie
            List<String> tallestAnimalsNames = filteredAnimals.stream()
                    // Tramite l'operatore .filter escludo gli animali che non abbiano altezza uguale a maxHeight precedentemente determinata
                    .filter(animal -> animal.getHeight() == maxHeight)
                    .map(Animal::getName)
                    .toList();

            // Se tallestAnimalsNames.size è uguale a uno significa che c'è un solo animale più alto, di conseguenza ne stampo il nome e l'altezza
            if (tallestAnimalsNames.size() == 1) {
                System.out.println("L'esemplare più alto nella specie " + speciesNamesTranslation(specie) + " è " + tallestAnimalsNames.get(0) + " con un'altezza di " + maxHeight);
                // Se tallestAnimalsNames.size è maggiore di uno significa che c'è più di un animale con l'altezza maggiore tra quelli esaminati
            } else if (tallestAnimalsNames.size() > 1) {
                String result = tallestAnimalsNames.stream()
                        // Tramite l'operatore .joining, che ci permette di concatenare gli elementi di uno stream in una stringa, creo la stringa result coi nomi degli animali più alti
                        .collect(Collectors.joining(", ", "Gli esemplari più alti nella specie " + speciesNamesTranslation(specie) + " sono ", " con un'altezza di " + maxHeight + " m"));
                System.out.println(result);
            } else {
                System.out.println("Nessun esemplare trovato nella specie selezionata");
            }

        } else {
            System.out.println("Specie non trovata");
        }
    }

    // I metodi che seguono sono identici a findTallestAnimalAmongASpecie, riadattati alla ricerca di parametri diversi indicati nei nomi dei metodi stessi
    // Mi astengo quindi da ulteriori commenti
    public void findShortestAnimalAmongASpecie(Class<? extends Animal> specie) {
        List<? extends Animal> filteredAnimals = getAllAnimalsOfASpecifiedSpecie(specie);

        if (!filteredAnimals.isEmpty()) {
            double minHeight = filteredAnimals.stream()
                    .mapToDouble(Animal::getHeight)
                    .min()
                    .orElse(0.0);

            List<String> shortestAnimalsNames = filteredAnimals.stream()
                    .filter(animal -> animal.getHeight() == minHeight)
                    .map(Animal::getName)
                    .toList();

            if (shortestAnimalsNames.size() == 1) {
                System.out.println("L'esemplare più basso nella specie " + speciesNamesTranslation(specie) + " è " + shortestAnimalsNames.get(0) + " con un'altezza di " + minHeight);
            } else if (shortestAnimalsNames.size() > 1) {
                String result = shortestAnimalsNames.stream()
                        .collect(Collectors.joining(", ", "Gli esemplari più bassi nella specie " + speciesNamesTranslation(specie) + " sono ", " con un'altezza di " + minHeight + " m"));
                System.out.println(result);
            } else {
                System.out.println("Nessun esemplare trovato nella specie selezionata");
            }

        } else {
            System.out.println("Specie non trovata");
        }
    }

    public void findHeaviestAnimalAmongASpecie(Class<? extends Animal> specie) {
        List<? extends Animal> filteredAnimals = getAllAnimalsOfASpecifiedSpecie(specie);

        if (!filteredAnimals.isEmpty()) {
            double maxWeight = filteredAnimals.stream()
                    .mapToDouble(Animal::getHeight)
                    .max()
                    .orElse(0.0);

            List<String> heaviestAnimalsNames = filteredAnimals.stream()
                    .filter(animal -> animal.getHeight() == maxWeight)
                    .map(Animal::getName)
                    .toList();

            if (heaviestAnimalsNames.size() == 1) {
                System.out.println("L'esemplare più pesante nella specie " + speciesNamesTranslation(specie) + " è " + heaviestAnimalsNames.get(0) + " con un peso di " + maxWeight);
            } else if (heaviestAnimalsNames.size() > 1) {
                String result = heaviestAnimalsNames.stream()
                        .collect(Collectors.joining(", ", "Gli esemplari più pesanti nella specie " + speciesNamesTranslation(specie) + " sono ", " con un peso di " + maxWeight + " kg"));
                System.out.println(result);
            } else {
                System.out.println("Nessun esemplare trovato nella specie selezionata");
            }

        } else {
            System.out.println("Specie non trovata");
        }
    }

    public void findLightestAnimalAmongASpecie(Class<? extends Animal> specie) {
        List<? extends Animal> filteredAnimals = getAllAnimalsOfASpecifiedSpecie(specie);

        if (!filteredAnimals.isEmpty()) {
            double minWeight = filteredAnimals.stream()
                    .mapToDouble(Animal::getHeight)
                    .min()
                    .orElse(0.0);

            List<String> lightestAnimalsNames = filteredAnimals.stream()
                    .filter(animal -> animal.getHeight() == minWeight)
                    .map(Animal::getName)
                    .toList();

            if (lightestAnimalsNames.size() == 1) {
                System.out.println("L'esemplare più leggero nella specie " + speciesNamesTranslation(specie) + " è " + lightestAnimalsNames.get(0) + " con un peso di " + minWeight);
            } else if (lightestAnimalsNames.size() > 1) {
                String result = lightestAnimalsNames.stream()
                        .collect(Collectors.joining(", ", "Gli esemplari più leggeri nella specie " + speciesNamesTranslation(specie) + " sono ", " con un peso di " + minWeight + " kg"));
                System.out.println(result);
            } else {
                System.out.println("Nessun esemplare trovato nella specie selezionata");
            }

        } else {
            System.out.println("Specie non trovata");
        }
    }

    public void findLongestTailAmongTailedAnimals() {
        List<? extends Animal> tailedAnimals = getAllAnimalsWithASpecifiedTrait(TailedAnimal.class);

        if (!tailedAnimals.isEmpty()) {
            double longestTail = tailedAnimals.stream()
                    .mapToDouble(animal -> ((TailedAnimal) animal).getTailLength())
                    .max()
                    .orElse(0.0);

            List<String> animalsWithLongestTails = tailedAnimals.stream()
                    .filter(animal -> ((TailedAnimal) animal).getTailLength() == longestTail)
                    .map(Animal::getName)
                    .toList();

            if (animalsWithLongestTails.size() == 1) {
                System.out.println("L'animale con la coda più lunga è " + animalsWithLongestTails.get(0) + " con una lunghezza di " + longestTail + " m");
            } else {
                String result = animalsWithLongestTails.stream()
                        .collect(Collectors.joining(", ", "Gli animali con le code più lunghe sono ", " con una lunghezza di " + longestTail + " m"));
                System.out.println(result);
            }
        } else {
            System.out.println("Nessun animale con coda presente nel sistema");
        }
    }

    public void findBiggestWingspanAmongWingedAnimals() {
        List<? extends Animal> wingedAnimals = getAllAnimalsWithASpecifiedTrait(WingedAnimal.class);

        if (!wingedAnimals.isEmpty()) {
            double biggestWingspan = wingedAnimals.stream()
                    .mapToDouble(animal -> ((WingedAnimal) animal).getWingspan())
                    .max()
                    .orElse(0.0);

            List<String> animalsWithBiggestWingspan = wingedAnimals.stream()
                    .filter(animal -> ((WingedAnimal) animal).getWingspan() == biggestWingspan)
                    .map(Animal::getName)
                    .toList();

            if (animalsWithBiggestWingspan.size() == 1) {
                System.out.println("L'animale con l'apertura alare più grande è " + animalsWithBiggestWingspan.get(0) + " con un'apertura di " + biggestWingspan + " m");
            } else {
                String result = animalsWithBiggestWingspan.stream()
                        .collect(Collectors.joining(", ", "Gli animali con le apertura alare più grande sono ", " con un'apertura di " + biggestWingspan + " m"));
                System.out.println(result);
            }

        } else {
            System.out.println("Nessun animale con apertura alare nel sistema");
        }
    }
}