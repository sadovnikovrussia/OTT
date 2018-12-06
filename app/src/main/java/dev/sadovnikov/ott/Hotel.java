package dev.sadovnikov.ott;

import android.support.annotation.NonNull;

import java.util.ArrayList;

public class Hotel {
    private long id;
    private ArrayList<Long> flightsIds;
    private String name;
    private Long price;

    Hotel(long id, ArrayList<Long> flightsIds, String name, long price) {
        this.id = id;
        this.flightsIds = flightsIds;
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public ArrayList<Long> getFlightsIds() {
        return flightsIds;
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }

    @NonNull
    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", flightsIds=" + flightsIds +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
