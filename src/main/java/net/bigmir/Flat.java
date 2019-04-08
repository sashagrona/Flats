package net.bigmir;

import java.util.concurrent.atomic.AtomicInteger;

public class Flat {
    private int id;
    private String region;
    private String address;
    private double square;
    private int rooms;
    private double price;

    public Flat(String region, String address, double square, int rooms, double price) {
        this.region = region;
        this.address = address;
        this.square = square;
        this.rooms = rooms;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Flat() {
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "id=" + id +
                ", region='" + region + '\'' +
                ", address='" + address + '\'' +
                ", square=" + square +
                ", rooms=" + rooms +
                ", price=" + price +
                '}';
    }
}
