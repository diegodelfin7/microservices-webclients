package com.intercorp.reto.webclients.webclientreto.model;

import java.io.Serializable;

public class KpiClients implements Serializable {
    private static final long serialVersionUID = 1L;
    private float ageAvarage;
    private double standarDeviation;

    public void setAgeAvarage(float ageAvarage) {
        this.ageAvarage = ageAvarage;
    }

    public float getAgeAvarage() {
        return ageAvarage;
    }

    public void setStandarDeviation(double standarDeviation) {
        this.standarDeviation = standarDeviation;
    }

    public double getStandarDeviation() {
        return standarDeviation;
    }
}