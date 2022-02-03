package service;

import model.Customer;
import model.IRoomInterface;
import model.Reservation;

import java.util.Collection;
import java.util.Date;

public class ReservationService {

    public static Collection<Reservation> reservations;
    public static Collection<IRoomInterface> rooms;

    public static void addRoom(IRoomInterface room) {
        rooms.add(room);
    }

    public static Collection<IRoomInterface> getRooms() {
        return rooms;
    }

    public static Collection<Reservation> getReservations() {
        return reservations;
    }

    public static IRoomInterface getARoom(String roomId){
        return null;
    }

    public static Reservation reserveARoom(Customer customer, IRoomInterface room, Date checkInDate, Date checkOutDate){
        return null;
    }

    public static Collection<IRoomInterface> findRooms(Date checkInDate, Date checkOutDate){
        return null;
    }

    public static Collection<Reservation> getCustomerReservation(Customer customer){
        return null;
    }
}
