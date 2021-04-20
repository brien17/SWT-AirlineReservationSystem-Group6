import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


/**
 * TODO: technique used
 */
public class MainIntegrationTests {


    /**
     * Instance of the Main class used for testing
     */
    Main main;

    /**
     * Assigns a new Main object to main and calls the main method with a null parameter to setup for testing
     */
    @BeforeEach
    void beforeEach() {
        main = new Main();
    }

    /**
     * Makes the main object null to cleanup after the test
     */
    @AfterEach
    void afterEach() {
        main = null;
    }


    /**
     * Test Case ID: TC-M-07
     * Requirement ID/Description: SR-F-10: The system shall allow the user to open new screens from the Main menu
     * Purpose: Test that when a user opens the Add Customer screen the Main object makes the screen visible
     * Test Setup: An instance of the Main class is created and the showCustomerCreation method is called
     *                  with a mock CustomerCreationController passed in as a parameter. Then the test verifies
     *                  that the setVisible method was called on the mock once with the parameter 'true'
     * Test Strategy: Use case testing was used to develop this test case
     * Input: CustomerCreationController: CustomerCreationController Mock
     * Expected Output: true
     */
    @Test
    void customerCreationControllerIntegrationTest() {
        CustomerCreationController customerCreationControllerMock = mock(CustomerCreationController.class);
        main.showCustomerCreation(customerCreationControllerMock);
        verify(customerCreationControllerMock, times(1)).setVisible(true);
    }

    /**
     * Test Case ID: TC-M-08
     * Requirement ID/Description: SR-F-10: The system shall allow the user to open new screens from the Main menu
     * Purpose: Test that when a user opens the Add Flight screen the Main object makes the screen visible
     * Test Setup: An instance of the Main class is created and the showAddFlight method is called
     *                  with a mock FlightAdditionController passed in as a parameter. Then the test verifies
     *                  that the setVisible method was called on the mock once with the parameter 'true'
     * Test Strategy: Use case testing was used to develop this test case
     * Input: FlightAdditionController: FlightAdditionController Mock
     * Expected Output: true
     */
    @Test
    void flightAdditionControllerIntegration() {
        FlightAdditionController flightAdditionControllerMock = mock(FlightAdditionController.class);
        main.showAddFlight(flightAdditionControllerMock);
        verify(flightAdditionControllerMock, times(1)).setVisible(true);
    }

    /**
     * Test Case ID: TC-M-09
     * Requirement ID/Description: SR-F-10: The system shall allow the user to open new screens from the Main menu
     * Purpose: Test that when a user opens the Book Ticket screen the Main object makes the screen visible
     * Test Setup: An instance of the Main class is created and the showBookTicket method is called
     *                  with a mock TicketController passed in as a parameter. Then the test verifies
     *                  that the setVisible method was called on the mock once with the parameter 'true'
     * Test Strategy: Use case testing was used to develop this test case
     * Input: TicketController: TicketController Mock
     * Expected Output: true
     */
    @Test
    void ticketControllerIntegration() {
        TicketController ticketControllerMock = mock(TicketController.class);
        main.showBookTicket(ticketControllerMock);
        verify(ticketControllerMock, times(1)).setVisible(true);
    }

    /**
     * Test Case ID: TC-M-10
     * Requirement ID/Description: SR-F-10: The system shall allow the user to open new screens from the Main menu
     * Purpose: Test that when a user opens the Ticket Report screen the Main object makes the screen visible
     * Test Setup: An instance of the Main class is created and the showTicketReport method is called
     *                  with a mock TicketReportController passed in as a parameter. Then the test verifies
     *                  that the setVisible method was called on the mock once with the parameter 'true'
     * Test Strategy: Use case testing was used to develop this test case
     * Input: TicketReportController: TicketReportController Mock
     * Expected Output: true
     */
    @Test
    void ticketReportControllerIntegration() {
        TicketReportController ticketReportControllerMock = mock(TicketReportController.class);
        main.showTicketReport(ticketReportControllerMock);
        verify(ticketReportControllerMock, times(1)).setVisible(true);
    }

    /**
     * Test Case ID: TC-M-11
     * Requirement ID/Description: SR-F-10: The system shall allow the user to open new screens from the Main menu
     * Purpose: Test that when a user opens the Search Customer screen the Main object makes the screen visible
     * Test Setup: An instance of the Main class is created and the showSearchCustomer method is called
     *                  with a mock CustomerSearchController passed in as a parameter. Then the test verifies
     *                  that the setVisible method was called on the mock once with the parameter 'true'
     * Test Strategy: Use case testing was used to develop this test case
     * Input: CustomerSearchController: CustomerSearchController Mock
     * Expected Output: true
     */
    @Test
    void searchCustomerControllerIntegration() {
        CustomerSearchController customerSearchControllerMock = mock(CustomerSearchController.class);
        main.showSearchCustomer(customerSearchControllerMock);
        verify(customerSearchControllerMock, times(1)).setVisible(true);
    }

    /**
     * Test Case ID: TC-M-12
     * Requirement ID/Description: SR-F-10: The system shall allow the user to open new screens from the Main menu
     * Purpose: Test that when a user opens the Add User screen the Main object makes the screen visible
     * Test Setup: An instance of the Main class is created and the showCreateUserScreen method is called
     *                  with a mock UserCreationController passed in as a parameter. Then the test verifies
     *                  that the setVisible method was called on the mock once with the parameter 'true'
     * Test Strategy: Use case testing was used to develop this test case
     * Input: UserCreationController: UserCreationController Mock
     * Expected Output: true
     */
    @Test
    void userCreationControllerIntegration() {
        UserCreationController userCreationControllerMock = mock(UserCreationController.class);
        main.showCreateUserScreen(userCreationControllerMock);
        verify(userCreationControllerMock, times(1)).setVisible(true);
    }
}
