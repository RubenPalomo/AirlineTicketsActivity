import React, { useState, useEffect } from "react";
// import { Navigate } from "react-router-dom";
import axios from "axios";
import Header from "./../../components/Header/Header";
import UserCard from "./../../components/UserCard/UserCard";
import "./User.scss";

function User() {
  const [user, setUser] = useState();
  const userIdentification = "CA11338EF";
  const baseURL = `http://localhost:8094/user/${userIdentification}`;
  useEffect(() => {
    axios.get(baseURL).then((response) => {
      setUser(response.data);
    });
  }, []);

  console.log(user);
  if (user === null) return null;
  if (user === undefined) return null;

  return (
    <div>
      <Header />
      <h1 className="title">User Information</h1>
      <UserCard user={user} />
    </div>
  );
}

export default User;
