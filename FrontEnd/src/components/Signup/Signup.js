import React, { Component } from "react";


class SignUp extends Component {
  constructor() {
    super();
    this.state = {
      name: "",
      Email: "",
      username: "",
      password: "",
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
      username: this.state.username,
      created_At: this.state.created_At,
      updated_At: this.state.updated_At,
    };
    console.log(newPerson);
  }

  render() {
    return (
      <form onSubmit {...this.onSubmit}>
      <link rel="stylesheet"
      type="text/css" href="[url_bootstrap_theme]"
      />
    <link
      href="https://fonts.googleapis.com/css?family=Sanchez&display=swap"
      rel="stylesheet"
    />
    <link
      href="https://fonts.googleapis.com/css?family=Rokkitt&display=swap"
      rel="stylesheet"
    />
    <link
      href="https://fonts.googleapis.com/css?family=Ropa+Sans&display=swap"
      rel="stylesheet"
    />
    <link href="./css/main.css" rel="stylesheet" /> 
    <title>Document</title>
  
    <div classNameName="v22_39">
      <div className="v22_40"></div>
      <div className="v22_41"></div>
      <div className="v22_42"></div>
      <span className="v22_43">Businesses</span>
      <span className="v22_44">Make An Appointment</span>
      <span className="v22_45">How To Use AGME</span>
      <span className="v22_46">Why Use AGME?</span>
      <span className="v22_47">Testimonials</span>
      <span className="v22_48">Pricing</span>
      <span className="v22_49">Contact Us</span>
      <span className="v22_50">About Us</span>
      <span className="v22_52">AGME</span>
      <span className="v22_53">Sign Up</span>
      <span className="v22_62">Sign Up</span>
      <span className="v22_59">Log in</span>
      <div className="v22_60"></div>
      <div className="v22_61"></div>
      <div className="v28_4"></div>
      <div className="v28_3"></div>
      <div className="v28_5"></div>
      <span className="v28_10">Email Address</span>
      <span className="v28_11">Create Password </span>
      <span className="v28_9">Name</span>
      <div className="v28_17">
        <div className="v28_18"></div>
        <span className="v28_19">Register</span>
      </div>
      <div className="v46_31">
        <span className="v46_32">2020 © Copyright </span>
        <div className="v46_33">
          <div className="v46_34"></div>
          <div className="v46_35"></div>
        </div>
        </div>
    </div>
    </form>

    );
  }
}
export default SignUp;


/*  
 <div>
        <form onSubmit {...this.onSubmit}>
          <div className="form-group">
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

              <label>Create Password</label>
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
          </div>
        </form>
      </div>
      */

