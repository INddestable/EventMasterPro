/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Event;

import java.util.List;
import java.util.ArrayList;
import Model.Location.Location;
import Model.Person.Artist;
import Model.Ticket.Ticket;

/**
 *
 * @author kevin
 */

public class Event {
    private int id;
    private String name;
    private String date;
    private String hour;
    private String type;
    private Location location;
    private List<Artist> artists;
    private List<Ticket> tickets;
    private Budget budget;
    private String status;

    // Constructor vacío
    public Event() {
        this.artists = new ArrayList<>();
        this.tickets = new ArrayList<>();
    }

    // Constructor lleno
    public Event(int id, String name, String date, String hour, String type, Location location, Budget budget, String status) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.hour = hour;
        this.type = type;
        this.location = location;
        this.budget = budget;
        this.status = status;
        this.artists = new ArrayList<>();
        this.tickets = new ArrayList<>();
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void addArtist(Artist artist) {
        this.artists.add(artist);
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}