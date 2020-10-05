import React, { Component } from "react";
import "../../../node_modules/bootstrap/dist/css/bootstrap.css";
import "../Layout/Style/Style..css";
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
  //change values as per form input
  onChange(e) {
    this.setState({ [e.target.id]: e.target.value });
  }
  //submit form
  onSubmit(e) {
    e.preventDefault();
    console.log(this.state);
    
 
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
      //   handle logout in header
      if (response.status === 200){
        axios()
        localStorage.setItem("AUTH_TOKEN", response.data.accessToken);
        window.location.href = "/account";
        }
    }).catch(function(error){
      if (error.response){
        window.location.href= "/login";
        if (error.response.status === 400){
          // Empty/bad values
          alert("Bad Values");
        
        } else if (error.response.status === 401){
          // Login failed
          alert("Incorrect credentials");
         
        } else if (error.response.status === 500){
          // Server error
          alert("Please contact admin");
          
        } else {
          // Unhandled
          console.log(error.response.status);
          console.log(error.response.data);
          alert("Please contact admin and provide following data: ", error.response.status, ": ", error.response.data);
          
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
      <div className="login-form">
      <div className="form-group ">
        <div className="container">
          <div className="row">
            <div className="col-md-8 m-auto">
             <form onSubmit={this.onSubmit} hidden={this.state.loggedin}>
                <h1>
                  <div className="main-heading">Log In</div>
                </h1>
                {/*Displays input textbox for username */}
                <label>Username</label>
                <input
                  type="username"
                  className="form-control"
                  id="username"
                  onChange={this.onChange}
                  value={this.state.username}
                ></input>
                {/*Displays input textbox for password*/}
                  <label>Password</label>
                  <input
                    type="password"
                    className="form-control"
                    id="password"
                    onChange={this.onChange}
                    value={this.state.password}
                  ></input>
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
                    Log In{" "}
                  </button>
                  {""}
                </form>
              </div>
            </div>
          </div>
        </div>
        
       
        
      </div>
    );
  }
}
export default Login;
