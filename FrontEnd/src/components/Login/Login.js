import React, { Component } from "react";
import "../../../node_modules/bootstrap/dist/css/bootstrap.css";
import "../Layout/Style/Style..css";

class Login extends Component {
  render() {
    return (
      <div>
        <div className="form-group ">
          <form>
            <h1>
              <div className="main-heading">Log In</div>
            </h1>

            <label>Email address</label>
            <input
              type="email"
              class="form-control"
              id="exampleInputEmail1"
              placeholder="Enter email"
            ></input>

            <label>Password</label>
            <input
              type="password"
              class="form-control"
              placeholder="Enter password"
            ></input>
            <button variant="primary">Log In </button>
            {""}
          </form>
        </div>
      </div>
    );
  }
}
export default Login;
