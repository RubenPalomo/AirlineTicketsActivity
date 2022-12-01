import React, { useState, useEffect } from "react";
import axios from "axios";
import Header from "./../../components/Header/Header";
import BuyForm from "./../../components/BuyForm/BuyForm";
// import TripObj from "./../../components/TripObject/Trip";
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
    if (date == null) return "Unknown";
    return date.toString().substring(0, 10);
  };
  const refresh = (url) => {
    axios.get(url).then((response) => {
      console.log(response);
      setTrips(response.data);
    });
  };

  if (trips == undefined) return;

  return (
    <div className="buyTicketsContainer">
      <Header />
      <div>
        <h1 className="title">Buy Tickets</h1>
      </div>
      <div>
        <BuyForm refresh={refresh} />
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
