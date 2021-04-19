import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MainIntegrationTests {



    Main main;

    /**
     * TODO:
     */
    @BeforeEach
    void beforeEach() {
        main = new Main();
    }

    /**
     * TODO:
     */
    @AfterEach
    void afterEach() {
        main = null;
    }


    /**
     * TODO:
     * Test Case ID:
     * Requirement ID/Description:
     * Purpose:
     * Test Setup:
     * Test Strategy:
     * Input:
     * Expected Output:
     */
    @Test
    public void customerCreationControllerIntegrationTest() {
        CustomerCreationController customerCreationControllerMock = mock(CustomerCreationController.class);
        main.showCustomerCreation(customerCreationControllerMock);
        verify(customerCreationControllerMock, times(1)).setVisible(true);
    }

    /**
     * TODO:
     * Test Case ID:
     * Requirement ID/Description:
     * Purpose:
     * Test Setup:
     * Test Strategy:
     * Input:
     * Expected Output:
     */
    @Test
    public void flightAdditionControllerIntegration() {
        FlightAdditionController flightAdditionControllerMock = mock(FlightAdditionController.class);
        main.showAddFlight(flightAdditionControllerMock);
        verify(flightAdditionControllerMock, times(1)).setVisible(true);
    }
    /**
     * TODO:
     * Test Case ID:
     * Requirement ID/Description:
     * Purpose:
     * Test Setup:
     * Test Strategy:
     * Input:
     * Expected Output:
     */
    @Test
    public void ticketControllerIntegration() {
        TicketController ticketControllerMock = mock(TicketController.class);
        main.showBookTicket(ticketControllerMock);
        verify(ticketControllerMock, times(1)).setVisible(true);
    }
    /**
     * TODO:
     * Test Case ID:
     * Requirement ID/Description:
     * Purpose:
     * Test Setup:
     * Test Strategy:
     * Input:
     * Expected Output:
     */
    @Test
    public void ticketReportControllerIntegration() {
        TicketReportController ticketReportControllerMock = mock(TicketReportController.class);
        main.showTicketReport(ticketReportControllerMock);
        verify(ticketReportControllerMock, times(1)).setVisible(true);
    }
    /**
     * TODO:
     * Test Case ID:
     * Requirement ID/Description:
     * Purpose:
     * Test Setup:
     * Test Strategy:
     * Input:
     * Expected Output:
     */
    @Test
    public void searchCustomerControllerIntegration() {
        CustomerSearchController customerSearchControllerMock = mock(CustomerSearchController.class);
        main.showSearchCustomer(customerSearchControllerMock);
        verify(customerSearchControllerMock, times(1)).setVisible(true);
    }
    /**
     * TODO:
     * Test Case ID:
     * Requirement ID/Description:
     * Purpose:
     * Test Setup:
     * Test Strategy:
     * Input:
     * Expected Output:
     */
    @Test
    public void userCreationControllerIntegration() {
        UserCreationController userCreationControllerMock = mock(UserCreationController.class);
        main.showCreateUserScreen(userCreationControllerMock);
        verify(userCreationControllerMock, times(1)).setVisible(true);
    }
}
