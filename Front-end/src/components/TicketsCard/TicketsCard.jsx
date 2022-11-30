import React, { useState } from "react";
import "./TicketsCard.scss";

function TicketsCard(props) {
  return (
    <div className="ticketCard">
      <table className="ticketsTable">
        <tbody>
          <tr>
            <td>
              <strong>From</strong>
            </td>
            <td>
              <strong>Destination</strong>
            </td>
            <td>
              <strong>Company</strong>
            </td>
            <td>
              <strong>Scales</strong>
            </td>
            <td>
              <strong>Date</strong>
            </td>
            <td>
              <strong>Luggary</strong>
            </td>
          </tr>
          <tr>
            <td>{props.origin}</td>
            <td>{props.destination}</td>
            <td>{props.company}</td>
            <td>{props.scales}</td>
            <td>{props.date}</td>
            <td className="luggaryBtn">
              <input id="luggary" name="luggary" type="checkbox" />
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  );
}

export default TicketsCard;
