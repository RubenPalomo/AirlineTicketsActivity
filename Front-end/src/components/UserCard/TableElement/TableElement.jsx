import React, { useState } from "react";

function TableElement(props) {
  return (
    <tr>
      <td>
        <strong>{props.element}</strong>
      </td>
      <td>{props.data}</td>
    </tr>
  );
}

export default TableElement;
