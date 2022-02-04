package menu;

import api.AdminResource;
import model.Customer;

import java.util.Collection;
import java.util.Scanner;

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
        if (input.equals("1")) {
            System.out.println("Selected " + input);
            displayAllCustomers();
        } else if (input.equals("2")) {
            System.out.println("Selected " + input);
        } else if (input.equals("3")) {
            System.out.println("Selected " + input);
        } else if (input.equals("4")) {
            System.out.println("Selected " + input);
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
        startMenu();
    }

    public static void addARoom() {
        
    }

    public static void startMainMenu() {
        // Start admin menu
        MainMenu.startMenu();
    }
}
