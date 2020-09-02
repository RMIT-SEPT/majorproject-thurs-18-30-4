import React, { Component } from "react";
import "../../../node_modules/bootstrap/dist/css/bootstrap.css";
import "../Layout/Style/style.css";

class Login extends Component {
  render() {
    return (
      <div>
        <form>
          <div className="form-group">
            <div className="login-form">
              <h1>Log In</h1>

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
            </div>
          </div>
        </form>
      </div>
    );
  }
}
export default Login;
