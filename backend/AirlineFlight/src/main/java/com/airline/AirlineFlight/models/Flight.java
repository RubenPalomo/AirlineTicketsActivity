package com.airline.AirlineFlight.models;

import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("flights")
public class Flight {
    @Id
    private String flightId;
    @Field
    private String departure;
    @Field
    private String destination;
    @Field
    private String airline;
    @Field
    private Date departureDate;
    @Field
    private int transiteMinutes;
    @Field
    private int layovers;
    @Field
    private String luggages;
    @Field
    private int price;

    public Flight() {

    }

    public Flight(String flightId, String airline, String departure, String destination, Date departureDate,
            int transiteMinutes, int layovers,
            String luggages,
            int price) {
        setFlightId(flightId);
        setAirline(airline);
        setDeparture(departure);
        setDestination(destination);
        setDepartureDate(departureDate);
        setTransiteMinutes(transiteMinutes);
        setLayovers(layovers);
        setLuggages(luggages);
        setPrice(price);
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId.toLowerCase();
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure.toLowerCase();
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination.toLowerCase();
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline.toLowerCase();
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
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

    public String getLuggages() {
        return luggages;
    }

    public void setLuggages(String luggages) {
        this.luggages = luggages;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flight [flightId=" + flightId + ", departure=" + departure + ", destination=" + destination
                + ", airline=" + airline + ", departureDate=" + departureDate + ", transiteMinutes=" + transiteMinutes
                + ", layovers=" + layovers + ", luggages=" + luggages + ", price=" + price + "]";
    }
}
