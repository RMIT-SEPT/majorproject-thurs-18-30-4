import React, { Component } from "react";
import "../../../node_modules/bootstrap/dist/css/bootstrap.css";
import "../Layout/Style/Style..css";
import { connect } from "react-redux";
import { Redirect, Route } from "react-router-dom";
import { signin } from "../../actions/projectActions";
import Form from "react-validation/build/form";
import Input from "react-validation/build/input";
import CheckButton from "react-validation/build/button";

class Login extends Component {
  constructor(props) {
    super(props);
    //define state
    this.state={
      username: "",
      password: "",
      logging_in: false
    };
    //binding onChange events
    this.onChangeUsername= this.onChangeUsername.bind(this);
    this.onChangePassword = this.onChangePassword.bind(this);
    this.onSubmit= this.onSubmit.bind(this);
  }

  //change value for username 
  onChangeUsername(event){
    this.setState(
      { username: event.target.value }
    );
  }
  //change value for password 
  onChangePassword(event){
    this.setState(
      { password: event.target.value }
    );
  }

  //submit form
  onSubmit(event) {
    event.preventDefault();
    console.log(this.state);
    //set the state (logging_in to true)
    this.setState({
      logging_in: true
    });

    //declare constants
    const { 
      dispatch, site
    } = this.props;

    //check for errors
    if (this.check.context._errors.length === 0){
      dispatch(signin(this.state.username,this.state.password))
      // if no errors, redirect to account page
      .then(()=>{
        site.push("/account");
        window.location.reload();
      })
      .catch(()=>{
        this.setState({
          logging_in: false
        });
      })
    } else{
      this.setState({
        logging_in: false
      });
    }
  }  

  render() {
    //declare constants
    const{ 
      isSignedIn, message 
    } = this.props;

    //redirect to account page if isSignedIn
    if (isSignedIn){
      return <Redirect to="/account"/>;
    }

    return (
      //design the login form
      <div className="login-form">
      <div className="form-group">
        <div className="container">
          <div className="row">
            <div className="col-md-8 m-auto">
             <Form onSubmit={this.onSubmit} ref={(input) => {this.form = input;}}>
                <h1>
                  <div className="main-heading">Log In</div>
                </h1>
                {/*Displays input textbox for username */}
                <label for="username">Username</label>
                <Input
                  type="text"
                  className="form-control"
                  id="username"
                  name="username"
                  onChange={this.onChangeUsername}
                  value={this.state.username}
                ></Input>
                {/*Displays input textbox for password*/}
                  <label for="password">Password</label>
                  <Input
                    type="password"
                    className="form-control"
                    id="password"
                    name="password"
                    onChange={this.onChangePassword}
                    value={this.state.password}
                  ></Input>
                  {/*Displays button for submit */}
                  <button
                    variant="primary"
                    button
                    type="submit"
                    disabled={
                      !(
                        this.state.password !== "" && this.state.username !== ""
                      )
                    }
                  >
                    Log In
                  </button>
                  {/*Displays alert messages */}
                  {message && (
                    <div className="form-group">
                      <div className="alert alert-danger" role="alert">
                        {message}
                      </div>
                    </div>
                  )}

                  {/*Helps to check errors when logging in */}
                  <CheckButton
                    style={{ display: "none" }}
                    ref={(c) => {this.check = c;
                    }}
                  />
                </Form>
              </div>
            </div>
          </div>
        </div>
        {/*Displays login successful prompt */}
        <h1 hidden={!this.state.isSignedIn} style={{display: "flex", justifyContent: "center", alignItems: "center"}}>
          User successfully logged in.
        </h1>
      </div>
    );
  }
}
//react-redux 
//this function selects parts of the Redux state and passes it as props to the component that connect() is appliied to.
function mapStateToProps(state) {
  //properties from /reducers/index.js (combineReducers)
  const { isSignedIn } = state.authenticationReducer;
  const { message } = state.messageReducer;
  return {
    isSignedIn,
    message
  };
}
export default connect(mapStateToProps)(Login);
