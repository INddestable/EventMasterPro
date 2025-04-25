/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Event;

/**
 *
 * @author kevin
 */

public class Budget {
    private int id;
    private Event event;
    private double income;
    private double expense;

    // Constructor vacío
    public Budget() {
    }

    // Constructor lleno
    public Budget(int id, Event event, double income, double expense) {
        this.id = id;
        this.event = event;
        this.income = income;
        this.expense = expense;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public double getIncome() {
        return income;
    }

    public void registerIncome(double amount) {
        this.income += amount;
    }

    public double getExpense() {
        return expense;
    }

    public void registerExpense(double amount) {
        this.expense += amount;
    }

    public double calculateBalance() {
        return income - expense;
    }
}
