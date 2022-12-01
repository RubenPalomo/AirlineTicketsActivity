import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import Input from "../Input/Input";
import "./LoginForm.scss";

function LoginForm() {
  const [fieldsComplete, setfieldsComplete] = useState(false);
  const [isLogged, setIsLogged] = useState(false);
  const navigate = useNavigate();
  const baseURL = "http://localhost:8094/user";

  async function tryLogin(user, password) {
    let i = 0;
    var ok = false;
    await axios.get(baseURL).then((response) => {
      while (true) {
        if (
          response.data[i] != undefined &&
          user == response.data[i].document &&
          password == response.data[i].lastName
        ) {
          ok = true;
          break;
        }
        if (response.data[i] == undefined) break;
        i++;
      }
    });

    return ok;
  }

  async function handleSubmit(event) {
    event.preventDefault();
    const login = event.target[0].value;
    const password = event.target[1].value;

    if (login == "" || password == "") {
      setfieldsComplete(true);
      setIsLogged(false);
    } else {
      setfieldsComplete(false);
      const isOK = tryLogin(login, password);
      await new Promise((r) => setTimeout(r, 50));
      console.log(isOK);
      if (isOK) navigate("/user", { replace: true });
      else setIsLogged(true);
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
      <label className="invalid" hidden={!isLogged}>
        (!) User or password incorrect
      </label>
    </div>
  );
}

export default LoginForm;
