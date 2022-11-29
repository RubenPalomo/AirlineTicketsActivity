import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import Input from "../Input/Input";
import "./LoginForm.scss";

function LoginForm(props) {
  const [fieldsComplete, setfieldsComplete] = useState(false);
  const navigate = useNavigate();
  function handleSubmit(event) {
    const login = event.target[0].value;
    const password = event.target[1].value;

    if (login == "" || password == "") {
      setfieldsComplete(true);
    } else {
      alert("Make code to send form to Database");
      navigate("/home", { replace: true });
    }

    event.preventDefault();
  }

  return (
    <div>
      <form className="mainForm" action="/signup" onSubmit={handleSubmit}>
        <Input type="text" name="Login *"></Input>
        <Input type="password" name="Password *"></Input>

        <input className="submitBtn" type="submit" value="Sign up" />
      </form>
      <label className="invalid" hidden={!fieldsComplete}>
        (!) All the fields are requiered
      </label>
    </div>
  );
}

export default LoginForm;
