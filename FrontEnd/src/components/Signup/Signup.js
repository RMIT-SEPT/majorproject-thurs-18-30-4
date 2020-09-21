import React, { Component } from "react";
import "../../../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "../Layout/Style/Style..css";
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
  onSubmit(e){
    e.preventDefault();

    // backend request
    axios({
      method: "post",
      url: "http://localhost:8080/api/auth/signup",
      data: {
        name: this.state.name,
        username: this.state.username,
        email: this.state.email,
        password: this.state.password,
        role: this.state.role,
      },
    })
      .then(function (response) {
        console.log(response.status);
        
        // TODO alert user signup successful, navigate to login page
        alert("Signup successful");

      }).catch(function(error){
        if (error.response){
          console.log(error.response.status);
          console.log(error.response.data);
          if (error.response.status === 400){
            // acc exists
            // TODO alert acc exists
            alert("Username has been taken");
          } else if (error.response.status === 500){
            // server err
            // TODO alert contact admin
            alert("Please contact admin");
          } else{
            // unhandled
            // TODO alert contact admin w/ response.data
            alert("Please contact admin with the following data: ", error.response.status, error.response.data);
          }
        } else if (error.request){
          console.log("Request made, no response");
          console.log(error.request);
        } else {
          console.log("Error occurred: ", error.message);
        }
      });
    const newPerson = {
      name: this.state.name,
      email: this.state.email,
      password: this.state.password,
      role: this.state.role,
      personIdentifier: this.state.id,
      desc: this.state.desc,
      created_At: this.state.created_At,
      updated_At: this.state.updated_At,
    };
    console.log(newPerson);
  }

  render() {
    return (
      <div className="Signup">
        <div className="container">
          <div className="row">
            <div className="col-md-8 m-auto">
              <form onSubmit={this.onSubmit}>
                <div className="signup-form">
                  <div className="form-group">
                    <h1>Sign Up</h1>

                    <label>Name</label>
                    <input
                      type="text"
                      class="form-control"
                      id="name"
                      name="name"
                      value={this.state.name}
                      onChange={this.onChange}
                    ></input>

                    <label>Username</label>
                    <input
                      type="text"
                      className="form-control"
                      id="username"
                      value={this.state.username}
                      onChange={this.onChange}
                    ></input>

                    <label for="role">Account type</label>
                    <select
                      class="form-control"
                      id="role"
                      value={this.state.role}
                      onChange={this.onChange}
                    >
                      <option>Customer</option>
                      <option>Worker</option>
                      <option>Business Owner</option>
                    </select>

                    <label>Email</label>
                    <input
                      type="email"
                      className="form-control"
                      id="email"
                      onChange={this.onChange}
                      value={this.state.email}
                    ></input>

                    <label>Create Password</label>
                    <input
                      type="password"
                      className="form-control"
                      placeholder="Create password"
                      id="password"
                      onChange={this.onChange}
                      value={this.state.password}
                    />

                    <label
                      id="alert_label"
                      style={this.state.alert_label_style}
                    >
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
          </div>
        </div>
      </div>
    );
  }
}
export default SignUp;
