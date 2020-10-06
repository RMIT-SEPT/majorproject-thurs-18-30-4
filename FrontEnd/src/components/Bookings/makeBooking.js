import React, { Component } from "react";
import {Calendar} from "react-calendar";
import 'react-calendar/dist/Calendar.css';
import '../Layout/Style/Style..css';




class Makebooking extends Component {
  state = {
    date: new Date(),
  }

  onChange= date=> this.setState({date});
  

  render() {
    return (
      <div className = "makeBooking" >
        <div className="makeBooking-header">
          <h1>Make a Booking</h1>
          
        </div>
      <div className="makeBooking-caption">
      Please select a date:
      </div>
        
   
        <Calendar>
        onChange={this.onChange}
        value= {this.state.date}
        </Calendar>
</div>

     
    );
  }
}
export default Makebooking;
