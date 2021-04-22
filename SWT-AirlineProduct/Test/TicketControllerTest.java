import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.*;

class TicketControllerTest {

    /**
     * Valid ticket details are considered non-empty flight and customer IDs since these
     * are auto-populated from the Database, as well as seats within a range of 1-9 inclusive.
     */

    private TicketController ticket;

     /**
     * Instance of TicketController used for testing.
     */
    @BeforeEach
    public void setup(){
        ticket = new TicketController();
    }

    /**
     * Test Case ID: TC-T-01
     * Requirement ID/Description: SR-F-06: The system shall allow the user to book a ticket for a customer
     * by entering a customer ID and choosing a flight, class, price, and number of seats for the ticket.
     * Purpose: Test that a user is not able to book a ticket with an invalid seat value.
     * Test Setup: An instance of the TicketController class is created and the validateTicketDetails() method
     * is invoked with flightID, customerID, and numOfSeats passed in as parameters.The assertEquals method is used
     * confirm that the ticket details are invalid, and the ticket was not booked.
     * Test Strategy: Multidimensional partitioning/BVA was used to develop test cases for this requirement
     * Input: flightID = "FO0003", customerID = "CS004", numOfSeats = "-5"
     * Expected Output: false
     */


    @Test
    void invalidSeat_ValidFlightCustomer() {
        ticket = new TicketController();
        String flightID = "FO0003";
        String customerID = "CS004";
        String numOfSeats = "-5";

        assertEquals(false, ticket.validateTicketDetails(flightID, customerID, numOfSeats));
    }

    /**
     * Test Case ID: TC-T-02
     * Requirement ID/Description: SR-F-06: The system shall allow the user to book a ticket for a customer
     * by entering a customer ID and choosing a flight, class, price, and number of seats for the ticket.
     * Purpose: Test that a user is not able to book a ticket with an invalid seat value and customer ID.
     * Test Setup: An instance of the TicketController class is created and the validateTicketDetails() method
     * is invoked with flightID, customerID, and numOfSeats passed in as parameters.The assertEquals method is used
     * confirm that the ticket details are invalid, and the ticket was not booked.
     * Test Strategy: Multidimensional partitioning/BVA was used to develop test cases for this requirement
     * Input: flightID = "FO0003", customerID = " ", numOfSeats = "-3"
     * Expected Output: false
     */

    @Test
    void invalidSeatCustomer_ValidFlight() {
        ticket = new TicketController();
        String flightID = "FO0003";
        String customerID = "";
        String numOfSeats = "-3";

        assertEquals(false, ticket.validateTicketDetails(flightID, customerID, numOfSeats));
    }

    /**
     * Test Case ID: TC-T-03
     * Requirement ID/Description: SR-F-06: The system shall allow the user to book a ticket for a customer
     * by entering a customer ID and choosing a flight, class, price, and number of seats for the ticket.
     * Purpose: Test that a user is not able to book a ticket with an invalid seat value and flight ID.
     * Test Setup: An instance of the TicketController class is created and the validateTicketDetails() method
     * is invoked with flightID, customerID, and numOfSeats passed in as parameters.The assertEquals method is used
     * confirm that the ticket details are invalid, and the ticket was not booked.
     * Test Strategy: Multidimensional partitioning/BVA was used to develop test cases for this requirement
     * Input: flightID = " ", customerID = "CS004", numOfSeats = "-1"
     * Expected Output: false
     */

    @Test
    void invalidSeatFlight_ValidCustomer() {
        ticket = new TicketController();
        String flightID = "";
        String customerID = "CS004";
        String numOfSeats = "-1";

        assertEquals(false, ticket.validateTicketDetails(flightID, customerID, numOfSeats));
    }

