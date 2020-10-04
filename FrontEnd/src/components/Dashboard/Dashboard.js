import React, { Component } from "react";
import {BrowserRouter as Route} from "react-router-dom";



class Dashboard extends Component {
  render() {
    return (
      <Route
  path="/dashboard" component={Dashboard}>
      <div>
        <h1>My Dashboard</h1>
        <h1 style= "color: white;">Hello, </h1>
      </div>
      </Route>
   
    );
  }
}
export default Dashboard;
