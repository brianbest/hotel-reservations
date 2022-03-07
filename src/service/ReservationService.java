package service;

import model.*;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

public class ReservationService {

    public static Collection<Reservation> reservations = new HashSet<Reservation>();
    public static Collection<IRoomInterface> rooms = new HashSet<IRoomInterface>();

    public static Room addRoom(String roomNumber, Double price, RoomType roomTypeEnum) {
        Room newRoom = new FreeRoom(roomNumber,price,roomTypeEnum);
        rooms.add(newRoom);
        return newRoom;
    }

    public static Collection<IRoomInterface> getRooms() {
        return rooms;
    }

    public static Collection<Reservation> getReservations() {
        return reservations;
    }

    public static IRoomInterface getARoom(String roomNumber){
        IRoomInterface selectedRoom = null;
        for (IRoomInterface room : rooms) {
            if (room.getRoomNumber().equals(roomNumber)) {
                selectedRoom = room;
            }
        }
        return selectedRoom;
    }

    public static Reservation reserveARoom(Customer customer, IRoomInterface room, Date checkInDate, Date checkOutDate){
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        reservations.add(reservation);
        return reservation;
    }

    public static Collection<IRoomInterface> findRooms(Date checkInDate, Date checkOutDate) {
        return rooms;
    }

    public static Collection<Reservation> getCustomerReservation(Customer customer){
        return null;
    }
}
