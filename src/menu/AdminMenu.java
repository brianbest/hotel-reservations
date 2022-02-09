package menu;

import api.AdminResource;
import api.HotelResource;
import model.Customer;
import model.IRoomInterface;
import model.Room;
import model.RoomType;

import java.util.Collection;
import java.util.Scanner;

import static menu.Menu.requireNonNullInput;

public class AdminMenu {
    private static Scanner scanner = new Scanner(System.in);

//    public static void main(String[] args) {
//        startMenu();
//    }

    public static void startMenu(){
        try {
            displayMainMenu();
            String userInput = scanner.nextLine();
            parseInput(userInput);
        } catch (Exception ex){

            ex.getLocalizedMessage();
            startMenu();
        }
    }

    public static void closeMenu() {
        scanner.close();
    }

    public static void displayMainMenu() {
        System.out.println("Admin Menu");
        System.out.println("-------------------");
        System.out.println("1. See all Customers");
        System.out.println("2. See all Rooms");
        System.out.println("3. See All Reservations");
        System.out.println("4. Add a Room");
        System.out.println("5. Back To Main Menu");
        System.out.println("-------------------");
    }

    public static void parseInput(String input) {
        System.out.println("Selected " + input);
        if (input.equals("1")) {
            displayAllCustomers();
            startMenu();
        } else if (input.equals("2")) {
            displayAllRooms();
            startMenu();
        } else if (input.equals("3")) {

        } else if (input.equals("4")) {
            addARoom();
        } else if (input.equals("5")) {
            startMainMenu();
        } else {
            throw new IllegalArgumentException("Invalid Selection");
        }
    }

    public static void displayAllCustomers() {
        Collection<Customer> allCustomers = AdminResource.getAllCustomers();
        for (Customer customer :
                allCustomers) {
            System.out.println(customer);
        }
    }

    public static void displayAllRooms() {
        Collection<IRoomInterface> allRooms = AdminResource.getAllRooms();
        for (IRoomInterface room :
                allRooms) {
            System.out.println(room);
        }
    }

    public static void addARoom() {
        String roomNumber = requireNonNullInput("Room Number");
        Double price = getDoubleFromUserInput("Room Price");

        RoomType roomTypeEnum = getRoomTypeFromUserInput();
        Room createdRoom = null;
        try {
            createdRoom = AdminResource.addRoom(roomNumber, price, roomTypeEnum);
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }

        System.out.println("CREATED: " + createdRoom);
        startMenu();
    }

    public static void startMainMenu() {
        // Start admin menu
        MainMenu.startMenu();
    }

    private static Double getDoubleFromUserInput(String message){
        String userInput = requireNonNullInput(message);
        Double price;
        try {
            price = Double.parseDouble(userInput);
            return price;
        } catch (Exception ex) {
            System.out.println("Please enter a valid price");
            return getDoubleFromUserInput(message);
        }
    }

    private static RoomType getRoomTypeFromUserInput(){
        String userInput = requireNonNullInput("Select Room Type: 1 - Single, 2 - Double");
        int selection;
        try {
            selection = Integer.parseInt(userInput);
            if (selection == 1) {
                return RoomType.SINGLE;
            } else if (selection == 2) {
                return RoomType.DOUBLE;
            } else {
                System.out.println("Please enter a valid Room Type");
                return getRoomTypeFromUserInput();
            }
        } catch (Exception ex) {
            System.out.println("Please enter a valid Room Type");
            return getRoomTypeFromUserInput();
        }
    }

    public static void createTestData() {
        AdminResource.addRoom("1", 2.0, RoomType.SINGLE);
        AdminResource.addRoom("2", 2.0, RoomType.SINGLE);
        AdminResource.addRoom("3", 2.0, RoomType.SINGLE);
        AdminResource.addRoom("4", 2.0, RoomType.SINGLE);
        AdminResource.addRoom("5", 2.0, RoomType.SINGLE);
        AdminResource.addRoom("6", 2.0, RoomType.SINGLE);

        HotelResource.createACustomer("name@email.com", "Frank", "Stone");
        HotelResource.createACustomer("1name@email.com", "Anni", "Pebble");
        HotelResource.createACustomer("2name@email.com", "Alex", "Bolder");
    }
}
