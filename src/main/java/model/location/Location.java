/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.location;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;
/**
 *
 * @author kevin
 */
public class Location {
    private int id;
    private String name;
    private String address;
    private int capacity;
    private String technicalFeatures;
    private Map<Date, Boolean> availability;

    // Constructor vacío
    public Location() {
        this.availability = new HashMap<>();
    }

    // Constructor lleno
    public Location(int id, String name, String address, int capacity, String technicalFeatures) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.technicalFeatures = technicalFeatures;
        this.availability = new HashMap<>();
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getTechnicalFeatures() {
        return technicalFeatures;
    }

    public void setTechnicalFeatures(String technicalFeatures) {
        this.technicalFeatures = technicalFeatures;
    }

    public Map<Date, Boolean> getAvailability() {
        return availability;
    }

    public void setAvailability(Map<Date, Boolean> availability) {
        this.availability = availability;
    }

    // Método para verificar disponibilidad
    public boolean isAvailable(Date date) {
        return availability.getOrDefault(date, true);
    }

    // Método para reservar la fecha
    public void reserve(Date date) {
        availability.put(date, false);
    }
}