package com.airline.AirlineFlight.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("flights")
public class Flight {
    @Id
    private String flightId;
    @Field
    private String start;
    @Field
    private String destination;
    @Field
    private String airline;
    @Field
    private Date departure;
    @Field
    private int transiteMinutes;
    @Field
    private int layovers;
    @Field
    private int luggagesPrice;
    @Field
    private int price;

    public Flight() {

    }

    public Flight(String flightId, String airline, Date departure, int transiteMinutes, int layovers,
            int luggagesPrice,
            int price) {
        setFlightId(flightId);
        setAirline(airline);
        setDeparture(departure);
        setTransiteMinutes(transiteMinutes);
        setLayovers(layovers);
        setLuggagesPrice(luggagesPrice);
        setPrice(price);
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
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

    @Override
    public String toString() {
        return "Flight [flightId=" + flightId + ", start=" + start + ", destination=" + destination + ", airline="
                + airline + ", departure=" + departure + ", transiteMinutes=" + transiteMinutes + ", layovers="
                + layovers + ", luggagesPrice=" + luggagesPrice + ", price=" + price + "]";
    }

}