    /**
     * Test Case ID: TC-T-04
     * Requirement ID/Description: SR-F-06: The system shall allow the user to book a ticket for a customer
     * by entering a customer ID and choosing a flight, class, price, and number of seats for the ticket.
     * Purpose: Test that a user is not able to book a ticket with an invalid seat value, flight ID, and
     * customer ID.
     * Test Setup: An instance of the TicketController class is created and the validateTicketDetails() method
     * is invoked with flightID, customerID, and numOfSeats passed in as parameters.The assertEquals method is used
     * confirm that the ticket details are invalid, and the ticket was not booked.
     * Test Strategy: Multidimensional partitioning/BVA was used to develop test cases for this requirement
     * Input: flightID = " ", customerID = " ", numOfSeats = "0"
     * Expected Output: false
     */

    @Test
    void invalidSeatFlightCustomer() {
        ticket = new TicketController();
        String flightID = "";
        String customerID = "";
        String numOfSeats = "0";

        assertEquals(false, ticket.validateTicketDetails(flightID, customerID, numOfSeats));
    }

    /**
     * Test Case ID: TC-T-05
     * Requirement ID/Description: SR-F-06: The system shall allow the user to book a ticket for a customer
     * by entering a customer ID and choosing a flight, class, price, and number of seats for the ticket.
     * Purpose: Test that a user is able to book a ticket with a valid seat value, flight ID, and
     * customer ID.
     * Test Setup: An instance of the TicketController class is created and the validateTicketDetails() method
     * is invoked with flightID, customerID, and numOfSeats passed in as parameters.The assertEquals method is used
     * confirm that the ticket details are valid, and the ticket was booked.
     * Test Strategy: Multidimensional partitioning/BVA was used to develop test cases for this requirement
     * Input: flightID = "FO0003", customerID = "CS004", numOfSeats = "0"
     * Expected Output: true
     */

    @Test
    void validSeatFlightCustomer() {
        ticket = new TicketController();
        String flightID = "FO005";
        String customerID = "CS004";
        String numOfSeats = "1";

        assertEquals(true, ticket.validateTicketDetails(flightID, customerID, numOfSeats));
    }

    /**
     * Test Case ID: TC-T-06
     * Requirement ID/Description: SR-F-06: The system shall allow the user to book a ticket for a customer
     * by entering a customer ID and choosing a flight, class, price, and number of seats for the ticket.
     * Purpose: Test that a user is not able to book a ticket with an invalid flight ID.
     * Test Setup: An instance of the TicketController class is created and the validateTicketDetails() method
     * is invoked with flightID, customerID, and numOfSeats passed in as parameters.The assertEquals method is used
     * confirm that the ticket details are invalid, and the ticket was not booked.
     * Test Strategy: Multidimensional partitioning/BVA was used to develop test cases for this requirement
     * Input: flightID = " ", customerID = "CS004", numOfSeats = "3"
     * Expected Output: false
     */

    @Test
    void validSeatCustomer_InvalidFlight() {
        ticket = new TicketController();
        String flightID = "";
        String customerID = "CS004";
        String numOfSeats = "3";

        assertEquals(false, ticket.validateTicketDetails(flightID, customerID, numOfSeats));
    }

    /**
     * Test Case ID: TC-T-07
     * Requirement ID/Description: SR-F-06: The system shall allow the user to book a ticket for a customer
     * by entering a customer ID and choosing a flight, class, price, and number of seats for the ticket.
     * Purpose: Test that a user is not able to book a ticket with an invalid customer ID.
     * Test Setup: An instance of the TicketController class is created and the validateTicketDetails() method
     * is invoked with flightID, customerID, and numOfSeats passed in as parameters.The assertEquals method is used
     * confirm that the ticket details are invalid, and the ticket was not booked.
     * Test Strategy: Multidimensional partitioning/BVA was used to develop test cases for this requirement
     * Input: flightID = "FO002", customerID = " ", numOfSeats = "8"
     * Expected Output: false
     */

    @Test
    void validSeatFlight_InvalidCustomer() {
        ticket = new TicketController();
        String flightID = "FO002";
        String customerID = "";
        String numOfSeats = "8";

        assertEquals(false, ticket.validateTicketDetails(flightID, customerID, numOfSeats));
    }

