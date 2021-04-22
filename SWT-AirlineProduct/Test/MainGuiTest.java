

import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.testing.AssertJSwingTestCaseTemplate;



import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class MainGuiTest extends AssertJSwingTestCaseTemplate {

    FrameFixture window;

    /**
     * Instance of Main is used for the AssertJ GuiActionRunner for GUI testing.
     */
    @BeforeEach
    public void setUp() {
        Main container = GuiActionRunner.execute(Main::new);
        window = new FrameFixture(container);
        window.show();
    }

    /**
     * Test Case ID: TC-MG-01
     * Requirement ID/Description: SR-F-10: The system shall allow the user to open new screens from the Main menu
     * Purpose: Test that a user is able open the Customer menu and view submenu items.
     * Test Setup: An instance of the Main class is created and and set as the window to be tested. The Customer
     * menuItem is clicked and the test method requires the drop down menu to be visible.
     * Test Strategy: Use case testing was used to develop test cases for this requirement
     * Input: click() instantiates ActionEvent
     * Expected Output: Drop down menu displays Add Customer and Search Customer submenu items.
     */
    @Test
    public void customerMenuTest() {
        window.menuItem("customerMenu")
                .click()
                .requireVisible();
    }

    /**
     * Test Case ID: TC-MG-02
     * Requirement ID/Description: SR-F-10: The system shall allow the user to open new screens from the Main menu
     * Purpose: Test that a user is able open the Tickets menu and view submenu items.
     * Test Setup: An instance of the Main class is created and and set as the window to be tested. The Tickets
     * menuItem is clicked and the test method requires the drop down menu to be visible.
     * Test Strategy: Use case testing was used to develop test cases for this requirement
     * Input: click() instantiates ActionEvent
     * Expected Output: Drop down menu displays Book Ticket and Ticket Report  submenu items.
     */
    @Test
    public void ticketMenuTest(){
        window.menuItem("ticketMenu")
                .click()
                .requireVisible();
    }

    /**
     * Test Case ID: TC-MG-03
     * Requirement ID/Description: SR-F-10: The system shall allow the user to open new screens from the Main menu
     * Purpose: Test that a user is able open the Flight menu and view submenu items.
     * Test Setup: An instance of the Main class is created and and set as the window to be tested. The Flight
     * menuItem is clicked and the test method requires the drop down menu to be visible.
     * Test Strategy: Use case testing was used to develop test cases for this requirement
     * Input: click() instantiates ActionEvent
     * Expected Output: Drop down menu displays Add Flight submenu item.
     */
    @Test
    public void flightMenuTest() {
        window.menuItem("flightMenu")
                .click()
                .requireVisible();
    }

    /**
     * Test Case ID: TC-MG-04
     * Requirement ID/Description: SR-F-10: The system shall allow the user to open new screens from the Main menu
     * Purpose: Test that a user is able open the Flight menu and view submenu items.
     * Test Setup: An instance of the Main class is created and and set as the window to be tested. The User
     * menuItem is clicked and the test method requires the drop down menu to be visible.
     * Test Strategy: Use case testing was used to develop test cases for this requirement
     * Input: click() instantiates ActionEvent
     * Expected Output: Drop down menu displays Add User submenu item.
     */
    @Test
    public void userMenuTest() {
        window.menuItem("userMenu")
                .click()
                .requireVisible();
    }

    /**
     * AssertJ FrameFixture discarded upon tear down.
     */
    @AfterEach
    public void tearDown() {
        window.cleanUp();
    }
}
