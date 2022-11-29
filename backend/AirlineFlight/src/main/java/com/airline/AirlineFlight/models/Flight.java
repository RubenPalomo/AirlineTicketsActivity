package com.airline.AirlineFlight.models;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("flight")
public class Flight {
    protected String name;
    protected String airline;
    protected Date departure;
    protected int transiteMinutes;
    protected int layovers;
    protected int luggagesPrice;
    protected int price;

    public Flight() {

    }

    public Flight(String name, String airline, Date departure, int transiteMinutes, int layovers,
            int luggagesPrice,
            int price) {
        this.name = name;
        this.airline = airline;
        this.departure = departure;
        this.transiteMinutes = transiteMinutes;
        this.layovers = layovers;
        this.luggagesPrice = luggagesPrice;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public int getTransiteMinutes() {
        return transiteMinutes;
    }

    public void setTransiteMinutes(int transiteMinutes) {
        this.transiteMinutes = transiteMinutes;
    }

    public int getLayovers() {
        return layovers;
    }

    public void setLayovers(int layovers) {
        this.layovers = layovers;
    }

    public int getLuggagesPrice() {
        return luggagesPrice;
    }

    public void setLuggagesPrice(int luggagesPrice) {
        this.luggagesPrice = luggagesPrice;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
