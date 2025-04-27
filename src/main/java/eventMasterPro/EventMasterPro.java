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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    private Map<Integer, Map<String, List<Ticket>>> ticketsByEventType;
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
        ticketsByEventType = new HashMap<>();
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
            System.out.println("3. Modify Tickets");
            System.out.println("0. Back to Main Menu");
            option = readInt("Select an option: ");

            switch (option) {
                case 1:
                    createTicketsForEvent();
                    break;
                case 2:
                    listTickets();
                    break;
                case 3:
                    modifyTickets();
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
                System.out.println("No events available. Please create an event first.");
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

            // Comprobar si el evento ya tiene tickets en el nuevo sistema
            if (ticketsByEventType.containsKey(eventId)) {
                System.out.println("This event already has tickets created.");
                return;
            }

            int totalTickets;
            do {
                totalTickets = readInt("Enter Total Number of Tickets to Create: ");
                if (totalTickets <= 0) {
                    System.out.println("[ERROR] The number of tickets must be greater than 0.");
                }
            } while (totalTickets <= 0);

            double generalPrice;
            do {
                generalPrice = readDouble("Enter General Ticket Price: ");
                if (generalPrice <= 0) {
                    System.out.println("[ERROR] The ticket price must be greater than 0.");
                }
            } while (generalPrice <= 0);

            // Crear el mapa para este evento
            Map<String, List<Ticket>> ticketTypes = new HashMap<>();

            // Crear tickets generales
            List<Ticket> generalTickets = new ArrayList<>();
            for (int i = 0; i < totalTickets; i++) {
                int ticketId = tickets.size() + 1; // IDs globales siguen sumando
                Ticket ticket = new Ticket(ticketId, "General", generalPrice, selectedEvent);
                generalTickets.add(ticket);
                tickets.add(ticket); // opcional, mantener la vista global
                selectedEvent.addTicket(ticket); // también en el evento
            }
            ticketTypes.put("General", generalTickets);

            System.out.println(totalTickets + " general tickets created successfully.");

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

                    List<Ticket> specialTicketList = new ArrayList<>();

                    int customized = 0;
                    for (Ticket ticket : generalTickets) {
                        if (ticket.getType().equals("General")) {
                            ticket.setType(specialType);
                            ticket.setPrice(specialPrice);
                            customized++;
                            specialTicketList.add(ticket);
                            if (customized == specialTickets) {
                                break;
                            }
                        }
                    }

                    // Guardar los tickets especiales por tipo
                    ticketTypes.put(specialType, specialTicketList);

                    availableToCustomize -= specialTickets;

                    System.out.println(specialTickets + " tickets customized as " + specialType + ".");

                    if (availableToCustomize == 0) {
                        System.out.println("All tickets have been customized. No more tickets available.");
                        break;
                    }
                } else {
                    System.out.println("[ERROR] Invalid option. Please enter Y or N.");
                }
            }

            // Finalmente guardar todo el mapa de tipos de ticket en el evento
            ticketsByEventType.put(eventId, ticketTypes);

            System.out.println("All tickets saved successfully for event: " + selectedEvent.getName());
        }


        private void listTickets() {
            System.out.println("\n=== List of Tickets Organized by Event and Type ===");

            if (ticketsByEventType.isEmpty()) {
                System.out.println("No tickets created yet.");
                return;
            }

            for (Integer eventId : ticketsByEventType.keySet()) {
                Event event = null;
                for (Event e : events) {
                    if (e.getId() == eventId) {
                        event = e;
                        break;
                    }
                }

                if (event != null) {
                    System.out.println("\nEvent ID: " + event.getId() + " | Event Name: " + event.getName());

                    Map<String, List<Ticket>> ticketTypes = ticketsByEventType.get(eventId);

                    for (String type : ticketTypes.keySet()) {
                        System.out.println("  Ticket Type: " + type);

                        List<Ticket> ticketList = ticketTypes.get(type);
                        for (Ticket ticket : ticketList) {
                            System.out.println("    Ticket ID: " + ticket.getId() +
                                               " | Price: " + ticket.getPrice() +
                                               " | Sold: " + (ticket.isSold() ? "Yes" : "No"));
                        }
                    }
                }
            }
        }


        private void modifyTickets() {
            System.out.println("\n=== Modify Tickets ===");

            if (events.isEmpty()) {
                System.out.println("No events available.");
                return;
            }

            listEvents(); // Muestra eventos disponibles

            int eventId = readInt("Enter Event ID to modify tickets: ");

            Event selectedEvent = null;
            for (Event event : events) {
                if (event.getId() == eventId) {
                    selectedEvent = event;
                    break;
                }
            }

            if (selectedEvent == null) {
                System.out.println("[ERROR] Event not found.");
                return;
            }

            if (selectedEvent.getTickets().isEmpty()) {
                System.out.println("This event has no tickets to modify.");
                return;
            }

            // Listar tickets de este evento
            System.out.println("\nTickets for event: " + selectedEvent.getName());
            for (model.ticket.Ticket ticket : selectedEvent.getTickets()) {
                System.out.println("Ticket ID: " + ticket.getId() +
                                   " | Type: " + ticket.getType() +
                                   " | Price: " + ticket.getPrice() +
                                   " | Sold: " + (ticket.isSold() ? "Yes" : "No"));
            }

            int ticketId = readInt("Enter Ticket ID to modify: ");

            model.ticket.Ticket selectedTicket = null;
            for (model.ticket.Ticket ticket : selectedEvent.getTickets()) {
                if (ticket.getId() == ticketId) {
                    selectedTicket = ticket;
                    break;
                }
            }

            if (selectedTicket == null) {
                System.out.println("[ERROR] Ticket not found.");
                return;
            }

            if (selectedTicket.isSold()) {
                System.out.println("[ERROR] Cannot modify a ticket that has already been sold.");
                return;
            }

            System.out.println("\nCurrent Type: " + selectedTicket.getType());
            System.out.print("Enter new Type (or press Enter to keep current): ");
            String newType = scanner.nextLine();
            if (!newType.trim().isEmpty()) {
                selectedTicket.setType(newType);
            }

            System.out.println("Current Price: " + selectedTicket.getPrice());
            String priceInput;
            System.out.print("Enter new Price (or press Enter to keep current): ");
            priceInput = scanner.nextLine();
            if (!priceInput.trim().isEmpty()) {
                try {
                    double newPrice = Double.parseDouble(priceInput);
                    if (newPrice <= 0) {
                        System.out.println("[ERROR] The price must be greater than 0. Modification cancelled.");
                    } else {
                        selectedTicket.setPrice(newPrice);
                        System.out.println("Ticket updated successfully.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("[ERROR] Invalid price format. Modification cancelled.");
                }
            } else {
                System.out.println("Ticket updated successfully.");
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