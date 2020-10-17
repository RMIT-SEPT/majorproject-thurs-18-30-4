import React, { Component } from "react";
import { Card, Button, CardDeck, CardColumns } from "react-bootstrap";

class SelectBusiness extends Component {
  render() {
    return (
      <div>
        <div className="makeBooking-header">
          <h1>Select a Business</h1>
        </div>

        <CardDeck>
          <Card style={{ width: "18rem", marginTop: "20%" }}>
            <Card.Img
              variant="top"
              src={require("../Layout/Images/restaurant_card.png")}
            />

            <Card.Body>
              <Card.Title> Wine & Co.</Card.Title>
              <Card.Text>
                Specialising in the best locally sourced wine and steak
              </Card.Text>
              <Button
                variant="dark"
                justifycontent="center"
                href="/makeBooking"
              >
                Make a Booking
              </Button>
            </Card.Body>
          </Card>

          <Card style={{ width: "18rem", marginTop: "20%" }}>
            <Card.Img
              variant="top"
              src={require("../Layout/Images/lawnmowing.png")}
              aspectRatio="16by9"
            />
            <Card.Body>
              <Card.Title> Moe's Lawns</Card.Title>
              <Card.Text>Providing the best lawn services</Card.Text>
              <Button variant="dark" justify="center" href="/makeBooking">
                Make a Booking
              </Button>
            </Card.Body>
          </Card>

          <Card style={{ width: "18rem", marginTop: "20%" }}>
            <Card.Img
              variant="top"
              src={require("../Layout/Images/cleaning.png")}
            />
            <Card.Body>
              <Card.Title> Cleaning Fairy</Card.Title>
              <Card.Text>Cleaning to exceptional standards</Card.Text>
              <Button variant="dark" href="/makeBooking">
                Make a Booking
              </Button>
            </Card.Body>
          </Card>

          <Card style={{ width: "18rem", marginTop: "20%" }}>
            <Card.Img
              variant="top"
              src={require("../Layout/Images/hair.png")}
            />
            <Card.Body>
              <Card.Title> Cut and Colour</Card.Title>
              <Card.Text>Hair that looks good</Card.Text>
              <Button variant="dark" href="/makeBooking">
                Make a Booking
              </Button>
            </Card.Body>
          </Card>
        </CardDeck>
      </div>
    );
  }
}
export default SelectBusiness;
