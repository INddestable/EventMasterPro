/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.ticket;
import model.person.Assistant;
import java.util.Date;
/**
 *
 * @author kevin
 */
public class Sale {
    private int id;
    private Ticket ticket;
    private Assistant buyer;
    private Date date;
    private double amount;

    // Constructor vacío
    public Sale() {
    }

    // Constructor lleno
    public Sale(int id, Ticket ticket, Assistant buyer, Date date, double amount) {
        this.id = id;
        this.ticket = ticket;
        this.buyer = buyer;
        this.date = date;
        this.amount = amount;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Assistant getBuyer() {
        return buyer;
    }

    public void setBuyer(Assistant buyer) {
        this.buyer = buyer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
