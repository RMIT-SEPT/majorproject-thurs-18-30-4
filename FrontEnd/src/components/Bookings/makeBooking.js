import React, { Component } from "react";
import {Calendar} from "react-calendar";
import 'react-calendar/dist/Calendar.css';
import '../Layout/Style/Style..css';
import "../../../node_modules/bootstrap/dist/css/bootstrap.css";
import axios from "axios";



class Makebooking extends Component {
  constructor() {
    super();
    this.state={
      "date": new Date(),
    }
    this.onChange= date=> this.setState({date})
    this.onSubmit= this.onSubmit.bind(this);
    
  }

  onChange(e) {
    this.setState({ "date": e.target.value });
  }
  onSubmit(e) {
    e.preventDefault();
    console.log(this.date);
    
 
    // REST request
    axios({
      method: "post",
      url: "http://localhost:8080/api/bookings",
      data: {
       date: this.date
      }
    }).then(function() {
      console.log(this.date);
    })};
   

  
  

  render() {
    return (
      <div className = "makeBooking" >
        <div className="makeBooking-header">
          <h1>Make a Booking</h1>
          
        </div>
      <div className="makeBooking-caption">
      Please select a date:
      </div>
        
    
        <Calendar
        onChange={this.onChange}
        value= {this.state.date}
        />
        <button onClick={this.onSubmit} style= {{marginLeft: "48%", marginTop: "5%"}}>
        Submit
      </button>
       
     
</div>

     
    );
  }
}
export default Makebooking;