    /**
     * Test Case ID: TC-T-08
     * Requirement ID/Description: SR-F-06: The system shall allow the user to book a ticket for a customer
     * by entering a customer ID and choosing a flight, class, price, and number of seats for the ticket.
     * Purpose: Test that a user is not able to book a ticket with an invalid customer ID and flight ID.
     * Test Setup: An instance of the TicketController class is created and the validateTicketDetails() method
     * is invoked with flightID, customerID, and numOfSeats passed in as parameters.The assertEquals method is used
     * confirm that the ticket details are invalid, and the ticket was not booked.
     * Test Strategy: Multidimensional partitioning/BVA was used to develop test cases for this requirement
     * Input: flightID = " ", customerID = " ", numOfSeats = "9"
     * Expected Output: false
     */

    @Test
    void validSeat_InvalidFlightCustomer() {
        ticket = new TicketController();
        String flightID = "";
        String customerID = "";
        String numOfSeats = "9";

        assertEquals(false, ticket.validateTicketDetails(flightID, customerID, numOfSeats));
    }

    /**
     * Test Case ID: TC-T-09
     * Requirement ID/Description: SR-F-06: The system shall allow the user to book a ticket for a customer
     * by entering a customer ID and choosing a flight, class, price, and number of seats for the ticket.
     * Purpose: Test that a user is not able to book a ticket with an invalid seat quantity.
     * Test Setup: An instance of the TicketController class is created and the validateTicketDetails() method
     * is invoked with flightID, customerID, and numOfSeats passed in as parameters.The assertEquals method is used
     * confirm that the ticket details are invalid, and the ticket was not booked.
     * Test Strategy: Multidimensional partitioning/BVA was used to develop test cases for this requirement
     * Input: flightID = "FO002", customerID = "CS004", numOfSeats = "10"
     * Expected Output: false
     */

    @Test
    void seatsOver_ValidFlightCustomer() {
        ticket = new TicketController();
        String flightID = "FO002";
        String customerID = "CS004";
        String numOfSeats = "10";

        assertEquals(false, ticket.validateTicketDetails(flightID, customerID, numOfSeats));
    }

    /**
     * Test Case ID: TC-T-10
     * Requirement ID/Description: SR-F-06: The system shall allow the user to book a ticket for a customer
     * by entering a customer ID and choosing a flight, class, price, and number of seats for the ticket.
     * Purpose: Test that a user is not able to book a ticket with an invalid seat quantity and customer ID.
     * Test Setup: An instance of the TicketController class is created and the validateTicketDetails() method
     * is invoked with flightID, customerID, and numOfSeats passed in as parameters.The assertEquals method is used
     * confirm that the ticket details are invalid, and the ticket was not booked.
     * Test Strategy: Multidimensional partitioning/BVA was used to develop test cases for this requirement
     * Input: flightID = "FO002", customerID = " ", numOfSeats = "11"
     * Expected Output: false
     */

    @Test
    void seatsOver_ValidFlight() {
        ticket = new TicketController();
        String flightID = "FO002";
        String customerID = "";
        String numOfSeats = "11";

        assertEquals(false, ticket.validateTicketDetails(flightID, customerID, numOfSeats));
    }

    /**
     * Test Case ID: TC-T-11
     * Requirement ID/Description: SR-F-06: The system shall allow the user to book a ticket for a customer
     * by entering a customer ID and choosing a flight, class, price, and number of seats for the ticket.
     * Purpose: Test that a user is not able to book a ticket with an invalid seat quantity and flight ID.
     * Test Setup: An instance of the TicketController class is created and the validateTicketDetails() method
     * is invoked with flightID, customerID, and numOfSeats passed in as parameters.The assertEquals method is used
     * confirm that the ticket details are invalid, and the ticket was not booked.
     * Test Strategy: Multidimensional partitioning/BVA was used to develop test cases for this requirement
     * Input: flightID = " ", customerID = "CS004", numOfSeats = "13"
     * Expected Output: false
     */

