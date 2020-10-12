import React, { Component } from "react";
import { BrowserRouter as Router, Route, Switch, Link } from "react-router-dom";
import "../../../node_modules/bootstrap/dist/css/bootstrap.css";
import SignUp from "../Signup/Signup.js";
import Login from "../Login/Login.js";
import Main from "../Main/Main";
import Bookings from "../Bookings/bookings.js";
import Account from "../Account/Account.js";
import Makebooking from "../Bookings/makeBooking";
import Home from "../Home/Home.js";
import SelectBusiness from "../Bookings/selectBusiness";
import { ReactComponent as Logo } from "./Images/Logo.svg";
import { Dropdown } from "react-bootstrap";
import Customer from "../Account/Customer.js";
import { signout } from "../../actions/projectActions";


class Header extends Component {
  constructor(props){
    super (props);
  }
  try = () => {
    this.props.history.push("/Dashboard");
  };

  render() {
    return (
      <Router>
        <div className="wrapper">
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

            {/*Trial button dropdowns- shows*/}
            <Dropdown style={{marginLeft: "740%", marginTop: "-22%"}}>
              <Dropdown.Toggle variant = "dark" id="dropdown-basic" >
                Bookings
              </Dropdown.Toggle>

              <Dropdown.Menu>
                <Dropdown.Item href="/bookings">My Bookings</Dropdown.Item>
                <Dropdown.Item href="/SelectBusiness">Make A Booking</Dropdown.Item>
              </Dropdown.Menu>
            </Dropdown>

         

            <Link to="/account">
              <div className="account">Account</div>
            </Link>
          </nav>
        </div>
        <Switch>
          <Route exact path="/" component={Home}></Route>
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

          <Route path="/Makebooking">
            <Makebooking />
          </Route>
          <Route path="/SelectBusiness">
          <SelectBusiness/>
          </Route>
          <Route path="/customer" component={Customer} />

        </Switch>
      </Router>
    );
  }
}
export default Header;
