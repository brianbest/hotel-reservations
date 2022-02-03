package api;

import model.Customer;
import model.IRoomInterface;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;

public class HotelResource {
    public static Customer getCustomer(String email){
        return CustomerService.getCustomer(email);
    }

    public static void createACustomer(String email, String firstName, String lastName) {
        CustomerService.addCustomer(email, firstName, lastName);
    }

    public static IRoomInterface getRoom(String roomNumber) {
        return ReservationService.getARoom(roomNumber);
    }

    public static Reservation bookARoom(String customerEmail, IRoomInterface room, Date checkInDate, Date checkOutDate){
        Customer foundCustomer = CustomerService.getCustomer(customerEmail);
        return ReservationService.reserveARoom(foundCustomer, room, checkInDate,checkOutDate);
    }

    public static Collection<Reservation> getCustomersReservations(String customerEmail){
        Customer foundCustomer = CustomerService.getCustomer(customerEmail);
        return ReservationService.getCustomerReservation(foundCustomer);
    }

    public static Collection<IRoomInterface> findARoom(Date checkIn, Date checkOut){
        return ReservationService.findRooms(checkIn,checkOut);
    }
}
