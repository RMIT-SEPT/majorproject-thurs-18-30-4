import React, { Component } from "react";

import UserService from "../../services/UserService";

export default class Worker extends Component {
  constructor(props) {
    super(props);

    this.state = {
      content: ""
    };
  }

  componentDidMount() {
    UserService.getWorkerBoard().then(
      response => {
        this.setState({
          content: response.data
        });
      },
      error => {
        this.setState({
          content:
            (error.response &&
              error.response.data &&
              error.response.data.message) ||
            error.message ||
            error.toString()
        });
      }
    );
  }

  render() {
    return (
      <div className="dashboard-container">
          <h1>{this.state.content}</h1>
      </div>
    );
  }
}
