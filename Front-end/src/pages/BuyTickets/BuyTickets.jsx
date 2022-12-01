import React, { useState, useEffect } from "react";
import axios from "axios";
import Header from "./../../components/Header/Header";
import BuyForm from "./../../components/BuyForm/BuyForm";
import TripObj from "./../../components/TripObject/Trip";
import TicketsCard from "./../../components/TicketsCard/TicketsCard";
import "./BuyTickets.scss";

function BuyTickets() {
  const baseURL = "http://localhost:8095/flight";
  const [trips, setTrips] = useState();

  useEffect(() => {
    axios.get(baseURL).then((response) => {
      setTrips(response.data);
    });
  }, []);

  const formatDate = (date) => {
    console.log(date);
    if (date == null) return "Unknown";
    return date.toString().substring(0, 10);
  };

  const setSearchParams = (field, params) => {
    let result;
    switch (field) {
      case "from":
        result = trips.filter((element) => element.departure.includes(params));
        setTrips(result);
        break;
      case "to":
        result = trips.filter((element) =>
          element.destination.includes(params)
        );
        setTrips(result);
        break;
      case "company":
        result = trips.filter((element) =>
          element.airline.toLowerCase().includes(params)
        );
        setTrips(result);
        break;
      case "scales":
        switch (params) {
          case "zero":
            result = trips.filter((element) => element.layovers == 0);
          case "one":
            result = trips.filter((element) => element.layovers <= 1);
            break;
          default:
            result = trips;
            break;
        }
        break;
      case "date":
        result = trips.filter(
          (element) => params > new Date(element.departureDate)
        );
        setTrips(result);
        break;
    }
  };

  if (trips == undefined) return;

  return (
    <div className="buyTicketsContainer">
      <Header />
      <div>
        <h1 className="title">Buy Tickets</h1>
      </div>
      <div>
        <BuyForm setSearchParams={setSearchParams} />
      </div>
      <div className="scrollTickets">
        {trips.map((element, index) => (
          <TicketsCard
            key={element.flightId}
            origin={element.departure}
            destination={element.destination}
            date={formatDate(element.departureDate)}
            company={element.airline}
            scales={element.layovers}
          />
        ))}
      </div>
    </div>
  );
}

export default BuyTickets;
