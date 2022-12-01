import React from "react";
import Header from "./../../components/Header/Header";
import TripsCard from "../../components/TripsCard/TripsCard";
import TripObj from "./../../components/TripObject/Trip";
import "./MyTrips.scss";

function MyTrips() {
  const trips = [
    new TripObj("Madrid", "Rome", "11/31/2022", "Airbus", 0, false, 1000),
    new TripObj("Rome", "Madrid", "12/15/2022", "Aeronapo", 1, true, 1000),
    new TripObj("Madrid", "Murcia", "12/29/2022", "Tranvia", 1, true, 20),
  ];
  return (
    <div>
      <Header />
      <h1 className="title">My Trips</h1>
      <div className="scroll">
        {trips.map((element, index) => (
          <TripsCard
            key={index}
            origin={element.origin}
            destination={element.destination}
            date={element.date}
            company={element.company}
            scales={element.scales}
            luggage={element.luggage}
            price={element.price}
          />
        ))}
      </div>
    </div>
  );
}

export default MyTrips;