    @Test
    void seatsOver_ValidCustomer() {
        ticket = new TicketController();
        String flightID = "";
        String customerID = "CS004";
        String numOfSeats = "13";

        assertEquals(false, ticket.validateTicketDetails(flightID, customerID, numOfSeats));
    }

    /**
     * Test Case ID: TC-T-12
     * Requirement ID/Description: SR-F-06: The system shall allow the user to book a ticket for a customer
     * by entering a customer ID and choosing a flight, class, price, and number of seats for the ticket.
     * Purpose: Test that a user is not able to book a ticket with an invalid seat quantity, flight ID, and customer ID.
     * Test Setup: An instance of the TicketController class is created and the validateTicketDetails() method
     * is invoked with flightID, customerID, and numOfSeats passed in as parameters.The assertEquals method is used
     * confirm that the ticket details are invalid, and the ticket was not booked.
     * Test Strategy: Multidimensional partitioning/BVA was used to develop test cases for this requirement
     * Input: flightID = " ", customerID = " ", numOfSeats = "15"
     * Expected Output: false
     */

    @Test
    void seatsOver_InvalidFlightCustomer() {
        ticket = new TicketController();
        String flightID = "";
        String customerID = "";
        String numOfSeats = "15";

        assertEquals(false, ticket.validateTicketDetails(flightID, customerID, numOfSeats));
    }

    /**
     * Test Case ID: TC-T-13
     * Requirement ID/Description: SR-F-06: The system shall allow the user to book a ticket for a customer
     * by entering a customer ID and choosing a flight, class, price, and number of seats for the ticket.
     * Purpose: Test that a user is able to book a ticket with an valid ticket details.
     * Test Setup: An instance of the TicketController class is created and the bookTicket() method
     * is invoked with the boolean isValid from passed in as a parameter resultant from the
     * validateTicketDetails() method. The assertEquals method is used to confirm that the supplied ticket details
     * were valid, and the ticket is successfully booked and inserted into the Ticket table.
     * Test Strategy: Use case testing was used to develop test cases for this requirement
     * Input: isValid = true, ticketid = "TO005", flightid = "FO003", custid = "CS004", flightclass = "Economy",
     * price = "9000", seats = "1", date = "2021-04-19"
     * Expected Output: "ticket booked"
     */

    @Test
    void validFlightBooking(){
        ticket = new TicketController();
        String ticketid = "TO005";
        String flightid = "FO003";
        String custid = "CS004";
        String flightclass = "Economy";
        String price = "9000";
        String seats = "1";
        String date = "2021-04-19";
        boolean isValid = true;

        assertEquals("ticket booked", ticket.bookTicket(isValid, ticketid, flightid, custid,
                flightclass,price, seats, date));
    }

    /**
     * Test Case ID: TC-T-14
     * Requirement ID/Description: SR-F-06: The system shall allow the user to book a ticket for a customer
     * by entering a customer ID and choosing a flight, class, price, and number of seats for the ticket.
     * Purpose: Test that a user is not able to book a ticket with an invalid ticket details.
     * Test Setup: An instance of the TicketController class is created and the bookTicket() method
     * is invoked with the boolean isValid from passed in as a parameter resultant from the
     * validateTicketDetails() method. The assertEquals method is used to confirm that the supplied ticket details
     * were invalid, and the ticket is not booked and not inserted into the Ticket table.
     * Test Strategy: Use case testing was used to develop test cases for this requirement
     * Input: isValid = false, ticketid = "TO005", flightid = "FO003", custid = "CS004", flightclass = "Economy",
     * price = "9000", seats = "1", date = "2021-04-19"
     * Expected Output: "ticket could not be booked"
     */

