import React, { Component } from "react";
import { BrowserRouter as Router, Route, Switch, Link } from "react-router-dom";
import "../../../node_modules/bootstrap/dist/css/bootstrap.css";
import SignUp from "../Signup/Signup.js";
import Login from "../Login/Login.js";
import Main from "../Main/Main";
import Bookings from '../Bookings/bookings.js'
import Account from '../Account/Account.js'
import { ReactComponent as Logo } from './Images/Logo.svg';
import Home from "../Home/Home.js";

class Header extends Component {
  try = () => {
    this.props.history.push("/Dashboard");
  };
  render() {
    return (
      <Router>
        <div class="wrapper">
          <nav className="desktop-nav">
            <Link to="/login">
              <div className="login"> Log In</div>
            </Link>
            <Link to="/">
              <div>
                {/* Logo is an actual React component */}
                  <Logo />
              </div>
            </Link>
            <Link to="/signup">
              <div className="signup">Sign Up</div>
            </Link>
            <Link to="/bookings">
              <div className="bookings">Bookings</div>
            </Link>
            <Link to="/account">
              <div className="account">Account</div>
            </Link>
          </nav>
        </div>
        <Switch>
          <Route exact path='/' component={Home}></Route> 
          <Route path="/login">
            <Login />
          </Route>
          <Route path="/main">
            <Main />
          </Route>
          <Route path="/signup">
            <SignUp />
          </Route>
          <Route path="/bookings">
            <Bookings />
          </Route>
          <Route path="/account">
            <Account />
          </Route>
        </Switch>
      </Router>
    );
  }
}
export default Header;
