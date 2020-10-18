import React, { Component } from "react";
import { BrowserRouter as Router, Route, Switch, Link } from "react-router-dom";
import "../../../node_modules/bootstrap/dist/css/bootstrap.css";
import { createHistory } from "../../services/HistoryService";
import SignUp from "../Signup/Signup.js";
import Login from "../Login/Login.js";
import Main from "../Main/Main";
import Account from "../Account/Account.js";
import Makebooking from "../Bookings/makeBooking";
import Bookings from '../Bookings/bookings.js'
import { connect } from "react-redux";
import { ReactComponent as Logo } from './Images/Logo.svg';
import Home from "../Home/Home.js";
import SelectBusiness from "../Bookings/selectBusiness";
import { Dropdown } from "react-bootstrap";
import Customer from "../Account/Customer.js";
import Worker from "../Account/Worker";
import Admin from "../Account/Admin";
import { signout, clearMessage } from "../../actions/projectActions";


class Header extends Component {
  constructor(props){
    super (props);

    this.state={
      showAdminBoard: false,
      showWorkerBoard: false,
      currentUser: undefined
    };
    createHistory.listen((location) =>{
      props.dispatch(clearMessage());
    });
  }
  componentDidMount() {
    const user = this.props.user;

    if (user) {
      this.setState({
        currentUser: user,
        showWorkerBoard: user.roles.includes("ROLE_WORKER"),
        showAdminBoard: user.roles.includes("ROLE_ADMIN")
      });
    }
  }

  render() {
    const { currentUser, showWorkerBoard, showAdminBoard} = this.state;
    return (

      <Router history={createHistory}>
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
          <Route path="/worker" component={Worker} />
          <Route path="/admin" component={Admin} />

        </Switch>
      </Router>
    );
  }
}
function mapStateToProps(state) {
  const { user } = state.authenticationReducer;
  return {
    user,
  };
}

export default connect(mapStateToProps)(Header);

//export default Header;
