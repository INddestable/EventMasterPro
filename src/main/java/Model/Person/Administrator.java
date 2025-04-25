/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Person;

/**
 *
 * @author kevin
 */

public class Administrator extends Person {
    private String position;

    // Constructor vacío
    public Administrator() {
    }

    // Constructor lleno
    public Administrator(int id, String name, String contact, String position) {
        super(id, name, contact);
        this.position = position;
    }

    // Getters y Setters
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public void showProfile() {
        System.out.println("Administrator: " + name + " (" + contact + ")");
    }

    // Métodos que luego implementaremos: createEvent, modifyEvent, etc.
}

