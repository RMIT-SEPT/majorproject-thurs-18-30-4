import React, { Component } from "react";
import { BrowserRouter as Router, Route, Switch, Link } from "react-router-dom";
import SignUp from "../Signup/Signup.js";
import Login from "../Login/Login.js";

class Header extends Component {
  try = () => {
    this.props.history.push("/Dashboard");
  };
  render() {
    return (
      <Router>
        <div>
          <nav className="navbar navbar-light ">
            <nav className="navbar-brand">
              <Link to="/main">
                <h1>agme.</h1>
              </Link>
            </nav>

            <Link to="/login"> Log In</Link>

            <Link to="/signup"> Sign Up</Link>
          </nav>
        </div>
        <Switch>
          <Route path="/login">
            <Login />
          </Route>
          <Route path="/signUp">
            <SignUp />
          </Route>
        </Switch>
      </Router>
    );
  }
}
export default Header;
