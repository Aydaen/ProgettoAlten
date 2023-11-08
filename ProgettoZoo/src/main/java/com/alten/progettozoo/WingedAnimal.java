package com.alten.progettozoo;

import java.time.LocalDate;

public abstract class WingedAnimal extends Animal {
    private Double wingspan;

    public WingedAnimal(String name, String favFood, Integer age, LocalDate arrivalDate, Double weight, Double height, Double wingspan) {
        super(name, favFood, age, arrivalDate, weight, height);
        this.wingspan = wingspan;
    }

    public Double getWingspan() {
        return wingspan;
    }

    public void setWingspan(Double wingspan) {
        this.wingspan = wingspan;
    }
}
