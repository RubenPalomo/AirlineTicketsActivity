import React, { useState } from "react";
import "./UserCard.scss";
import TableElement from "./TableElement/TableElement";

function UserCard() {
  const user = "Pepito";
  const dni = "12345678-A";
  const nacionality = "Spanish";
  const age = 22;

  return (
    <div className="containerUserTable">
      <table className="table">
        <tbody>
          <TableElement element="User:" data={user} />
          <TableElement element="DNI/Passport:" data={dni} />
          <TableElement element="Nacionality:" data={nacionality} />
          <TableElement element="Age:" data={age} />
        </tbody>
      </table>
    </div>
  );
}

export default UserCard;
