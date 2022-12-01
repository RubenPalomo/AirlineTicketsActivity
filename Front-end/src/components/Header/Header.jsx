import react from "react";
import { Link } from "react-router-dom";
import logo from "./../../assets/logo.png";
import "./Header.scss";

function Header(props) {
  return (
    <div>
      <div className="logoContainer">
        <img className="logo" src={logo} />
      </div>
      <div className="header">
        <ul className="menuList">
          <li>
            <Link to="/user">User</Link>
          </li>
          <li>
            <Link to="/trips">My trips</Link>
          </li>
          <li>
            <Link to="/tickets">Buy tickets</Link>
          </li>
          <li>
            <Link to="/settings">Settings</Link>
          </li>
          <li>
            <Link to="/login">Log out</Link>
          </li>
        </ul>
      </div>
    </div>
  );
}

export default Header;
