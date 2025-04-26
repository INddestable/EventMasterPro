/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.ticket;
import model.event.Event;

/**
 *
 * @author kevin
 */
public class Ticket {
    private int id;
    private String type;
    private double price;
    private Event event;
    private boolean sold;
    private boolean validated;

    // Constructor vacío
    public Ticket() {
    }

    // Constructor lleno
    public Ticket(int id, String type, double price, Event event) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.event = event;
        this.sold = false;
        this.validated = false;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public boolean isSold() {
        return sold;
    }

    public void sell() {
        this.sold = true;
    }

    public boolean isValidated() {
        return validated;
    }

    public void validate() {
        this.validated = true;
    }

    public void cancel() {
        this.sold = false;
        this.validated = false;
    }
}