    @Test
    void invalidFlightBooking() {
        ticket = new TicketController();
        String ticketid = "TO005";
        String flightid = "";
        String custid = "";
        String flightclass = "";
        String price = "";
        String seats = "11";
        String date = "2021-04-19";
        boolean isValid = false;

        assertEquals("ticket could not be booked", ticket.bookTicket(isValid, ticketid, flightid, custid,
                flightclass,price, seats, date));
    }

    /**
     * Test Case ID: TC-T-15
     * Requirement ID/Description: SR-F-06: The system shall allow the user to book a ticket for a customer
     * by entering a customer ID and choosing a flight, class, price, and number of seats for the ticket.
     * Purpose: Test that a user is able to locate a customer's details using a valid customer ID.
     * Test Setup: An instance of the TicketController class is created and the searchForCustomer() method
     * is invoked with the customer ID passed as a parameter. The assertEquals method is used to confirm that
     * the customer's record was successfully located.
     * Test Strategy: Use case testing was used to develop test cases for this requirement
     * Input: custid = "CS004"
     * Expected Output: "Customer located"
     */

    @Test
    void validCustomerId(){
        ticket = new TicketController();
        String customerId = "CS001";

        assertEquals("Customer located", ticket.searchForCustomer(customerId));
    }

    /**
     * Test Case ID: TC-T-16
     * Requirement ID/Description: SR-F-06: The system shall allow the user to book a ticket for a customer
     * by entering a customer ID and choosing a flight, class, price, and number of seats for the ticket.
     * Purpose: Test that a user cannot locate a customer's details using an invalid customer ID.
     * Test Setup: An instance of the TicketController class is created and the searchForCustomer() method
     * is invoked with the customer ID passed as a parameter. The assertEquals method is used to confirm that
     * the customer's record was not located.
     * Test Strategy: Use case testing was used to develop test cases for this requirement
     * Input: custid = ""
     * Expected Output: "Record not found"
     */

    @Test
    void invalidCustomerId(){
        ticket = new TicketController();
        String customerId = "";

        assertEquals("Record not found", ticket.searchForCustomer(customerId));
    }

    /**
     * Test Case ID: TC-T-17
     * Requirement ID/Description: SR-F-06: The system shall allow the user to book a ticket for a customer
     * by entering a customer ID and choosing a flight, class, price, and number of seats for the ticket.
     * Purpose: Test that a user can locate a flight's details using a valid source and departure.
     * Test Setup: An instance of the TicketController class is created and the searchForTickets() method
     * is invoked with the source and departure passed as parameters. The assertEquals method is used to confirm that
     * the flight's record was located.
     * Test Strategy: Use case testing was used to develop test cases for this requirement
     * Input: source = "India", depart = "Uk"
     * Expected Output: "JetBlue"
     */

    @Test
    void flightExistsTest(){
        ticket = new TicketController();
        String source = "India";
        String depart = "Uk";

       assertEquals("JetBlue", ticket.searchForTickets(source, depart));
    }

    /**
     * Test Case ID: TC-T-18
     * Requirement ID/Description: SR-F-06: The system shall allow the user to book a ticket for a customer
     * by entering a customer ID and choosing a flight, class, price, and number of seats for the ticket.
     * Purpose: Test that a user cannot locate a flight's details using an invalid source and departure.
     * Test Setup: An instance of the TicketController class is created and the searchForTickets() method
     * is invoked with the source and departure passed as parameters. The assertEquals method is used to confirm that
     * the flight's record was not located.
     * Test Strategy: Use case testing was used to develop test cases for this requirement
     * Input: source = "China", depart = "China"
     * Expected Output: " "
     */

    @Test
    void flightDoesNotExistTest(){
        ticket = new TicketController();
        String source = "China";
        String depart = "China";

        assertEquals("", ticket.searchForTickets(source, depart));
    }

    /**
     * Instance of TicketController discarded upon tear down.
     */
    @AfterEach
    public void tearDown(){
        ticket = null;
    }
}
