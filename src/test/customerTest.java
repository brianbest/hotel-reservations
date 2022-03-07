package test;

import api.HotelResource;
import menu.AdminMenu;
import model.Customer;
import model.IRoomInterface;
import model.Room;
import model.RoomType;
import service.ReservationService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class customerTest {
    //public static ReservationService reservationService = new ReservationService();
    public static void main(String[] args) {
        //makeAReservation();
        getARoom();
//        assertThatCustomerBuilds();
//        assertThatCustomerWillThrowOnInvalidEmail();
//        assertThatTestDataWillAppear();
    }

    public static void assertThatCustomerBuilds() {
        Customer customer = new Customer("Jon", "Doe", "j@doe.com");
        System.out.println(customer);
    }

    public static void assertThatCustomerWillThrowOnInvalidEmail() {
        try{
            Customer customer = new Customer("Jon", "Doe", "INVALID");
        } catch (IllegalArgumentException ex){
            System.out.println("Worked: " + ex.getLocalizedMessage());
        }
    }

    public static void assertThatTestDataWillAppear(){
        AdminMenu.createTestData();
        AdminMenu.displayAllRooms();
        AdminMenu.displayAllCustomers();
    }

    public static void makeAReservation() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date checkin = null;
        Date checkout = null;
        try {
            checkin = formatter.parse("05/05/2020");
            checkout = formatter.parse("06/05/2020");

        } catch (Exception ex) {

        }

        Customer customer = new Customer("Jon", "Doe", "j@doe.com");
        Room newRoom = ReservationService.addRoom("101", 100.00, RoomType.SINGLE);
        System.out.println(ReservationService.reserveARoom(customer, newRoom, checkin, checkout));

    }

    public static void getARoom() {
        ReservationService.addRoom("101", 100.00, RoomType.SINGLE);
        IRoomInterface room = HotelResource.getRoom("101");

        System.out.println(room);

    }
}
