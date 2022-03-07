package menu;

import api.AdminResource;
import api.HotelResource;
import exception.DuplicateEmailException;
import model.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

public class MainMenu extends Menu{

    public static void main(String[] args) {
        AdminResource.addRoom("100", 200.00, RoomType.SINGLE);
        AdminResource.addRoom("101", 200.00, RoomType.DOUBLE);
        AdminResource.addRoom("102", 200.00, RoomType.SINGLE);
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
            findAndReserveARoom();
        } else if (input.equals("2")) {
            System.out.println("Selected " + input);
        } else if (input.equals("3")) {
            System.out.println("Selected " + input);
            createAccount();
            startMenu();
        } else if (input.equals("4")) {
            System.out.println("Selected " + input);
            startAdminMenu();
        } else if (input.equals("5")) {
            closeMenu();
        } else {
           throw new IllegalArgumentException("Invalid Selection");
        }

    }

    public static void findAndReserveARoom() {
        if (HotelResource.getCurrentUser() == null) {
            System.out.println("Please Create An Account");
            createAccount();
        }

        Date checkIn = attemptToGetDateFromInput("Check in date");
        Date checkOut = attemptToGetDateFromInput("Check out date");
        Collection<IRoomInterface> bookableRooms = HotelResource.findARoom(checkIn, checkOut);
        if(bookableRooms.isEmpty()){
            System.out.println("No rooms available for selected date range, finding additional recommendations...");
            Calendar c = Calendar.getInstance();
            c.setTime(checkIn);
            c.add(Calendar.DATE, 7);

            c.setTime(checkOut);
            c.add(Calendar.DATE, 7);
            checkOut = c.getTime();
        }
        for (IRoomInterface room :
                bookableRooms) {
            System.out.println(room);
        }
        // select a room by room number
        // if room is invalid retry
        // reserve room using current user.
        String roomId = requireNonNullInput("Select a room:");
        IRoomInterface room = HotelResource.getRoom(roomId);
        Reservation reservation = HotelResource.bookARoom(HotelResource.getCurrentUser(), room, checkIn, checkOut);
        System.out.println(reservation);
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
            HotelResource.createCurrentUser(email, firstName, lastName);
        } catch (DuplicateEmailException ex){
            System.out.println(ex.getLocalizedMessage());
            attemptToCreateAccountWithUnvalidatedEmail(firstName, lastName);
        }
        Customer createdCustomer = HotelResource.getCustomer(email);
        System.out.println("Customer " + createdCustomer);
    }

    private static Date attemptToGetDateFromInput(String message){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date requestedDate = null;
        try {
            requestedDate = formatter.parse(requireNonNullInput(message + " (dd/mm/yyy):"));
        } catch (Exception ex){
            System.out.println("Please enter a vaild date");
            return attemptToGetDateFromInput(message);
        }

        return requestedDate;
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
