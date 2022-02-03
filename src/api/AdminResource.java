package api;

import model.Customer;
import model.IRoomInterface;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.List;

public class AdminResource {

    public static Customer getCustomer(String email) {
        return CustomerService.getCustomer(email);
    }
    
    public static void addRoom(List<IRoomInterface> rooms){
        for (IRoomInterface room :
                rooms) {
            ReservationService.addRoom(room);
        }
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
