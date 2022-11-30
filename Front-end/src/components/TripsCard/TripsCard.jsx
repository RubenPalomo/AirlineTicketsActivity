import React, { useState } from "react";
import TableElement from "../UserCard/TableElement/TableElement";
import "./TripsCard.scss";

function TripsCard(props) {
  const luggage = props.luggage ? "Yes" : "No";

  return (
    <div className="tripContainer">
      <table className="tripTable">
        <tbody>
          <TableElement element="Origin: " data={props.origin} />
          <TableElement element="Destination: " data={props.destination} />
          <TableElement element="Date: " data={props.date} />
          <TableElement element="Company: " data={props.company} />
          <TableElement element="Scales: " data={props.scales} />
          <TableElement element="Luggage: " data={luggage} />
          <TableElement element="Price: " data={props.price} />
        </tbody>
      </table>
    </div>
  );
}

export default TripsCard;
