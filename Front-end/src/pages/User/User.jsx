import React from "react";
import Header from "./../../components/Header/Header";
import UserCard from "./../../components/UserCard/UserCard";
import "./User.scss";

function User() {
  return (
    <div>
      <Header />
      <h1 className="title">User Information</h1>
      <UserCard />
    </div>
  );
}

export default User;
