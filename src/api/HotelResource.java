package api;

import exception.DuplicateEmailException;
import model.Customer;
import model.IRoomInterface;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.stream.Collectors;

public class HotelResource {
    public static Customer getCustomer(String email){
        return CustomerService.getCustomer(email);
    }

    public static void createACustomer(String email, String firstName, String lastName) throws DuplicateEmailException {
        try {
            CustomerService.addCustomer(email, firstName, lastName);
        } catch (DuplicateEmailException ex) {
            throw ex;
        }
    }

    public static IRoomInterface getRoom(String roomNumber) {
        return ReservationService.getARoom(roomNumber);
    }

    public static Reservation bookARoom(Customer customer, IRoomInterface room, Date checkInDate, Date checkOutDate){
        return ReservationService.reserveARoom(customer, room, checkInDate,checkOutDate);
    }

    public static Collection<Reservation> getCurrentCustomersReservations(){
        Customer currentUser = CustomerService.getCurrentUser();
        Collection<Reservation> reservations = ReservationService.getReservations();
        return reservations.stream()
                .filter(reservation -> reservation.getCustomer().getEmail().equals(currentUser.getEmail()))
                .collect(Collectors.toCollection(HashSet::new));

    }

    public static Collection<IRoomInterface> findARoom(Date checkIn, Date checkOut){
        return ReservationService.findRooms(checkIn,checkOut);
    }

    public static void createCurrentUser(String email, String firstName, String lastName) throws DuplicateEmailException {
        try {
            HotelResource.createACustomer(email, firstName, lastName);
        } catch (DuplicateEmailException ex) {
            throw ex;
        }

        CustomerService.setCurrentUserCurrentUser(CustomerService.getCustomer(email));
    }

    public static Customer getCurrentUser(){
        return CustomerService.getCurrentUser();
    }
}
