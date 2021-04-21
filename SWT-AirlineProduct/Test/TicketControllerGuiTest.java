
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.Containers;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.testing.AssertJSwingTestCaseTemplate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicketControllerGuiTest extends AssertJSwingTestCaseTemplate {

   private FrameFixture window;
   private javax.swing.JDesktopPane t;

    @BeforeEach
    public void setUp(){
        TicketController test = GuiActionRunner.execute(TicketController::new);
        t = new javax.swing.JDesktopPane();
        t.add(test);
        test.setVisible(true);
        window = new FrameFixture(Containers.frameFor(test));
        window.show();
    }
   
   /**
     * Test Case ID: TC-TG-1
     * Requirement ID/Description: SR-F-06: The system shall allow the user to book a ticket for a customer
     * by entering a customer ID and choosing a flight, class, price, and number of seats for the ticket.
     * Purpose: Test that a user is not able to book a ticket with an invalid ticket details and informational
     * dialog boxes are displayed to the user.
     * Test Setup: An instance of the TicketController class is created and set as the window to be tested. The book
     * button is clicked and the test method requires all necessary dialog boxes be displayed.
     * Test Strategy: Use case testing was used to develop test cases for this requirement
     * Input: click() instantiates ActionEvent
     * Expected Output: Dialogs displaying "Number of seats must be greater than 0 and less than 10”, “Flight number
     * and/or customer id cannot be empty", and "Ticket could not be booked."
     */

    @Test
    public void invalidBookingTest() {
        window.button("bookButton").click();
        window.dialog().requireVisible();
        window.dialog().button().click();
        window.dialog().requireVisible();
        window.dialog().button().click();
        window.dialog().requireVisible();
        window.dialog().button().click();
        window.button("cancelButton").click();
    }
   
   /**
     * Test Case ID: TC-TG-2
     * Requirement ID/Description: SR-F-06: The system shall allow the user to book a ticket for a customer
     * by entering a customer ID and choosing a flight, class, price, and number of seats for the ticket.
     * Purpose: Test that a user is not able to book a ticket with an invalid ticket details and informational
     * dialog boxes are displayed to the user.
     * Test Setup: An instance of the TicketController class is created and set as the window to be tested. Valid
     * source and departure locations and searched, followed by selection of resulting flight. Valid customer ID is
     * searched and populates details and seat is incremented by one. The book button is clicked requiring a
     * confirmation message is displayed.
     * Test Strategy: Use case testing was used to develop test cases for this requirement
     * Input: click() instantiates ActionEvent
     * Expected Output: Dialog displaying "Ticket booked.”
     */

    @Test
    public void validBookingTest() {
        window.comboBox("source").selectItem("India");
        window.comboBox("depart").selectItem("Uk");
        window.button("searchFlightsButton").click();
        window.table("flightMenu").selectRows(0);
        window.textBox("customerId").enterText("CS004");
        window.button("searchCustomerButton").click();
        window.spinner("seats").increment(1);
        window.button("bookButton").click();
        window.dialog().requireVisible();
        window.dialog().button().click();

    }



    @AfterEach
    public void tearDown() {
        window.cleanUp();
    }

}
