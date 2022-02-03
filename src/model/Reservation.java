package model;

import java.util.Date;

public class Reservation {
    private Customer customer;
    private IRoomInterface room;
    private Date checkInDate;
    private Date checkOutDate;

    public Reservation(Customer customer, IRoomInterface room, Date checkInDate, Date checkOutDate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
        return "Room " + room.getRoomNumber() + " reserved by " + customer.getFullName() + " in: " + checkInDate + " out: " + checkOutDate;
    }
}
