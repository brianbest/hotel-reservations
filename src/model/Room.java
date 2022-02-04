package model;

public class Room implements IRoomInterface{
    private String roomNumber;
    protected Double price;
    private RoomType roomTypeEnum;

    public Room(String roomNumber, Double price, RoomType roomTypeEnum) {
        this.roomTypeEnum = roomTypeEnum;
        this.roomNumber = roomNumber;
        this.price = price;
    }

    @Override
    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public Double getRoomPrice() {
        return price;
    }

    @Override
    public RoomType getRoomType() {
        return roomTypeEnum;
    }

    @Override
    public boolean isFree() {
        return false;
    }

    @Override
    public String toString(){
        return "Room Price: " + price + " Room Number: " + roomNumber + " type: " + roomTypeEnum;
    }
}
