import React, { Component } from "react";
import { BrowserRouter as Router, Route, Switch, Link } from "react-router-dom";
import "../../../node_modules/bootstrap/dist/css/bootstrap.css";
import SignUp from "../Signup/Signup.js";
import Login from "../Login/Login.js";
import Main from "../Main/Main";
class Header extends Component {
  try = () => {
    this.props.history.push("/Dashboard");
  };
  render() {
    return (
      <Router>
        <div>
          <nav className="navbar">
            <Link to="/login">
              <div className="main-heading"> Log In</div>
            </Link>
            <Link to="/main">
              <div className="main-heading">agme.</div>
            </Link>
            <Link to="/signup">
              <div className="main-heading">Sign Up</div>
            </Link>
          </nav>
        </div>
        <Switch>
          <Route path="/login">
            <Login />
          </Route>
          <Route path="/main">
            <Main />
          </Route>
          <Route path="/signup">
            <SignUp />
          </Route>
        </Switch>
      </Router>
    );
  }
}
export default Header;
