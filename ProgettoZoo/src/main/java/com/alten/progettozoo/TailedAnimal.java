package com.alten.progettozoo;

import java.time.LocalDate;

public abstract class TailedAnimal extends Animal {
    private Double tailLength;

    public TailedAnimal(String name, String favFood, Integer age, LocalDate arrivalDate, Double weight, Double height, Double tailLength) {
        super(name, favFood, age, arrivalDate, weight, height);
        this.tailLength = tailLength;
    }

    public Double getTailLength() {
        return tailLength;
    }

    public void setTailLength(Double tailLength) {
        this.tailLength = tailLength;
    }
}
