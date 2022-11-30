import React, { useState } from "react";
import "./BuyForm.scss";
import "./../../pages/BuyTickets/BuyTickets";
import BuyTickets from "./../../pages/BuyTickets/BuyTickets";

function BuyForm(props) {
  const formatDate = (date) => {
    let ye = new Intl.DateTimeFormat("en", { year: "numeric" }).format(date);
    let mo = new Intl.DateTimeFormat("en", { month: "2-digit" }).format(date);
    let da = new Intl.DateTimeFormat("en", { day: "2-digit" }).format(date);
    return `${ye}-${mo}-${da}`;
  };

  const getDay = () => {
    return new Date(Date.now());
  };
  const [newValue, setValue] = useState(formatDate(getDay()));
  const search = props.setSearchParams;

  return (
    <div>
      <div className="form">
        <label for="company">I want to travel from </label>
        <input
          type="text"
          id="from"
          name="from"
          onChange={(e) => {
            search("from", e.target.value);
          }}
        />
        <label for="to"> to </label>
        <input
          type="text"
          id="to"
          name="to"
          onChange={(e) => {
            search("to", e.target.value);
          }}
        />
        <label for="company"> with </label>
        <select
          name="company"
          id="company"
          onChange={(e) => {
            search("company", e.target.value);
          }}
        >
          <option value="">Select</option>
          <option value="volvo">Volvo</option>
          <option value="saab">Saab</option>
          <option value="mercedes">Mercedes</option>
          <option value="audi">Audi</option>
        </select>
        <label for="scales"> company, making </label>
        <select
          name="scales"
          id="scales"
          onChange={(e) => {
            search("scales", e.target.value);
          }}
        >
          <option value="">Select</option>
          <option value="zero">None</option>
          <option value="one">One or less</option>
          <option value="no-matter">I don't matter</option>
        </select>
        <label for="start"> scales. I will travel the day: </label>
        <input
          type="date"
          id="start"
          name="trip-start"
          value={newValue}
          min="2022-01-01"
          max="2024-12-31"
          onChange={(e) => {
            const newDate = new Date(e.target.value);
            if (newDate >= getDay()) {
              setValue(formatDate(newDate));
              search("date", newDate);
            }
          }}
        />
      </div>
    </div>
  );
}

export default BuyForm;
