import React, { useState } from "react";
import axios from "axios";
import Header from "./../../components/Header/Header";
import BuyForm from "./../../components/BuyForm/BuyForm";
import TripObj from "./../../components/TripObject/Trip";
import TicketsCard from "./../../components/TicketsCard/TicketsCard";
import DBConnector from "./../../components/DBConnector/DBConnector";
import "./BuyTickets.scss";

function BuyTickets() {
  const baseURL = "http://localhost:8095/flight";
  const [trips, setTrips] = useState();
  axios
    .get(baseURL)
    .then((response) => {
      console.log(response);
      setTrips(response.data);
    })
    .catch((e) => {
      return e;
    });
  // const [trips, setTrips] = useState([
  //   new TripObj("Madrid", "Rome", "05/29/2023", "Volvo", 0, false, 1000),
  //   new TripObj("Rome", "Madrid", "12/15/2022", "Aeronapo", 2, true, 1000),
  //   new TripObj("Madrid", "Murcia", "12/29/2022", "Tranvia", 1, true, 20),
  // ]);

  const arrayTrips = [
    new TripObj("Madrid", "Rome", "05/29/2023", "Volvo", 0, false, 1000),
    new TripObj("Rome", "Madrid", "12/15/2022", "Aeronapo", 2, true, 1000),
    new TripObj("Madrid", "Murcia", "12/29/2022", "Tranvia", 1, true, 20),
  ];

  const setSearchParams = (field, params) => {
    let result;
    switch (field) {
      case "from":
        result = arrayTrips.filter((element) =>
          element.origin.includes(params)
        );
        setTrips(result);
        break;
      case "to":
        result = arrayTrips.filter((element) =>
          element.destination.includes(params)
        );
        setTrips(result);
        break;
      case "company":
        result = arrayTrips.filter((element) =>
          element.company.toLowerCase().includes(params)
        );
        setTrips(result);
        break;
      case "scales":
        switch (params) {
          case "zero":
            result = arrayTrips.filter((element) => element.scales == 0);
          case "one":
            result = arrayTrips.filter((element) => element.scales <= 1);
            break;
          default:
            result = arrayTrips;
            break;
        }
        break;
      case "date":
        result = arrayTrips.filter(
          (element) => params > new Date(element.date)
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
            key={index}
            origin={element.airline}
            destination={element.destination}
            date={element.date}
            company={element.company}
            scales={element.scales}
          />
        ))}
      </div>
    </div>
  );
}

export default BuyTickets;
