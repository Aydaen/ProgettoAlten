package com.alten.progettozoo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private List<Eagle> eagles = new ArrayList<>();
    private List<Lion> lions = new ArrayList<>();
    private List<Tiger> tigers = new ArrayList<>();
    private List<Animal> allAnimals = new ArrayList<>();

    public List<Eagle> getEagles() {
        return eagles;
    }

    public void setEagles(List<Eagle> eagles) {
        this.eagles = eagles;
    }

    public List<Lion> getLions() {
        return lions;
    }

    public void setLions(List<Lion> lions) {
        this.lions = lions;
    }

    public List<Tiger> getTigers() {
        return tigers;
    }

    public void setTigers(List<Tiger> tigers) {
        this.tigers = tigers;
    }

    public List<Animal> getAllAnimals() {
        return allAnimals;
    }

    public void setAllAnimals(List<Animal> allAnimals) {
        this.allAnimals = allAnimals;
    }

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
        Lion lion2 = new Lion("Nala", "Meat", 7, LocalDate.of(2018, 8, 18), 190.0, 0.9, 0.7);
        Lion lion3 = new Lion("Mufasa", "Meat", 10, LocalDate.of(2015, 12, 3), 220.0, 1.1, 0.9);
        lions.add(lion1);
        lions.add(lion2);
        lions.add(lion3);

        allAnimals.addAll(eagles);
        allAnimals.addAll(tigers);
        allAnimals.addAll(lions);
    }

    public void findTallestAnimalAmongASpecie(List<? extends Animal> specie) {
        double maxHeight = 0.0;
        List<String> tallestAnimalsNames = new ArrayList<>();

        for (Animal animal : specie) {
            if (animal.getHeight() > maxHeight) {
                // Se l'altezza dell'animale iterato è maggiore di maxHeight significa che è stata trovata una nuova altezza maggiore, quindi rimuovo dall'array eventuali animali
                // precedentemente inseriti e vi inserisco l'animale iterato
                maxHeight = animal.getHeight();
                tallestAnimalsNames.clear();
                tallestAnimalsNames.add(animal.getName());
            } else if (animal.getHeight() == maxHeight) {
                // Se l'altezza dell'animale iterato è uguale all'attuale maxHeight significa che, al momento, ci sono due animali con l'altezza maggiore nella specie, di
                // conseguenza aggiungo l'animale iterato alla lista senza rimuovere quelli precedenti
                tallestAnimalsNames.add(animal.getName());
            }
        }

        if (tallestAnimalsNames.size() == 1) {
            // Se la lista dei nomi degli animali contiene un solo elemento significa che c'è un solo animale con l'altezza maggiore nella sua specie
            System.out.println("L'esemplare più alto nella specie indicata è " + tallestAnimalsNames.get(0) + " con un'altezza di " + maxHeight + " m");
        } else if (tallestAnimalsNames.size() > 1) {
            // Se la lista contiene più di un elemento significa che c'è più di un animale con altezza maggiore, di conseguenza stampo i nomi dei suddetti animali
            StringBuilder result = new StringBuilder("Gli esemplari più alti nella specie selezionata sono ");

            for (String name : tallestAnimalsNames) {
                result.append(name).append(", ");
            }

            // Rimuovo le ultime due posizioni della stringa creata con lo StringBuilder al fine di rimuovere l'ultimo ", " che viene inserito insieme all'ultimo animale iterato
            result.delete(result.length() - 2, result.length());
            result.append(" con un'altezza di ").append(maxHeight).append(" m");

            System.out.println(result);
        } else {
            // Nell'else gestisco il caso in cui la lista contenga meno di un elemento
            System.out.println("Nessun esemplare trovato nella specie selezionata");
        }
    }

    public void findShortestAnimalAmongASpecie(List<? extends Animal> specie) {
        Double minHeight = 0.0;
        List<String> shortestAnimalsNames = new ArrayList<>();

        for (Animal animal : specie) {
            if (minHeight == 0.0) {
                // Se minHeight è uguale a zero significa che ci troviamo nella prima iterazione, quindi il primo animale della lista sarà, momentaneamente, il più basso, dato che
                // è impossibile che esista un animale con altezza minore di 0
                minHeight = animal.getHeight();
                shortestAnimalsNames.add(animal.getName());
            } else {
                // Se l'altezza dell'animale iterato è minore di minHeight significa che è stata trovata una nuova altezza minore, quindi rimuovo dall'array eventuali animali
                // precedentemente inseriti e vi inserisco l'animale iterato
                if (animal.getHeight() < minHeight) {
                    minHeight = animal.getHeight();
                    shortestAnimalsNames.clear();
                    shortestAnimalsNames.add(animal.getName());
                } else if (animal.getHeight() == minHeight) {
                    // Se l'altezza dell'animale iterato è uguale all'attuale minHeight significa che, al momento, ci sono due animali con l'altezza minore nella specie, di
                    //  conseguenza aggiungo l'animale iterato alla lista senza rimuovere quelli precedenti
                    shortestAnimalsNames.add(animal.getName());
                }
            }
        }

        if (shortestAnimalsNames.size() == 1) {
            // Se la lista dei nomi degli animali contiene un solo elemento significa che c'è un unico animale con l'altezza minore nella sua specie
            System.out.println("L'esemplare più basso nella specie indicata è " + shortestAnimalsNames.get(0) + " con un'altezza di " + minHeight + " m");
        } else if (shortestAnimalsNames.size() > 1) {
            // Se la lista contiene più di un elemento significa che c'è più di un animale con altezza minore, di conseguenza stampo i nomi dei suddetti animali
            StringBuilder result = new StringBuilder("Gli esemplari più bassi nella specie indicata sono ");

            for (String name : shortestAnimalsNames) {
                result.append(name).append(", ");
            }

            // Rimuovo le ultime due posizioni della stringa creata con lo strinbuilder al fine di rimuovere l'ultimo ", " che viene inserito insieme all'ultimo animale iterato
            result.delete(result.length() - 2, result.length());
            result.append(" con un'altezza di ").append(minHeight).append(" m");
            System.out.println(result);
        } else {
            // Nell'else gestisco il caso in cui la lista contenga meno di un elemento
            System.out.println("Nessun esemplare trovato nella specie selezionata");
        }
    }

    // Il metodo che segue è identico a findTallestAnimalAmongASpecie riadattato al confronto del peso, mi astengo quindi da ulteriori commenti
    public void findHeaviestAnimalAmongASpecie(List<? extends Animal> specie) {
        Double maxWeight = 0.0;
        List<String> heaviestAnimalsNames = new ArrayList<>();

        for (Animal animal : specie) {
            if (animal.getWeight() > maxWeight) {
                maxWeight = animal.getWeight();
                heaviestAnimalsNames.clear();
                heaviestAnimalsNames.add(animal.getName());
            } else if (animal.getHeight() == maxWeight) {
                heaviestAnimalsNames.add(animal.getName());
            }
        }

        if (heaviestAnimalsNames.size() == 1) {
            System.out.println("L'esemplare più pesante nella specie indicata è " + heaviestAnimalsNames.get(0) + " con un peso di " + maxWeight + " kg");
        } else if (heaviestAnimalsNames.size() > 1) {
            StringBuilder result = new StringBuilder("Gli esemplari più pesanti nella specie indicata sono ");

            for (String name : heaviestAnimalsNames) {
                result.append(name).append(", ");
            }

            result.delete(result.length() - 2, result.length());
            result.append(" con un peso di ").append(maxWeight).append(" kg");
            System.out.println(result);
        } else {
            System.out.println("Nessun esemplare trovato nella specie indicata");
        }
    }

    // Il metodo che segue è identico a findShortestAnimalAmongASpecie riadattato al confronto del peso, mi astengo quindi da ulteriori commenti
    public void findLightestAnimalAmongASpecie(List<? extends Animal> specie) {
        Double minWeight = 0.0;
        List<String> lightestAnimalsNames = new ArrayList<>();

        for (Animal animal : specie) {
            if (minWeight == 0.0) {
                minWeight = animal.getWeight();
                lightestAnimalsNames.add(animal.getName());
            } else {
                if (animal.getWeight() < minWeight) {
                    minWeight = animal.getWeight();
                    lightestAnimalsNames.clear();
                    lightestAnimalsNames.add(animal.getName());
                } else if (animal.getWeight() == minWeight) {
                    lightestAnimalsNames.add(animal.getName());
                }
            }
        }

        if (lightestAnimalsNames.size() == 1) {
            System.out.println("L'esemplare più leggero nella specie indicata è " + lightestAnimalsNames.get(0) + " con un peso di " + minWeight + " kg");
        } else if (lightestAnimalsNames.size() > 1) {
            StringBuilder result = new StringBuilder("Gli esemplari più leggeri nella specie indicata sono ");

            for (String name : lightestAnimalsNames) {
                result.append(name).append(", ");
            }

            result.delete(result.length() - 2, result.length());
            result.append(" con un peso di ").append(minWeight).append(" kg");
            System.out.println(result);
        } else {
            System.out.println("Nessun esemplare trovato nella specie indicata");
        }

    }

    public void findLongestTailAmongTailedAnimals(List<Animal> allAnimals) {
        Double maxTailLength = 0.0;
        List<String> longestTailAnimalsNames = new ArrayList<>();

        for (Animal animal : allAnimals) {
            // Dato che siamo interessati a comparare solo gli animali che dispongono di una coda, grazie al seguente if escludiamo a priori tutti gli animali che ne sono sprovvisti
            if (animal instanceof TailedAnimal) {
                // Effettuiamo il casting a TailedAnimal così da poter accedere alla proprietà getTailLength
                if (((TailedAnimal) animal).getTailLength() > maxTailLength) {
                    // Da qui il metodo è identico a findTallestAnimalAmongASpecie riadattato al confronto della lunghezza della coda, mi astengo quindi da ulteriori commenti
                    maxTailLength = ((TailedAnimal) animal).getTailLength();
                    longestTailAnimalsNames.clear();
                    longestTailAnimalsNames.add(animal.getName());
                } else if (((TailedAnimal) animal).getTailLength() == maxTailLength) {
                    longestTailAnimalsNames.add(animal.getName());
                }
            }
        }

        if (longestTailAnimalsNames.size() == 1) {
            System.out.println("L'animale con la coda più lunga tra quelli dotati di coda è " + longestTailAnimalsNames.get(0) + " con una coda di lunghezza pari a " + maxTailLength + " m");
        } else if (longestTailAnimalsNames.size() > 1) {
            StringBuilder result = new StringBuilder("Gli animali con la coda più lunga tra quelli dotati di coda sono ");

            for (String name : longestTailAnimalsNames) {
                result.append(name).append(", ");
            }

            result.delete(result.length() - 2, result.length());
            result.append(" con una coda di lunghezza pari a ").append(maxTailLength).append(" m");
            System.out.println(result);
        } else {
            System.out.println("Nessun esemplare dotato di coda trovato");
        }

    }

    // Il metodo che segue è identico a findLongestTailAmongTailedAnimals riadattato al confronto dell'apertura alare, mi astengo quindi da ulteriori commenti
    public void findBiggestWingspanAmongWingedAnimals(List<Animal> allAnimals) {
        Double maxWingspan = 0.0;
        List<String> biggestWingspanAnimalsNames = new ArrayList<>();

        for (Animal animal : allAnimals) {
            if (animal instanceof WingedAnimal) {
                if (((WingedAnimal) animal).getWingspan() > maxWingspan) {
                    maxWingspan = ((WingedAnimal) animal).getWingspan();
                    biggestWingspanAnimalsNames.clear();
                    biggestWingspanAnimalsNames.add(animal.getName());
                } else if (((WingedAnimal) animal).getWingspan() == maxWingspan) {
                    biggestWingspanAnimalsNames.add(animal.getName());
                }
            }
        }

        if (biggestWingspanAnimalsNames.size() == 1) {
            System.out.println("L'animale con l'apertura alare più ampia tra quelli dotati di ali è " + biggestWingspanAnimalsNames.get(0) + " con un'apertura alare pari a " + maxWingspan + " m");
        } else if (biggestWingspanAnimalsNames.size() > 1) {
            StringBuilder result = new StringBuilder("Gli animali con l'apertura alare più ampia tra quelli dotati di ali sono ");

            for (String name : biggestWingspanAnimalsNames) {
                result.append(name).append(", ");
            }

            result.delete(result.length() - 2, result.length());
            result.append(" con un'apertura alare di ").append(maxWingspan).append(" m");
            System.out.println(result);
        }

    }
}