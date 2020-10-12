import React, { Component } from "react";
import { Card, Button} from "react-bootstrap";

class SelectBusiness extends Component {
  render() {
    return (
      <div>
        <div className="makeBooking-header">
          <h1>Select a Business</h1>
        </div>

        <Card style={{ width: "18rem", marginTop: "20%" }}>
          <Card.Img
            variant="top"
            src={require("../Layout/Images/restaurant_card.png")}
            height="200"
            width="200"
          />
          <Card.Body>
            <Card.Title> Wine & Co.</Card.Title>
            <Card.Text>
              Specialising in the best locally sourced wine and steak
            </Card.Text>
            <Button variant="dark" justify="center" link href="/makeBooking">
              Make a Booking
            </Button>
          </Card.Body>
        </Card>
      </div>
    );
  }
}
export default SelectBusiness;
