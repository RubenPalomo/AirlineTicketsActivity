import React, { useState } from "react";
import { Navigate } from "react-router-dom";
import "./BuyForm.scss";
import "./../../pages/BuyTickets/BuyTickets";

function BuyForm(props) {
  const refresh = props.refresh;
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
  const handleSubmit = (event) => {
    event.preventDefault();
    let url =
      "http://localhost:8095/flight/?" +
      "departure=" +
      event.target[0].value +
      "&" +
      "destination=" +
      event.target[1].value +
      "&" +
      "airline=" +
      event.target[2].value;

    if (url.substring(url.length - 1) == "=")
      url = url.substring(0, url.length - 1);

    refresh(url);
  };

  return (
    <div>
      <div className="form">
        <form onSubmit={handleSubmit}>
          <label for="company">I want to travel from </label>
          <input type="text" id="from" name="from" />
          <label for="to"> to </label>
          <input type="text" id="to" name="to" />
          <label for="company"> with </label>
          <select name="company" id="company">
            <option value="">Select</option>
            <option value="aireuropa">AirEuropa</option>
            <option value="ryanair">RyanAir</option>
            <option value="volvo">Volvo</option>
            <option value="audi">Audi</option>
          </select>
          <label for="scales"> company, making </label>
          <select name="scales" id="scales">
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
              }
            }}
          />
          <button>Search</button>
        </form>
      </div>
    </div>
  );
}

export default BuyForm;
