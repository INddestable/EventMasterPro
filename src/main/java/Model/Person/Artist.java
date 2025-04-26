/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.person;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author kevin
 */

public class Artist extends Person {
    private String technicalRequirements;
    private List<String> record;

    // Empty Constructor 
    public Artist() {
        this.record = new ArrayList<>();
    }

    // Constructor lleno
    public Artist(int id, String name, String contact, String technicalRequirements) {
        super(id, name, contact);
        this.technicalRequirements = technicalRequirements;
        this.record = new ArrayList<>();
    }

    // Getters y Setters
    public String getTechnicalRequirements() {
        return technicalRequirements;
    }

    public void setTechnicalRequirements(String technicalRequirements) {
        this.technicalRequirements = technicalRequirements;
    }

    public List<String> getRecord() {
        return record;
    }

    public void addEventRecord(String event) {
        record.add(event);
    }

    @Override
    public void showProfile() {
        System.out.println("Artist: " + name + " (" + contact + ")");
    }
}
