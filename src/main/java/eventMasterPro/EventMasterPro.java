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
    
    //Safe Int & Double ENTRY
    //SAFE INT
    private int readInt(String message) {
        int value;
        while (true) {
            try {
                System.out.print(message);
                value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } catch (Exception e) {
                System.out.println("[ERROR] Invalid input. Please enter a valid integer number.");
                scanner.nextLine();
            }
        }
    }

    //SAFE DOUBLE
    private double readDouble(String message) {
        double value;
        while (true) {
            try {
                System.out.print(message);
                value = scanner.nextDouble();
                scanner.nextLine();
                return value;
            } catch (Exception e) {
                System.out.println("[ERROR] Invalid input. Please enter a valid decimal number.");
                scanner.nextLine();
            }
        }
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
            option = readInt("Select an option: ");

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
            option = readInt("Select an option: ");

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
            option = readInt("Select an option: ");

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

            int capacity = readInt("Enter Capacity");

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
            option = readInt("Select an option: ");

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
        int option;
        do {
            System.out.println("\n=== Manage Tickets and Sales ===");
            System.out.println("1. Create Tickets for Event");
            System.out.println("2. List Tickets");
            System.out.println("0. Back to Main Menu");
            option = readInt("Select an option: ");

            switch (option) {
                case 1:
                    createTicketsForEvent();
                    break;
                case 2:
                    listTickets();
                    break;
                case 0:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (option != 0);
    }

        private void createTicketsForEvent() {
            System.out.println("\n=== Create Tickets for Event ===");

            if (events.isEmpty()) {
                System.out.println("[ERROR] No events available. Please create an event first.");
                return;
            }

            listEvents();

            int eventId = readInt("Enter Event ID to create tickets for: ");

            Event selectedEvent = null;
            for (Event event : events) {
                if (event.getId() == eventId) {
                    selectedEvent = event;
                    break;
                }
            }

            if (selectedEvent == null) {
                System.out.println("Event not found.");
                return;
            }

            // Event have tickets now
            if (!selectedEvent.getTickets().isEmpty()) {
                System.out.println("[ERROR] This event already has tickets created.");
                return;
            }

            //Set total tickets
            int totalTickets;
            do {
                totalTickets = readInt("Enter Total Number of Tickets to Create: ");
                if (totalTickets <= 0) {
                    System.out.println("[ERROR] The number of tickets must be greater than 0.");
                }
            } while (totalTickets <= 0);

            //set general price
            double generalPrice;
            do {
                generalPrice = readDouble("Enter General Ticket Price: ");
                if (generalPrice <= 0) {
                    System.out.println("[ERROR] The ticket price must be greater than 0.");
                }
            } while (generalPrice <= 0);

            // Create general tickets
            List<model.ticket.Ticket> tempTickets = new ArrayList<>();
            for (int i = 0; i < totalTickets; i++) {
                int ticketId = tickets.size() + 1;
                model.ticket.Ticket ticket = new model.ticket.Ticket(ticketId, "General", generalPrice, selectedEvent);
                tempTickets.add(ticket);
            }

            System.out.println(totalTickets + " general tickets created successfully.");

            //Customize new tickets
            int availableToCustomize = totalTickets;
            while (true) {
                System.out.print("Do you want to customize special tickets? (Y/N): ");
                String response = scanner.nextLine();
                if (response.equalsIgnoreCase("N")) {
                    break;
                } else if (response.equalsIgnoreCase("Y")) {
                    int specialTickets;
                    do {
                        specialTickets = readInt("Enter number of Special Tickets: ");
                        if (specialTickets <= 0) {
                            System.out.println("[ERROR] The number of special tickets must be greater than 0.");
                        } else if (specialTickets > availableToCustomize) {
                            System.out.println("[ERROR] You cannot customize more tickets than available (" + availableToCustomize + "). Try again.");
                            specialTickets = -1;
                        }
                    } while (specialTickets <= 0);

                    System.out.print("Enter Special Ticket Type (e.g., VIP, Platinum): ");
                    String specialType = scanner.nextLine();

                    double specialPrice;
                    do {
                        specialPrice = readDouble("Enter Special Ticket Price: ");
                        if (specialPrice <= 0) {
                            System.out.println("[ERROR] The special ticket price must be greater than 0.");
                        }
                    } while (specialPrice <= 0);

                    int customized = 0;
                    for (model.ticket.Ticket ticket : tempTickets) {
                        if (ticket.getType().equals("General")) {
                            ticket.setType(specialType);
                            ticket.setPrice(specialPrice);
                            customized++;
                            if (customized == specialTickets) {
                                break;
                            }
                        }
                    }
                    availableToCustomize -= specialTickets;

                    System.out.println(specialTickets + " tickets customized as " + specialType + ".");

                    if (availableToCustomize == 0) {
                        System.out.println("[ERROR] All tickets have been customized. No more tickets available.");
                        break;
                    }
                } else {
                    System.out.println("[ERROR] Invalid option. Please enter Y or N.");
                }
            }

            //add modify tickets to the principal list
            for (model.ticket.Ticket ticket : tempTickets) {
                tickets.add(ticket);
                selectedEvent.addTicket(ticket);
            }

            System.out.println("All tickets saved successfully for event: " + selectedEvent.getName());
        }



        private void listTickets() {
            System.out.println("\n=== List of Tickets ===");
            if (tickets.isEmpty()) {
                System.out.println("No tickets created yet.");
            } else {
                for (model.ticket.Ticket ticket : tickets) {
                    System.out.println("ID: " + ticket.getId() +
                                       " | Type: " + ticket.getType() +
                                       " | Price: " + ticket.getPrice() +
                                       " | Event: " + ticket.getEvent().getName() +
                                       " | Sold: " + (ticket.isSold() ? "Yes" : "No"));
                }
            }
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