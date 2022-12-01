import React, { useState } from "react";
import { Routes, Route } from "react-router-dom";
import Login from "./Login/Login";
import Home from "./Home/Home";
import User from "./User/User";
import MyTrips from "./MyTrips/MyTrips";
import BuyTickets from "./BuyTickets/BuyTickets";
import Settings from "./Settings/Settings";
import NotFound from "./NotFound/NotFound";

function Body() {
  return (
    <Routes>
      <Route path="/" element={<Login />}></Route>
      <Route path="/login" element={<Login />}></Route>
      <Route path="/home" element={<Home />}></Route>
      <Route path="/user" element={<User />}></Route>
      <Route path="/trips" element={<MyTrips />}></Route>
      <Route path="/tickets" element={<BuyTickets />}></Route>
      <Route path="/settings" element={<Settings />}></Route>
      <Route path="*" element={<NotFound />}></Route>
    </Routes>
  );
}

export default Body;
