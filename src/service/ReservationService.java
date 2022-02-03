package service;

import model.Customer;
import model.IRoomInterface;
import model.Reservation;

import java.util.Collection;
import java.util.Date;

public class ReservationService {

    public static Collection<Reservation> reservations;

    public void addRoom(IRoomInterface room){

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
