import React, { Component } from "react";
import "../../../node_modules/bootstrap/dist/css/bootstrap.css";
import "../Layout/Style/Style..css";

class SignUp extends Component {
  constructor() {
    super();
    this.state = {
      name: "",
      Email: "",
      username: "",
      password: "",
      role: "",
      created_At: "",
      updated_At: "",
    };
    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }
  onChange(e) {
    this.setState({ [e.target.name]: e.target.value });
  }
  onSubmit(e) {
    e.preventDefault();
    const newPerson = {
      name: this.state.name,
      Email: this.state.Email,
      role: this.state.role,
      username: this.state.username,
      created_At: this.state.created_At,
      updated_At: this.state.updated_At,
    };
    console.log(newPerson);
  }

  render() {
    return (
      <div>
        <div className="form-group">
          <form onSubmit {...this.onSubmit}>
            <div className="signup-form">
              <h1>Sign Up</h1>
      
              <label>Name</label>
              <input
                type="text"
                class="form-control"
                id="Name"
                name="name"
                value={this.state.name}
                onChange={this.onChange}
              ></input>

              <label>Email address</label>
              <input
                type="email"
                class="form-control"
                id="exampleInputEmail1"
                Email="Email"
                value={this.state.Email}
                onChange={this.onChange}
              ></input>

              <label for="role">Account type</label>
              <select class="form-control" id="role">
                role = "role"
                <option>Customer</option>
                <option>Business Owner</option>
                value={this.state.role}
                onChange={this.onChange}
              </select>

              <label>Username</label>
              <input
                type="text"
                class="form-control"
                id="username"
                username="username"
                value={this.state.username}
                onChange={this.onChange}
              ></input>

              <label>Create Password</label>
              <input
                type="password"
                class="form-control"
                password="password"
                value={this.state.password}
                onChange={this.onChange}
              ></input>

              <label>Confirm Password</label>
              <input
                type="password"
                class="form-control"
                password="password"
                value={this.state.password}
                onChange={this.onChange}
              ></input>
              <button variant="primary">Sign Up </button>
              {""}
              </div>
          </form>
        </div>
      </div>
    );
  }
}
export default SignUp;
