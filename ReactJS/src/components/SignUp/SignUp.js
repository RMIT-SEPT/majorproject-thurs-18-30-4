import React, { Component } from "react";

class SignUp extends Component {
  render() {
    return (
      <div>
        <div className="form-group">
          <div className="signup-form">
            <h1>Sign Up</h1>

            <label>First Name</label>
            <input type="text" class="form-control" id="firstName"></input>
            <label>Last Name</label>
            <input type="text" class="form-control" id="lastName"></input>

            <label>Email address</label>
            <input
              type="email"
              class="form-control"
              id="exampleInputEmail1"
              placeholder="Enter email"
            ></input>

            <label>Create Password</label>
            <input
              type="password"
              class="form-control"
              placeholder="Create password"
            ></input>
            <button variant="primary">Sign Up </button>
            {""}
          </div>
        </div>
      </div>
    );
  }
}
export default SignUp;
