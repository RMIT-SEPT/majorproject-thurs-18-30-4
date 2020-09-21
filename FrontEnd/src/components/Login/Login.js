import React, { Component } from "react";
import "../../../node_modules/bootstrap/dist/css/bootstrap.css";
import "../Layout/Style/style.css";
import axios from "axios";

class Login extends Component {
  constructor() {
    super();
    this.state={
      "username": "",
      "password": "",
      "loggedin": false
    }
    this.onChange= this.onChange.bind(this);
    this.onSubmit= this.onSubmit.bind(this);
  }
  onChange(e){
    this.setState({[e.target.id]: e.target.value});
  }
  onSubmit(e){
    e.preventDefault();
    // REST request
    axios({
      method: "post",
      url: "http://localhost:8080/api/auth/signin",
      data: {
        username: this.state.username,
        password: this.state.password
      }
    }).then(function(response) {
      console.log(response.status);
      // TODO
      //   navigate to homepage
      //   handle logout in header
      if (response.status === 200){
        localStorage.setItem("AUTH_TOKEN", response.data.accessToken);
      }
    }).catch(function(error){
      if (error.response){
        if (error.response.status === 400){
          // Empty/bad values
          // TODO alert label saying "Bad Values"
        } else if (error.response.status === 401){
          // Login failed
          // TODO alert label saying "Incorrect Credentials"
        } else if (error.response.status === 500){
          // Server error
          // TODO alert box to say "please contact admin"
        } else {
          // Unhandled
          // TODO alert saying "please contact admin and provide following data: " provide response data
          console.log(error.response.status);
          console.log(error.response.data);
        }
      } else if (error.request){
        console.log("Request made, no response");
        console.log(error.request);
      } else{
        console.log("Error occurred: ", error.message);
      }
    });
    if (localStorage.getItem("AUTH_TOKEN")){
      this.setState({loggedin: true})
      // TODO Bind to "log out" button in header
      // localStorage.removeItem("AUTH_TOKEN");
    }
  }
  render() {
    return (
      <div>
        <form onSubmit={this.onSubmit} hidden={this.state.loggedin}>
          <div className="form-group ">
            <div className="login-form">
              <h1>Log In</h1>

              <label>Username</label>
              <input
                type="username"
                className="form-control"
                id="username"
                onChange={this.onChange}
                value={this.state.username}
              ></input>

              <label>Password</label>
              <input
                type="password"
                className="form-control"
                id="password"
                onChange={this.onChange}
                value={this.state.password}
              ></input>
              <button variant="primary" disabled={ !(this.state.password !== "" && this.state.username !== "") }>Log In </button>
              {""}
            </div>
          </div>
        </form>
        <h1 hidden={!this.state.loggedin} style={{display: "flex", justifyContent: "center", alignItems: "center"}}>
          Successfully logged in
        </h1>
      </div>
    );
  }
}
export default Login;
