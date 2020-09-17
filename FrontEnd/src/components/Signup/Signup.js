import React, { Component } from "react";
import "../../../node_modules/bootstrap/dist/css/bootstrap.min.css";
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
      email: this.state.email,
      role: this.state.role,
      username: this.state.username,
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
            <div className="signup-form">
              <div className="form-group">
               
                  <form onSubmit{...this.onSubmit}>
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
                    id="email"
                    email = "email"
                    value = {this.state.email} 
                    onChange={this.onChange}
                    ></input>
                    
                    
             
                    <label for="role">Account type</label>
                    <select class="form-control" id="role">
                      <option>Customer</option>
                      <option>Business Owner</option>
                      role ="role"
                      value={this.state.role}
                      onChange={this.onChange}
                    </select>
         
                    <label>Username</label>
                    <input
                      type="text"
                      class="form-control"
                      id="username"
                      username="username"
                      value= {this.state.username}
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
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}
export default SignUp;
