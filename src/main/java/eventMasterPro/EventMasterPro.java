/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eventMasterPro;
import model.event.Event;
import model.event.Budget;
import model.location.Location;
import model.person.Artist;
import model.person.Assistant;
import model.person.Administrator;
import model.ticket.Ticket;
import model.ticket.Sale;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author kevin
 */
public class EventMasterPro {
    private List<Event> events;
    private List<Location> locations;
    private List<Artist> artists;
    private List<Assistant> assistants;
    private List<Administrator> administrators;
    private List<Ticket> tickets;
    private List<Sale> sales;

    private Scanner scanner;

    public EventMasterPro() {
        events = new ArrayList<>();
        locations = new ArrayList<>();
        artists = new ArrayList<>();
        assistants = new ArrayList<>();
        administrators = new ArrayList<>();
        tickets = new ArrayList<>();
        sales = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void start() {
        int option;
        do {
            System.out.println("=== EVENTMASTER PRO ===");
            System.out.println("1. Manage Events");
            System.out.println("2. Manage Locations");
            System.out.println("3. Manage Artists");
            System.out.println("4. Manage Tickets and Sales");
            System.out.println("5. View Statistics");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    manageEvents();
                    break;
                case 2:
                    manageLocations();
                    break;
                case 3:
                    manageArtists();
                    break;
                case 4:
                    manageTicketsAndSales();
                    break;
                case 5:
                    viewStatistics();
                    break;
                case 0:
                    System.out.println("Exiting EventMaster Pro...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (option != 0);
    }

    private void manageEvents() {
        System.out.println("[Manage Events] - (To be implemented)");
    }

    private void manageLocations() {
        System.out.println("[Manage Locations] - (To be implemented)");
    }

    private void manageArtists() {
        System.out.println("[Manage Artists] - (To be implemented)");
    }

    private void manageTicketsAndSales() {
        System.out.println("[Manage Tickets and Sales] - (To be implemented)");
    }

    private void viewStatistics() {
        System.out.println("[View Statistics] - (To be implemented)");
    }

    public static void main(String[] args) {
        EventMasterPro system = new EventMasterPro();
        system.start();
    }
}
