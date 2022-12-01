import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import Input from "../Input/Input";
import "./LoginForm.scss";

function LoginForm() {
  const [fieldsComplete, setfieldsComplete] = useState(false);
  const [fieldsIncorrect, setFieldsIncorrect] = useState(false);
  const navigate = useNavigate();
  const baseURL = "http://localhost:8094/user/";

  function tryLogin(user, password) {
    let i = 0;
    var ok = false;
    axios.get(baseURL + user).then((response) => {
      console.log(response.data);
      if (response.data.success && response.data.data.includes(password))
        navigate("/user", { replace: true });
    });
  }

  async function handleSubmit(event) {
    event.preventDefault();
    const login = event.target[0].value;
    const password = event.target[1].value;

    if (login == "" || password == "") {
      setfieldsComplete(true);
      setFieldsIncorrect(false);
    } else {
      setfieldsComplete(false);
      tryLogin(login, password);
      await new Promise((r) => setTimeout(r, 50));
      setFieldsIncorrect(true);
    }
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
      <label className="invalid" hidden={!fieldsIncorrect}>
        (!) User or password incorrect
      </label>
    </div>
  );
}

export default LoginForm;
