package api;

import model.*;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.List;

public class AdminResource {

    public static Customer getCustomer(String email) {
        return CustomerService.getCustomer(email);
    }
    
    public static Room addRoom(String roomNumber, Double price, RoomType roomTypeEnum){
        return ReservationService.addRoom(roomNumber, price, roomTypeEnum);
    }

    public static Collection<IRoomInterface> getAllRooms() {
        return ReservationService.getRooms();
    }

    public static Collection<Customer> getAllCustomers() {
        return CustomerService.getAllCustomers();
    }

    public void displayAllReservations() {
        for (Reservation reservation :
                ReservationService.getReservations()) {
            System.out.println(reservation);
        }
    }
}
