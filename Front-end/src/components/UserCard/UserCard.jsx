import React, { useState } from "react";
import "./UserCard.scss";
import TableElement from "./TableElement/TableElement";

function UserCard(props) {
  // const [user, setUser] = useState();
  const user = props.user;
  // setUser();

  return (
    <div className="containerUserTable">
      <table className="table">
        <tbody>
          <TableElement
            element="User:"
            data={user.firstName + " " + user.lastName}
          />
          <TableElement element="DNI/Passport:" data={user.document} />
          <TableElement element="Nacionality:" data={"Italiani"} />
          <TableElement element="Age:" data={user.age} />
        </tbody>
      </table>
    </div>
  );
}

export default UserCard;
