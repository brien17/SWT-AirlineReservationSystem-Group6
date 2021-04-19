import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;



public class FlightAdditionTest {

  @Mock
  List mockedList;

  FlightAdditionController flightAdditionTest = null;
  @BeforeEach
  public void setUp(){

    flightAdditionTest = new FlightAdditionController();

  }
  @AfterEach
  public void tearDown() {
    flightAdditionTest = null;
  }

  /**
   * Test Case ID: TC - 15
   * Requirement ID/Description: SR-F-05 The system shall allow users to create flights by
   *     entering a flight name, source, destination, date, departure time, arrival time,
   *     and the price of the flight.
   * Purpose: Test that a user is able to add a valid flight to the database.
   * Test Setup: An instance of the FlightAdditionController class is created.
   * Test Strategy: Unidimensional equivalence class partitioning
   * Input: India Air,	India,	Usa	,2021-04-01,	12:00 PM,	1:00 PM	, $100
   * Expected Output: "valid"
   */
  @Test
  public void testValidFlight() {
    flightAdditionTest.airlineNameInput.setText("India Air");
    flightAdditionTest.sourceInput.setSelectedItem("India");
    flightAdditionTest.destinationInput.setSelectedItem("Usa");

    String date = "2021-04-01";
    try {
      java.util.Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
      flightAdditionTest.dateInput.setDate(date2);

    } catch (java.text.ParseException ex){
      System.out.println(ex.getMessage());
    }
    flightAdditionTest.departureTimeInput.setText("12:00 PM");
    flightAdditionTest.arrivalTimeInput.setText("1:00 PM");
    flightAdditionTest.flightChargeInput.setText("$100");

    flightAdditionTest.generateFlightID("test");

    String output = flightAdditionTest.addFlightActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));
    assertEquals("valid", output);
//    new ActionEvent(this,ActionEvent.ACTION_PERFORMED,"")
  }

  /**
   * Test Case ID:
   * Requirement ID/Description:
   * Purpose: Test that a user is prevented from adding an invalid flight to the database.
   * Test Setup:
   * Test Strategy:
   * Input: 5,	India,	India	,1975-04-01,	13:00 PM,	13:00 AM	, n/a
   * Expected Output: "valid"
   */

  /**
   * Test Case ID: TC - 16
   * Requirement ID/Description: SR-F-05 The system shall allow users to create flights by
   *     entering a flight name, source, destination, date, departure time, arrival time,
   *     and the price of the flight.
   * Purpose: Test that a user is unable to add an invalid flight to the database.
   * Test Setup: An instance of the FlightAdditionController class is created.
   * Test Strategy: Unidimensional equivalence class partitioning
   * Input: 5,	India,	India	,1975-04-01,	13:00 PM,	13:00 AM	, n/a
   * Expected Output: ""
   */
  @Test
  public void testInvalidFlight() {
    flightAdditionTest.airlineNameInput.setText("5");
    flightAdditionTest.sourceInput.setSelectedItem("India");
    flightAdditionTest.destinationInput.setSelectedItem("India");

    String date = "1975-04-01";
    try {
      java.util.Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
      flightAdditionTest.dateInput.setDate(date2);

    } catch (java.text.ParseException ex){
      System.out.println(ex.getMessage());
    }
    flightAdditionTest.departureTimeInput.setText("13:00 PM");
    flightAdditionTest.arrivalTimeInput.setText("13:00 AM");
    flightAdditionTest.flightChargeInput.setText("n/a");

    String output = flightAdditionTest.addFlightActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));
    /*
    Error stack trace should be clean in the console, new flight should not be
    added to the database, and error message should be given to user explaining
    why the input is invalid
     */
    assertEquals("", output);

  }


  /**
   * Test Case ID:
   * Requirement ID/Description:
   * Purpose: Test that a user is able to add a valid flight to the database.
   * Test Setup:
   * Test Strategy:
   * Expected Output: "valid"
   */
  /**
   * Test Case ID: TC - 17
   * Requirement ID/Description: SR-F-05 The system shall allow users to create flights by
   *     entering a flight name, source, destination, date, departure time, arrival time,
   *     and the price of the flight.
   * Purpose: Test that a user is given an error message without runtime errors for null inputs.
   * Test Setup: An instance of the FlightAdditionController class is created.
   * Test Strategy: Unidimensional equivalence class partitioning
   * Input: "",	India,	India	, null Date,	"",	""	, ""
   * Expected Output: ""
   */
  @Test
  public void testEmptyFlight() {

    String output = flightAdditionTest.addFlightActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));
    /*
    Error stack trace should be clean in the console, new flight should not be
    added to the database, and error message should be given to user that there
    are inputs missing
     */
    assertEquals("", output);
  }
}
