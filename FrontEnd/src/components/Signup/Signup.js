import React, { Component } from "react";

class SignUp extends Component {
    constructor(){
      super();
      this.state={
        "name": "",
        "personIdentifier": "",
        "desc": "",
        "created_At": "",
        "updated_At": "",
      }
      this.onChange= this.onChange.bind(this);
      this.onSubmit= this.onSubmit.bind(this);
    }
    onChange(e){
      this.setState({[e.target.name]: e.target.value});
    }
    onSubmit(e){
      e.preventDefault();
      const newPerson={
        name: this.state.name,
        personIdentifier: this.state.id,
        desc: this.state.desc,
        created_At: this.state.created_At,
        updated_At: this.state.updated_At
      }
      console.log(newPerson);
    }
    
  render() {
    return (
      <div>
      <form onSubmit{this.onSubmit}>
        <div className="form-group">
          <div className="signup-form">
            <h1>Sign Up</h1>

            <label>First Name</label>
            <input type="text" class="form-control" id="firstName"
            name= "name"
            value= {this.state.name}
            onChange={this.onChange}></input>
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
        </form>
      </div>
    );
  }
  
}
export default SignUp;