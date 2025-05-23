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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import model.person.Person;

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
            System.out.println("\n=== EventMaster Pro ===");
            System.out.println("1. Administrator");
            System.out.println("2. Assistant");
            System.out.println("0. Exit");
            option = readInt("Select your role: ");

            switch (option) {
                case 1:
                    administratorMenu();
                    break;
                case 2:
                    assistantMenu();
                    break;
                case 69:
                    messageEasterEgg();
                    break;
                case 0:
                    System.out.println("Exiting EventMaster Pro, have a good day!");
                    break;
                default:
                    System.out.println("[ERROR] Invalid option. Try again.");
            }
        } while (option != 0);
    }

    // Admin menu
    private void administratorMenu() {
        int option;
        do {
            System.out.println("\n=== Administrator Menu ===");
            System.out.println("1. Manage Events");
            System.out.println("2. Manage Locations");
            System.out.println("3. Manage Artists");
            System.out.println("4. Manage Tickets and Sales");
            System.out.println("5. View Statistics");
            System.out.println("0. Back to Role Selection");
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
                    System.out.println("Returning to Role Selection...");
                    break;
                default:
                    System.out.println("[ERROR] Invalid option. Try again.");
            }
        } while (option != 0);
    }

    // Assistant menu
    private void assistantMenu() {
        int option;
        do {
            System.out.println("\n=== Assistant Menu ===");
            System.out.println("1. View Events");
            System.out.println("2. Buy Tickets");
            System.out.println("3. Validate Ticket");
            System.out.println("4. View My History");
            System.out.println("0. Back to Role Selection");
            option = readInt("Select an option: ");

            switch (option) {
                case 1:
                    viewEventsForAssistant();
                    break;
                case 2:
                    buyTickets();
                    break;
                case 3:
                    validateTicket();
                    break;
                case 4:
                    viewMyHistory();
                    break;
                case 0:
                    System.out.println("Returning to Role Selection...");
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
            System.out.println("3. Modify Event");
            System.out.println("4. Delete Event");
            System.out.println("0. Back to Main Menu");
            option = readInt("Select an option: ");

            switch (option) {
                case 1:
                    createEvent();
                    break;
                case 2:
                    listEvents();
                    break;
                case 3:
                    modifyEvent();
                    break;
                case 4:
                    deleteEvent();
                    break;
                case 0:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (option != 0);
    }

    // Create Event
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

        //ARTIST
        if (artists.isEmpty()) {
            System.out.println("[ERROR] No artists registered. You need to register at least one.");
            registerArtist();
        }

        // Available Artist
        System.out.println("\nAvailable Artists:");
        for (Artist artist : artists) {
            System.out.println(artist.getId() + ". " + artist.getName());
        }

        // Asing artist
        int artistId = readInt("Enter Artist ID to assign to this event: ");
        Artist selectedArtist = null;
        for (Artist artist : artists) {
            if (artist.getId() == artistId) {
                selectedArtist = artist;
                break;
            }
        }

        if (selectedArtist == null) {
            System.out.println("[ERROR] Artist not found. Event creation cancelled.");
            return;
        }

        //LOCATON
        if (locations.isEmpty()) {
            System.out.println("[ERROR] No locations registered. You need to create at least one.");
            createLocation();
        }

        // available Locations:
        System.out.println("\nAvailable Locations:");
        for (Location location : locations) {
            System.out.println(location.getId() + ". " + location.getName() + " (Capacity: " + location.getCapacity() + ")");
        }

        int locationId = readInt("Enter Location ID to assign to this event: ");
        Location selectedLocation = null;
        for (Location location : locations) {
            if (location.getId() == locationId) {
                selectedLocation = location;
                break;
            }
        }

        if (selectedLocation == null) {
            System.out.println("[ERROR] Location not found. Event creation cancelled.");
            return;
        }

        System.out.println("\n===== ADVICE ===== \nPlease remember create Tickets After the creation of this event");

        // --- Creation of Event ---
        int newId = events.size() + 1; // Simple ID generator
        Event event = new Event();
        event.setId(newId);
        event.setName(name);
        event.setDate(date);
        event.setHour(hour);
        event.setType(type);
        event.setStatus("Complete"); // Default status
        event.setLocation(selectedLocation);
        event.addArtist(selectedArtist);

        events.add(event);

        System.out.println("Event created successfully with ID: " + newId);
    }

    // See events
    private void listEvents() {
        System.out.println("\n=== List of Events ===");
        if (events.isEmpty()) {
            System.out.println("No events registered yet.");
        } else {
            for (Event event : events) {
                System.out.println("ID: " + event.getId()
                        + " | Name: " + event.getName()
                        + " | Date: " + event.getDate()
                        + " | Hour: " + event.getHour()
                        + " | Type: " + event.getType()
                        + " | Location: " + event.getLocation().getName()
                        + " | Artists: " + event.getArtists()
                        + " | Status: " + event.getStatus());
            }
        }
    }

    //Modify Event
    private void modifyEvent() {
        System.out.println("\n=== Modify Event ===");

        if (events.isEmpty()) {
            System.out.println("No events available to modify.");
            return;
        }

        listEvents(); // List of events available

        int eventId = readInt("Enter the Event ID to modify: ");

        Event eventToModify = null;
        for (Event event : events) {
            if (event.getId() == eventId) {
                eventToModify = event;
                break;
            }
        }

        if (eventToModify == null) {
            System.out.println("[ERROR] Event not found.");
            return;
        }

        System.out.println("\nSelect what you want to modify:");
        System.out.println("1. Name");
        System.out.println("2. Date");
        System.out.println("3. Hour");
        System.out.println("4. Type");
        System.out.println("0. Cancel");
        int option = readInt("Choose an option: ");

        switch (option) {
            case 1:
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                eventToModify.setName(newName);
                break;
            case 2:
                System.out.print("Enter new date (DD-MM-YYYY): ");
                String newDate = scanner.nextLine();
                eventToModify.setDate(newDate);
                break;
            case 3:
                System.out.print("Enter new hour (HH:MM): ");
                String newHour = scanner.nextLine();
                eventToModify.setHour(newHour);
                break;
            case 4:
                System.out.print("Enter new event type: ");
                String newType = scanner.nextLine();
                eventToModify.setType(newType);
                break;
            case 0:
                System.out.println("Modification cancelled.");
                return;
            default:
                System.out.println("[ERROR] Invalid option.");
                return;
        }

        System.out.println("Event modified successfully!");
    }

    //Delete event
    private void deleteEvent() {
        System.out.println("\n=== Delete Event ===");

        if (events.isEmpty()) {
            System.out.println("No events available to delete.");
            return;
        }

        listEvents(); // See all events

        System.out.println("[ERROR] ===== WARNING ===== \n Are you sure you want to delete the event? \n THIS IS UNFIXABLE. \n If you delete it, it will be gone forever.");
        int eventId = readInt("Enter the Event ID to delete: ");

        Event eventToDelete = null;
        for (Event event : events) {
            if (event.getId() == eventId) {
                eventToDelete = event;
                break;
            }
        }

        if (eventToDelete == null) {
            System.out.println("[ERROR] Event not found.");
            return;
        }

        // Remove Tickets of the Event
        tickets.removeIf(ticket -> ticket.getEvent().equals(ticket/*eventToDelete*/));
        ticketsByEventType.remove(eventId);

        // Remove event
        events.remove(eventToDelete);

        System.out.println("Event deleted successfully.");
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

        int capacity = readInt("Enter Capacity: ");

        System.out.print("Enter Technical Features: ");
        String technicalFeatures = scanner.nextLine();

        int newId = locations.size() + 1;
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
                System.out.println("ID: " + location.getId()
                        + " | Name: " + location.getName()
                        + " | Address: " + location.getAddress()
                        + " | Capacity: " + location.getCapacity()
                        + " | Features: " + location.getTechnicalFeatures());
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
                System.out.println("ID: " + artist.getId()
                        + " | Name: " + artist.getName()
                        + " | Contact: " + artist.getContact()
                        + " | Requirements: " + artist.getTechnicalRequirements());
            }
        }
    }

    //TICKE+TS && SALES
    private void manageTicketsAndSales() {
        int option;
        do {
            System.out.println("\n=== Manage Tickets and Sales ===");
            System.out.println("1. Create Tickets for Event");
            System.out.println("2. List Tickets");
            //System.out.println("3. Modify Tickets");
            System.out.println("0. Back to Main Menu");
            option = readInt("Select an option: ");

            switch (option) {
                case 1:
                    createTicketsForEvent();
                    break;
                case 2:
                    listTickets();
                    break;
                /*case 3:
                    //modifyTickets();
                    break;*/
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

        // Check if the event already has tickets assigned
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

        // create hashmap fot the tickets of the event
        Map<String, List<Ticket>> ticketTypes = new HashMap<>();

        // Creation of General tickets
        List<Ticket> generalTickets = new ArrayList<>();
        for (int i = 0; i < totalTickets; i++) {
            int ticketId = tickets.size() + 1; // Tickets ID auto-increment
            Ticket ticket = new Ticket(ticketId, "General", generalPrice, selectedEvent);
            generalTickets.add(ticket);
            tickets.add(ticket);
            selectedEvent.addTicket(ticket);
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
                List<Ticket> generalList = ticketTypes.get("General"); // Update the general list

                int customized = 0;
                Iterator<Ticket> iterator = generalList.iterator();
                while (iterator.hasNext() && customized < specialTickets) {
                    Ticket ticket = iterator.next();
                    if (ticket.getType().equals("General")) {
                        ticket.setType(specialType);
                        ticket.setPrice(specialPrice);
                        specialTicketList.add(ticket);
                        iterator.remove();
                        customized++;
                    }
                }

                // Save Special types of tickets
                if (ticketTypes.containsKey(specialType)) {
                    ticketTypes.get(specialType).addAll(specialTicketList);
                } else {
                    ticketTypes.put(specialType, specialTicketList);
                }

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

        // put every type of tickets on the hashmap
        ticketsByEventType.put(eventId, ticketTypes);

        System.out.println("All tickets saved successfully for event: " + selectedEvent.getName());
    }

    private void listTickets() {
        System.out.println("\n=== List Tickets by Event ===");

        if (ticketsByEventType.isEmpty()) {
            System.out.println("No tickets created yet.");
            return;
        }

        List<Integer> eventIds = new ArrayList<>(ticketsByEventType.keySet());

        // Available Events
        for (int i = 0; i < eventIds.size(); i++) {
            int eventId = eventIds.get(i);
            Event event = findEventById(eventId);
            if (event != null) {
                System.out.println((i + 1) + ". ID: " + event.getId() + " | Name: " + event.getName());
            }
        }

        int eventOption = readInt("Select an event to view its ticket types: ") - 1;

        if (eventOption < 0 || eventOption >= eventIds.size()) {
            System.out.println("[ERROR] Invalid selection.");
            return;
        }

        int selectedEventId = eventIds.get(eventOption);
        Event selectedEvent = findEventById(selectedEventId);

        if (selectedEvent == null) {
            System.out.println("[ERROR] Event not found.");
            return;
        }

        System.out.println("\n=== Ticket Types for Event: " + selectedEvent.getName() + " ===");

        Map<String, List<Ticket>> ticketTypes = ticketsByEventType.get(selectedEventId);

        int typeNumber = 1;
        for (String type : ticketTypes.keySet()) {
            int amount = ticketTypes.get(type).size();
            System.out.println(typeNumber + ". " + type + " (" + amount + " tickets)");
            typeNumber++;
        }
    }

    // Search Event By ID
    private Event findEventById(int eventId) {
        for (Event event : events) {
            if (event.getId() == eventId) {
                return event;
            }
        }
        return null;
    }

    /*
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
     */
    //STATISTICS
    private void viewStatistics() {
        System.out.println("\n=== Event Statistics ===");

        if (tickets.isEmpty()) {
            System.out.println("No ticket sales data available.");
            return;
        }

        int totalTicketsSold = 0;
        double totalRevenue = 0.0;

        // HashMap for count all selled tickets
        Map<Event, Integer> eventSales = new HashMap<>();

        for (Ticket ticket : tickets) {
            if (ticket.isSold()) {
                totalTicketsSold++;
                totalRevenue += ticket.getPrice();

                Event event = ticket.getEvent();
                eventSales.put(event, eventSales.getOrDefault(event, 0) + 1);
            }
        }

        System.out.println("Total Tickets Sold: " + totalTicketsSold);
        System.out.println("Total Revenue: $" + totalRevenue);

        if (eventSales.isEmpty()) {
            System.out.println("No event sales to show rankings.");
            return;
        }

        // sort events for amount of tickets selleds (JUST TOP 3)
        List<Map.Entry<Event, Integer>> sortedEvents = new ArrayList<>(eventSales.entrySet());
        sortedEvents.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        System.out.println("\nTop Events by Tickets Sold:");
        int rank = 1;
        for (Map.Entry<Event, Integer> entry : sortedEvents) {
            System.out.println(rank + ". " + entry.getKey().getName() +
                               " - Tickets Sold: " + entry.getValue());
            rank++;
            if (rank > 3) break; // Just top 3
        }
    }
    
    private void viewEventsForAssistant() {
        System.out.println("\n=== Available Events ===");

        if (events.isEmpty()) {
            System.out.println("No events available at the moment.");
            return;
        }

        for (Event event : events) {
            System.out.println("ID: " + event.getId() +
                               " | Name: " + event.getName() +
                               " | Date: " + event.getDate() +
                               " | Hour: " + event.getHour() +
                               " | Type: " + event.getType() +
                               " | Artist: " + (event.getArtists()!= null ? event.getArtists(): "N/A") + 
                               " | Location: " + (event.getLocation() != null ? event.getLocation().getName() : "N/A"));
            
        }

        System.out.print("\nDo you want to buy tickets for an event? (Y/N): ");
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("Y")) {
            buyTickets();
        } else {
            System.out.println("Returning to Assistant Menu...");
        }
    }
    
    private void messageEasterEgg(){
        System.out.println("¡Construido con pasión, esfuerzo y una mente imparable! ");
        System.out.println("Proyecto hecho por Kevin y ChatGPT que cree en su grandeza.");
        System.out.println("¡Sigue soñando en grande! -ChatGPT");
        System.out.println("\nQue hijueputa tortura, aunque ChaPT ayudo muuucho -Kevin");
        System.out.println("\n(c) derechos reservados 2025-9999 Kevin");
        return;
    }

    private void buyTickets() {
        System.out.println("\n=== Buy Tickets ===");

        if (events.isEmpty() || ticketsByEventType.isEmpty()) {
            System.out.println("No tickets available at the moment.");
            return;
        }

        // available events
        List<Integer> eventIds = new ArrayList<>(ticketsByEventType.keySet());

        for (int i = 0; i < eventIds.size(); i++) {
            int eventId = eventIds.get(i);
            Event event = findEventById(eventId);
            if (event != null) {
                System.out.println((i + 1) + ". ID: " + event.getId() + " | Name: " + event.getName());
            }
        }

        int eventOption = readInt("Select an event to buy tickets from: ") - 1;
        if (eventOption < 0 || eventOption >= eventIds.size()) {
            System.out.println("[ERROR] Invalid event selection.");
            return;
        }

        int selectedEventId = eventIds.get(eventOption);
        Event selectedEvent = findEventById(selectedEventId);

        if (selectedEvent == null) {
            System.out.println("[ERROR] Event not found.");
            return;
        }

        Map<String, List<Ticket>> ticketTypes = ticketsByEventType.get(selectedEventId);

        // avaliable ticket types
        System.out.println("\nAvailable Ticket Types:");
        List<String> types = new ArrayList<>(ticketTypes.keySet());
        for (int i = 0; i < types.size(); i++) {
            String type = types.get(i);
            long available = ticketTypes.get(type).stream().filter(t -> !t.isSold()).count();
            System.out.println((i + 1) + ". " + type + " (" + available + " available)");
        }

        int typeOption = readInt("Select ticket type to buy: ") - 1;
        if (typeOption < 0 || typeOption >= types.size()) {
            System.out.println("[ERROR] Invalid ticket type selection.");
            return;
        }

        String selectedType = types.get(typeOption);
        List<Ticket> availableTickets = ticketTypes.get(selectedType);

        // Search no sold ticket
        Ticket ticketToBuy = null;
        for (Ticket ticket : availableTickets) {
            if (!ticket.isSold()) {
                ticketToBuy = ticket;
                break;
            }
        }

        if (ticketToBuy == null) {
            System.out.println("[ERROR] No tickets available of this type.");
            return;
        }

        ticketToBuy.setSold();
        System.out.println("Ticket purchased successfully!");
        System.out.println("Ticket ID: " + ticketToBuy.getId() +
                           " | Type: " + ticketToBuy.getType() +
                           " | Price: " + ticketToBuy.getPrice() +
                           " | Event: " + selectedEvent.getName());
    }

    private void validateTicket() {
        System.out.println("\n=== Validate Ticket ===");

        if (tickets.isEmpty()) {
            System.out.println("No tickets available.");
            return;
        }

        int ticketId = readInt("Enter Ticket ID to validate: ");

        Ticket ticketToValidate = null;
        for (Ticket ticket : tickets) {
            if (ticket.getId() == ticketId) {
                ticketToValidate = ticket;
                break;
            }
        }

        if (ticketToValidate == null) {
            System.out.println("[ERROR] Ticket not found.");
            return;
        }

        if (!ticketToValidate.isSold()) {
            System.out.println("[ERROR] This ticket has not been sold yet.");
            return;
        }

        if (ticketToValidate.isValidated()) {
            System.out.println("[INFO] This ticket was already validated.");
            return;
        }

        ticketToValidate.isValidated();
        System.out.println("Ticket validated successfully! ");
    }
    
    private void viewMyHistory() {
        System.out.println("\n=== My Ticket History ===");

        boolean hasTickets = false;
        for (Ticket ticket : tickets) {
            if (ticket.isSold()) {
                System.out.println("Ticket ID: " + ticket.getId() +
                                   " | Event: " + ticket.getEvent().getName() +
                                   " | Type: " + ticket.getType() +
                                   " | Price: " + ticket.getPrice() +
                                   " | Validated: " + "Yes"/*(ticket.isValidated() ?  : "No")*/);
                hasTickets = true;
            }
        }

        if (!hasTickets) {
            System.out.println("No tickets purchased yet.");
        }
    }

    public static void main(String[] args) {
        EventMasterPro system = new EventMasterPro();
        system.start();
    }
}