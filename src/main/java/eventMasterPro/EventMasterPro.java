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
                    System.out.println("Exiting EventMaster Pro, Have a good day!");
                    break;
                default:
                    System.out.println("[ERROR] Invalid option. Try again.");
            }
        } while (option != 0);
    }

    //EVENTS
    private void manageEvents() {
        int option;
        do {
            System.out.println("\n=== Manage Events ===");
            System.out.println("1. Create Event");
            System.out.println("2. List Events");
            System.out.println("0. Back to Main Menu");
            System.out.print("Select an option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    createEvent();
                    break;
                case 2:
                    listEvents();
                    break;
                case 0:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (option != 0);
    }

            private void createEvent() {
                System.out.println("\n=== Create New Event ===");

                System.out.print("Enter Event Name: ");
                String name = scanner.nextLine();

                System.out.print("Enter Event Date (DD-MM-YYYY): ");
                String date = scanner.nextLine();

                System.out.print("Enter Event Hour (HH:MM): ");
                String hour = scanner.nextLine();

                System.out.print("Enter Event Type (Concert, Conference, etc.): ");
                String type = scanner.nextLine();

                int newId = events.size() + 1; // Simple ID generator
                Event event = new Event();
                event.setId(newId);
                event.setName(name);
                event.setDate(date);
                event.setHour(hour);
                event.setType(type);
                event.setStatus("Draft"); // Default status

                events.add(event);

                System.out.println("Event created successfully with ID: " + newId);
            }

            private void listEvents() {
                System.out.println("\n=== List of Events ===");
                if (events.isEmpty()) {
                    System.out.println("No events registered yet.");
                } else {
                    for (Event event : events) {
                        System.out.println("ID: " + event.getId() +
                                           " | Name: " + event.getName() +
                                           " | Date: " + event.getDate() +
                                           " | Hour: " + event.getHour() +
                                           " | Type: " + event.getType() +
                                           " | Status: " + event.getStatus());
                    }
                }
            }

    //LOCATIONS
    private void manageLocations() {
        int option;
        do {
            System.out.println("\n=== Manage Locations ===");
            System.out.println("1. Create Location");
            System.out.println("2. List Locations");
            System.out.println("0. Back to Main Menu");
            System.out.print("Select an option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    createLocation();
                    break;
                case 2:
                    listLocations();
                    break;
                case 0:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (option != 0);
    }

        private void createLocation() {
            System.out.println("\n=== Create New Location ===");

            System.out.print("Enter Location Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Address: ");
            String address = scanner.nextLine();

            System.out.print("Enter Capacity: ");
            int capacity = scanner.nextInt();
            scanner.nextLine(); // consume newline

            System.out.print("Enter Technical Features: ");
            String technicalFeatures = scanner.nextLine();

            int newId = locations.size() + 1; // Simple ID generator
            model.location.Location location = new model.location.Location();
            location.setId(newId);
            location.setName(name);
            location.setAddress(address);
            location.setCapacity(capacity);
            location.setTechnicalFeatures(technicalFeatures);

            locations.add(location);

            System.out.println("Location created successfully with ID: " + newId);
        }

        private void listLocations() {
            System.out.println("\n=== List of Locations ===");
            if (locations.isEmpty()) {
                System.out.println("No locations registered yet.");
            } else {
                for (model.location.Location location : locations) {
                    System.out.println("ID: " + location.getId() +
                                       " | Name: " + location.getName() +
                                       " | Address: " + location.getAddress() +
                                       " | Capacity: " + location.getCapacity() +
                                       " | Features: " + location.getTechnicalFeatures());
                }
            }
        }

    
    //ARTISTS
    private void manageArtists() {
        int option;
        do {
            System.out.println("\n=== Manage Artists ===");
            System.out.println("1. Register Artist");
            System.out.println("2. List Artists");
            System.out.println("0. Back to Main Menu");
            System.out.print("Select an option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    registerArtist();
                    break;
                case 2:
                    listArtists();
                    break;
                case 0:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (option != 0);
    }
    
        private void registerArtist() {
            System.out.println("\n=== Register New Artist ===");

            System.out.print("Enter Artist Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Contact Info: ");
            String contact = scanner.nextLine();

            System.out.print("Enter Technical Requirements: ");
            String technicalRequirements = scanner.nextLine();

            int newId = artists.size() + 1; // Simple ID generator
            model.person.Artist artist = new model.person.Artist();
            artist.setId(newId);
            artist.setName(name);
            artist.setContact(contact);
            artist.setTechnicalRequirements(technicalRequirements);

            artists.add(artist);

            System.out.println("Artist registered successfully with ID: " + newId);
        }

        private void listArtists() {
            System.out.println("\n=== List of Artists ===");
            if (artists.isEmpty()) {
                System.out.println("No artists registered yet.");
            } else {
                for (model.person.Artist artist : artists) {
                    System.out.println("ID: " + artist.getId() +
                                       " | Name: " + artist.getName() +
                                       " | Contact: " + artist.getContact() +
                                       " | Requirements: " + artist.getTechnicalRequirements());
                }
            }
        }

        
    //TICKETS && SALES
    private void manageTicketsAndSales() {
        System.out.println("[Manage Tickets and Sales] - (To be implemented)");
    }

    //STATISTICS
    private void viewStatistics() {
        System.out.println("[View Statistics] - (To be implemented)");
    }

    public static void main(String[] args) {
        EventMasterPro system = new EventMasterPro();
        system.start();
    }
}