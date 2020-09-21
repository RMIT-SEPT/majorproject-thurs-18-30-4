import React, { Component } from "react";
import "../../../node_modules/bootstrap/dist/css/bootstrap.css";
import "../Layout/Style/Style..css";
import axios from "axios";

class Login extends Component {
  constructor() {
    super();
    this.state = {
      username: "",
      password: "",
    };
    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }
  onChange(e) {
    this.setState({ [e.target.id]: e.target.value });
  }
  onSubmit(e) {
    alert("Login submitted");
    e.preventDefault();
    console.log(this.state);

    // REST request
    axios({
      method: "post",
      url: "http://localhost:8080/api/auth/signin",
      data: {
        username: this.state.username,
        password: this.state.password,
      },
    })

      .then(function (response) {
        console.log(response.status);
        // TODO
        //   save auth token
        //   alert user login successful
        //   navigate to homepage
      })
      .catch(function (error) {
        // handle error
        if (error.response) {
          console.log(error.response.status);
          console.log(error.response.data);
          // TODO expand error handling: handle codes 400 (empty values), 401 (login failed), 500 (backend error)
        } else if (error.request) {
          console.log("Request made, no response");
          console.log(error.request);
        } else {
          console.log("Error occurred: ", error.message);
        }
      });
  }
  render() {
    return (
      <div className="signup-form">
        <div className="form-group ">
          <div className="container">
            <div className="row">
              <div className="col-md-8 m-auto">
                <form onSubmit={this.onSubmit}>
                  <h1>
                    <div className="main-heading">Log In</div>
                  </h1>
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
