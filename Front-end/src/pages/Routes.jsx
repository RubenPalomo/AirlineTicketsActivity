import React, { useState } from "react";
import { BrowserRouter, useRoutes } from "react-router-dom";
import Login from "./Login/Login";
import Home from "./Home/Home";
import User from "./User/User";
import MyTrips from "./MyTrips/MyTrips";
import BuyTickets from "./BuyTickets/BuyTickets";
import Settings from "./Settings/Settings";
import NotFound from "./NotFound/NotFound";

function Body() {
  const App = () => {
    let routes = useRoutes([
      { path: "/", element: <Login /> },
      { path: "/login", element: <Login /> },
      {
        path: "/home",
        element: <Home />,
      },
      {
        path: "/user",
        element: <User />,
      },
      {
        path: "/trips",
        element: <MyTrips />,
      },
      {
        path: "/tickets",
        element: <BuyTickets />,
      },
      {
        path: "/settings",
        element: <Settings />,
      },
      { path: "*", element: <NotFound /> },
    ]);

    return routes;
  };
  return (
    <BrowserRouter>
      <App />
    </BrowserRouter>
  );
}

export default Body;
