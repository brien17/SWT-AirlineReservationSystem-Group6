import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class to perform unit testing on the Main class
 * Inputs were selected using use case testing.
 */

public class MainTest {

  /**
   * Instance of the Main class used for testing
   */
  private Main main;

  /**
   * Assigns a new Main object to main and calls the main method with a null parameter to setup for testing
   */
  @BeforeEach
  public void setup() {
    main = new Main();
  }

  /**
   * Makes the main object null to cleanup after the test
   */
  @AfterEach
  public void tearDown() {
    main = null;
  }

  /**
   * Test Case ID: TC-M-01
   * Requirement ID/Description: SR-F-10: The system shall allow the user to open new screens from the Main menu
   * Purpose: Test that a user is able open the Add Customer screen and that it added to the Main desktop pane
   * Test Setup: An instance of the Main class is created and the addCustomerButtonClicked method is invoked with
   *              null passed in as the parameter, then the assertTrue method is used confirm that an instance of the
   *              CustomerCreationContoller is added to the desktop pane
   * Test Strategy: Use case testing was used to develop test cases for this requirement
   * Input: ActionEvent: null
   * Expected Output: true
   */
  @Test
  void testAddCustomerButton() {
    main.addCustomerButtonClicked(null);
    // Check that the controller has been added to the layout pane
    assertTrue(main.jDesktopPane1.getComponents()[0] instanceof CustomerCreationController);
  }

  /**
   * Test Case ID: TC-M-02
   * Requirement ID/Description: SR-F-10: The system shall allow the user to open new screens from the Main menu
   * Purpose: Test that a user is able open the Customer Search screen and that it added to the Main desktop pane
   * Test Setup: An instance of the Main class is created and the searchCustomerButtonClicked method is invoked with
   *              null passed in as the parameter, then the assertTrue method is used confirm that an instance of the
   *              CustomerSearchController is added to the desktop pane
   * Test Strategy: Use case testing was used to develop test cases for this requirement
   * Input: ActionEvent: null
   * Expected Output: true
   */
  @Test
  void testSearchCustomerCreationButton() {
    main.searchCustomerButtonClicked(null);
    // Check that the controller has been added to the layout pane

    assertTrue(main.jDesktopPane1.getComponents()[0] instanceof CustomerSearchController);
  }

  /**
   * Test Case ID: TC-M-03
   * Requirement ID/Description: SR-F-10: The system shall allow the user to open new screens from the Main menu
   * Purpose: Test that a user is able open the Add Flight screen and that it added to the Main desktop pane
   * Test Setup: An instance of the Main class is created and the addFlightButtonClicked method is invoked with
   *              null passed in as the parameter, then the assertTrue method is used confirm that an instance of the
   *              FlightAdditionController is added to the desktop pane.
   * Test Strategy: Use case testing was used to develop test cases for this requirement
   * Input: ActionEvent: null
   * Expected Output: true
   */
  @Test
  void testAddFlightButton() {
    main.addFlightButtonClicked(null);
    // Check that the controller has been added to the layout pane
    assertTrue(main.jDesktopPane1.getComponents()[0] instanceof FlightAdditionController);
  }

  /**
   * Test Case ID: TC-M-04
   * Requirement ID/Description: SR-F-10: The system shall allow the user to open new screens from the Main menu
   * Purpose: Test that a user is able open the Book Ticket screen and that it added to the Main desktop pane
   * Test Setup: An instance of the Main class is created and the searchCustomerButtonClicked method is invoked with
   *              null passed in as the parameter, then the assertTrue method is used confirm that an instance of the
   *              TicketController is added to the desktop pane
   * Test Strategy: Use case testing was used to develop test cases for this requirement
   * Input: ActionEvent: null
   * Expected Output: true
   */
  @Test
  void testBookTicketButton() {
    main.bookTicketButtonClicked(null);
    // Check that the controller has been added to the layout pane
    assertTrue(main.jDesktopPane1.getComponents()[0] instanceof TicketController);
  }

  /**
   * Test Case ID: TC-M-05
   * Requirement ID/Description: SR-F-10: The system shall allow the user to open new screens from the Main menu
   * Purpose: Test that a user is able open the Ticket Report screen and that it added to the Main desktop pane
   * Test Setup: An instance of the Main class is created and the searchCustomerButtonClicked method is invoked with
   *              null passed in as the parameter, then the assertTrue method is used confirm that an instance of the
   *              TicketReportController is added to the desktop pane
   * Test Strategy: Use case testing was used to develop test cases for this requirement
   * Input: ActionEvent: null
   * Expected Output: true
   */
  @Test
  void testShowTicketReport() {
    main.ticketReportButtonClicked(null);
    // Check that the controller has been added to the layout pane
    assertTrue(main.jDesktopPane1.getComponents()[0] instanceof TicketReportController);
  }

  /**
   * Test Case ID: TC-M-06
   * Requirement ID/Description: SR-F-10: The system shall allow the user to open new screens from the Main menu
   * Purpose: Test that a user is able open the Add User screen and that it added to the Main desktop pane
   * Test Setup: An instance of the Main class is created and the searchCustomerButtonClicked method is invoked with
   *              null passed in as the parameter, then the assertTrue method is used confirm that an instance of the
   *              UserCreationController is added to the desktop pan
   * Test Strategy: Use case testing was used to develop test cases for this requirement
   * Input: ActionEvent: null
   * Expected Output: true
   */
  @Test
  void testCreateUserButton() {
    main.createUserButtonClicked(null);
    // Check that the controller has been added to the layout pane
    assertTrue(main.jDesktopPane1.getComponents()[0] instanceof UserCreationController);
  }

}
