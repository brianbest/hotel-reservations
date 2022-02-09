package menu;

import api.AdminResource;
import api.HotelResource;
import model.Customer;
import model.RoomType;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu extends Menu{

    public static void main(String[] args) {
        startMenu();
    }

    public static void startMenu() {
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
        System.out.println("Main Menu");
        System.out.println("-------------------");
        System.out.println("1. Find and reserve a room");
        System.out.println("2. See my reservations");
        System.out.println("3. Create an account");
        System.out.println("4. Admin");
        System.out.println("5. Exit");
        System.out.println("-------------------");
    }

    public static void parseInput(String input) {
        if (input.equals("1")) {
            System.out.println("Selected " + input);
            startMenu();
        } else if (input.equals("2")) {
            System.out.println("Selected " + input);
        } else if (input.equals("3")) {
            System.out.println("Selected " + input);
            createAccount();
        } else if (input.equals("4")) {
            System.out.println("Selected " + input);
            startAdminMenu();
        } else if (input.equals("5")) {
            closeMenu();
        } else {
           throw new IllegalArgumentException("Invalid Selection");
        }

    }

    public void findAndReserveARoom() {

        // show all rooms
        // select a room
        // if room is invalid retry
        // search for a customer by email
        // if no customer found create customer
        //
    }

    public void seeMyReservations() {
        // get a customer
        // get all rooms for customer
        // display reservations
    }

    public static void createAccount(){
        String firstName = requireNonNullInput("First Name:");
        String lastName = requireNonNullInput("Last Name:");
        attemptToCreateAccountWithUnvalidatedEmail(firstName, lastName);
    }

    private static void attemptToCreateAccountWithUnvalidatedEmail(String firstName, String lastName) {
        String email = requireNonNullInput("Email:");
        try {
            HotelResource.createACustomer(email, firstName, lastName);
            Customer createdCustomer = HotelResource.getCustomer(email);
            System.out.println("Customer " + createdCustomer);
            startMenu();
        } catch (Exception ex){
            System.out.println("Please enter a vaild email");
            attemptToCreateAccountWithUnvalidatedEmail(firstName, lastName);
        }
    }

    public static void startAdminMenu() {

        // Start admin menu
        AdminMenu.startMenu();
    }

    public static String requireNonNullInput(String message) {
        System.out.println(message);
        String input = scanner.nextLine();
        if (input.length() == 0) {
            return requireNonNullInput(message);
        } else {
            return input;
        }
    }
}
