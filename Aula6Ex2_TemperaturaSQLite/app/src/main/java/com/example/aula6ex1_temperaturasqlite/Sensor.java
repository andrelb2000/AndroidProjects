package com.example.aula6ex1_temperaturasqlite;

public class Sensor {
     private String nomeSensor;
     private double tempSensor;
    public Sensor(String nomeSensor, double tempSensor) {
        this.nomeSensor = nomeSensor;
        this.tempSensor = tempSensor;
    }
    public String getNomeSensor() {
        return nomeSensor;
    }
    public double getTempSensor() {
        return tempSensor;
    }
    @Override
    public String toString() {
        return nomeSensor + " - " + tempSensor + " C";
    }
}
