import React, { useState } from "react";
import "./UserCard.scss";
import TableElement from "./TableElement/TableElement";

function UserCard(props) {
  const [user, setUser] = useState();

  setUser(props.user);

  return (
    <div className="containerUserTable">
      <table className="table">
        <tbody>
          <TableElement element="User:" data={user} />
          <TableElement element="DNI/Passport:" data={user} />
          <TableElement element="Nacionality:" data={"Italiani"} />
          <TableElement element="Age:" data={user} />
        </tbody>
      </table>
    </div>
  );
}

export default UserCard;
