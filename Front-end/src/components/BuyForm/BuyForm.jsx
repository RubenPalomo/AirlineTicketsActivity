import React, { useState } from "react";
import "./BuyForm.scss";

function BuyForm() {
  const getDay = () => {
    const date = new Date(Date.now()).toLocaleDateString();
    let infoDate = date.split(" ");
    infoDate = infoDate[0].replaceAll("/", "-");

    return infoDate.substring(6) + "-" + infoDate.substring(0, 5);
  };
  const [newValue, setValue] = getDay();

  const we = () => console.log("we");

  return (
    <div className="container">
      <div className="form">
        <label for="company">I want to travel with </label>
        <select name="company" id="company">
          <option value="volvo">Volvo</option>
          <option value="saab">Saab</option>
          <option value="mercedes">Mercedes</option>
          <option value="audi">Audi</option>
        </select>
        <label for="scales"> company, making </label>
        <select name="scales" id="scales">
          <option value="zero">None</option>
          <option value="one">Only one</option>
          <option value="no-matter">Two or more</option>
        </select>
        <label for="luggage"> scales. I will travel with </label>
        <select name="luggage" id="luggage">
          <option value="no-luggage">None</option>
          <option value="luggage">Some</option>
        </select>
        <label for="luggage"> luggage the day: </label>
        {/* <input
          type="date"
          id="start"
          name="trip-start"
          value={getDay()}
          min="2022-01-01"
          max="2024-12-31"
          onChange={(newValue) => {
            setValue(newValue);
          }}
        /> */}
      </div>
    </div>
  );
}

export default BuyForm;
