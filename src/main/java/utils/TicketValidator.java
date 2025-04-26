/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package utils;
import model.ticket.Ticket;
import model.person.Assistant;
/**
 *
 * @author kevin
 */
public interface TicketValidator {
    boolean validate(Ticket ticket);
    boolean isAlreadyValidated(Ticket ticket);
    boolean isOwnedBy(Ticket ticket, Assistant assistant);
}
