import React, { Component } from "react";
import { Redirect } from 'react-router-dom';
import { connect } from "react-redux";
import "../Layout/Style/Style..css";
import { signout } from "../../actions/projectActions"


class Account extends Component {
  constructor(props){
    super (props);
    this.signOut = this.signOut.bind(this);
  }

  signOut(){
    this.props.dispatch(signout());
  }


  render() {
    const { user: loggedinUser } = this.props;

    if (!loggedinUser) {
      return <Redirect to="/login" />;
    }

    return (
      <div className="profile-container"> 
        <h1>
          My Profile:
        </h1>
        <p>
          <strong>Id:</strong> {loggedinUser.id}
        </p>
        <p>
          <strong>Name:</strong> {loggedinUser.name}
        </p>
        <p>
          <strong>Userame:</strong> {loggedinUser.username}
        </p>
        <p>
          <strong>Email:</strong> {loggedinUser.email}
        </p>
        <strong>Authorities:</strong>
        <ul>
          {loggedinUser.roles &&
            loggedinUser.roles.map((role, index) => <li key={index}>{role}</li>)}
        </ul>
        <a href="/login" className="nav-link" onClick={this.signOut}>
          LogOut
        </a>
      </div>
    );
  }
}

function mapStateToProps(state) {
  const { user } = state.authenticationReducer;
  return {
    user,
  };
}

export default connect(mapStateToProps)(Account);
