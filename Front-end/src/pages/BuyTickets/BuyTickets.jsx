import React from "react";
import Header from "./../../components/Header/Header";
import BuyForm from "./../../components/BuyForm/BuyForm";
import earth from "./../../assets/earth.png";
import "./BuyTickets.scss";

function BuyTickets() {
  return (
    <div>
      <Header />
      <div>
        <h1 className="title">Buy Tickets</h1>
      </div>
      <div>
        <BuyForm />
      </div>
      <div className="img">
        <img src={earth} />
      </div>
    </div>
  );
}

export default BuyTickets;
