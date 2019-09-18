package com.example.aula6ex1_temperaturasqlite;

public class Sensor {
     private String nomeSensor;
     private int    codSensor;
     private double tempSensor;
    public Sensor(String nomeSensor, int codSensor, double tempSensor) {
        this.nomeSensor = nomeSensor;
        this.codSensor = codSensor;
        this.tempSensor = tempSensor;
    }
    public String getNomeSensor() {
        return nomeSensor;
    }
    public int getCodSensor() {
        return codSensor;
    }
    public double getTempSensor() {
        return tempSensor;
    }
    @Override
    public String toString() {
        return nomeSensor + " - " + tempSensor + " C";
    }
}
