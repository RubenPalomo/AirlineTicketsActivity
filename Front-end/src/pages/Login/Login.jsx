import React from "react";
import "./Login.scss";
import LoginForm from "../../components/LoginForm/LoginForm";
import logo from "./../../assets/logo.png";
import Header from "./../../components/Header/Header";

function Login() {
  return (
    <div className="mainDiv">
      <div>
        <img src={logo} width="20%" />
      </div>
      <div className="secondDiv">
        <h1>LOGIN</h1>
        <LoginForm />
      </div>
    </div>
  );
}

export default Login;
