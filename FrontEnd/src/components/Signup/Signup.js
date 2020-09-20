import React, { Component } from "react";
import axios from "axios";

class SignUp extends Component {
  constructor() {
    super();
    this.state = {
      name: "",
      personIdentifier: "",
      desc: "",
      created_At: "",
      updated_At: "",

      alert_label: "",
      alert_label_style: { color: "red" },

      username: "",
      confirm_password: "",
      password: "",
      email: "",
    };
    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }
  onChange(e) {
    this.setState({ [e.target.id]: e.target.value });
    
  }
  onSubmit(e) {
  
    e.preventDefault();
   
    // backend request
    axios({
      method: "post",
      url: "http://localhost:8080/api/auth/signup",
      data: {
        username: this.state.username,
        email: this.state.email,
        password: this.state.password,
        role: [],
      },
    })
      .then(function (response) {
        console.log(response.status);
        // TODO alert user signup successful, navigate to login page
      })
      .catch(function (error) {
        // handle error
        if (error.response) {
          console.log(error.response.status);
          console.log(error.response.data);
          // TODO expand error handling: handle codes 400 (acc already exists), 500 (server err)
        } else if (error.request) {
          console.log("Request made, no response");
          console.log(error.request);
        } else {
          console.log("Error occurred: ", error.message);
        }
      });
    const newPerson = {
      name: this.state.name,
      personIdentifier: this.state.id,
      desc: this.state.desc,
      created_At: this.state.created_At,
      updated_At: this.state.updated_At,
    };
    console.log(newPerson);
  }

  render() {
    return (
      <div>
        <form onSubmit={this.onSubmit}>
          <div className="form-group">
            <div className="signup-form">
              <h1>Sign Up</h1>

              <label>Username</label>
              <input
                type="text"
                className="form-control"
                id="username"
                value={this.state.username}
                onChange={this.onChange}
              ></input>

              <label>Email</label>
              <input
                type="email"
                className="form-control"
                id="email"
                onChange={this.onChange}
                value={this.state.email}
              ></input>

              {/*<label>Email address</label>*/}
              {/*<input*/}
              {/*  type="email"*/}
              {/*  class="form-control"*/}
              {/*  id="exampleInputEmail1"*/}
              {/*  placeholder="Enter email"*/}

              {/*></input>*/}

              <label>Create Password</label>
              <input
                type="password"
                className="form-control"
                placeholder="Create password"
                id="password"
                onChange={this.onChange}
                value={this.state.password}
              />

              <label id="alert_label" style={this.state.alert_label_style}>
                {this.state.alert_label}
              </label>
              <br></br>

              <label>Confirm Password</label>
              <input
                className="form-control"
                type="password"
                id="confirm_password"
                onChange={this.onChange}
                value={this.state.confirm_password}
              ></input>

              <button
                variant="primary"
                disabled={
                  this.state.password !== this.state.confirm_password ||
                  this.state.password === ""
                }
              >
                Sign Up
              </button>
              {""}
            </div>
          </div>
        </form>
      </div>
    );
  }
}
export default SignUp;
