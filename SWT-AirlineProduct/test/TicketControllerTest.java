import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TicketControllerTest {

  /**
   * Valid ticket details are considered non-empty flight and customer IDs since these
   * are auto-populated from the Database, as well as seats within a range of 1-9 inclusive.
   */


  @Test
  void invalidSeat_ValidFlightCustomer() {
    TicketController ticket = new TicketController();
    String flightID = "FO0003";
    String customerID = "CS004";
    String numOfSeats = "-5";

    assertEquals(false, ticket.validateTicketDetails(flightID, customerID, numOfSeats));
  }

  @Test
  void invalidSeatCustomer_ValidFlight() {
    TicketController ticket = new TicketController();
    String flightID = "FO0003";
    String customerID = "";
    String numOfSeats = "0";

    assertEquals(false, ticket.validateTicketDetails(flightID, customerID, numOfSeats));
  }

  @Test
  void invalidSeatFlight_ValidCustomer() {
    TicketController ticket = new TicketController();
    String flightID = "";
    String customerID = "CS004";
    String numOfSeats = "0";

    assertEquals(false, ticket.validateTicketDetails(flightID, customerID, numOfSeats));
  }

  @Test
  void invalidSeatFlightCustomer() {
    TicketController ticket = new TicketController();
    String flightID = "";
    String customerID = "";
    String numOfSeats = "-2";

    assertEquals(false, ticket.validateTicketDetails(flightID, customerID, numOfSeats));
  }

  @Test
  void validSeatFlightCustomer() {
    TicketController ticket = new TicketController();
    String flightID = "FO005";
    String customerID = "CS005";
    String numOfSeats = "9";

    assertEquals(true, ticket.validateTicketDetails(flightID, customerID, numOfSeats));
  }

  @Test
  void validSeatCustomer_InvalidFlight() {
    TicketController ticket = new TicketController();
    String flightID = "";
    String customerID = "CS004";
    String numOfSeats = "1";

    assertEquals(false, ticket.validateTicketDetails(flightID, customerID, numOfSeats));
  }

  @Test
  void validSeatFlight_InvalidCustomer() {
    TicketController ticket = new TicketController();
    String flightID = "FO002";
    String customerID = "";
    String numOfSeats = "3";

    assertEquals(false, ticket.validateTicketDetails(flightID, customerID, numOfSeats));
  }

  @Test
  void validSeat_InvalidFlightCustomer() {
    TicketController ticket = new TicketController();
    String flightID = "";
    String customerID = "";
    String numOfSeats = "5";

    assertEquals(false, ticket.validateTicketDetails(flightID, customerID, numOfSeats));
  }

  @Test
  void seatsOver_ValidFlightCustomer() {
    TicketController ticket = new TicketController();
    String flightID = "FO002";
    String customerID = "CS004";
    String numOfSeats = "10";

    assertEquals(false, ticket.validateTicketDetails(flightID, customerID, numOfSeats));
  }

  @Test
  void seatsOver_ValidFlight() {
    TicketController ticket = new TicketController();
    String flightID = "FO002";
    String customerID = "";
    String numOfSeats = "15";

    assertEquals(false, ticket.validateTicketDetails(flightID, customerID, numOfSeats));
  }

  @Test
  void seatsOver_ValidCustomer() {
    TicketController ticket = new TicketController();
    String flightID = "";
    String customerID = "CS001";
    String numOfSeats = "13";

    assertEquals(false, ticket.validateTicketDetails(flightID, customerID, numOfSeats));
  }

  @Test
  void seatsOver_InvalidFlightCustomer() {
    TicketController ticket = new TicketController();
    String flightID = "";
    String customerID = "";
    String numOfSeats = "10";

    assertEquals(false, ticket.validateTicketDetails(flightID, customerID, numOfSeats));
  }
}