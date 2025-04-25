/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Person;
import java.util.List;
import java.util.ArrayList;
import Model.Ticket.Ticket;
/**
 *
 * @author kevin
 */
public class Assistant extends Person {
    private List<Ticket> ticketsPurchased;

    // Constructor vacío
    public Assistant() {
        this.ticketsPurchased = new ArrayList<>();
    }

    // Constructor lleno
    public Assistant(int id, String name, String contact) {
        super(id, name, contact);
        this.ticketsPurchased = new ArrayList<>();
    }

    // Getters y Setters
    public List<Ticket> getTicketsPurchased() {
        return ticketsPurchased;
    }

    public void addTicketPurchased(Ticket ticket) {
        ticketsPurchased.add(ticket);
    }

    @Override
    public void showProfile() {
        System.out.println("Assistant: " + name + " (" + contact + ")");
    }
}