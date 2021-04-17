import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;



public class MainTest {

  /** input selection strategy */
  private Main main;

  @BeforeEach
  public void setup() {
    main = new Main();
  }

  @AfterEach
  public void tearDown() {
    main = null;
  }

  @Test
  void testOpenMain() {
    try {
    Main.main(null);
    main.setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
    assertTrue(main.isVisible());
  }

  @Test
  void testAddCustomerButton() {
    main = new Main();
    main.addCustomerButtonClicked(null);
    // Check that the controller has been added to the layout pane
    assertTrue(main.jDesktopPane1.getComponents()[0] instanceof CustomerCreationController);
  }

  @Test
  void testSearchCustomerCreationButton() {
    main.searchCustomerButtonClicked(null);
    // Check that the controller has been added to the layout pane
    assertTrue(main.jDesktopPane1.getComponents()[0] instanceof CustomerSearchController);
  }

  @Test
  void testAddFlightButton() {
    main.addFlightButtonClicked(null);
    // Check that the controller has been added to the layout pane
    assertTrue(main.jDesktopPane1.getComponents()[0] instanceof FlightAdditionController);
  }

  @Test
  void testBookTicketButton() {
    main.bookTicketButtonClicked(null);
    // Check that the controller has been added to the layout pane
    assertTrue(main.jDesktopPane1.getComponents()[0] instanceof TicketController);
  }

  @Test
  void testShowTicketReport() {
    main.ticketReportButtonClicked(null);
    // Check that the controller has been added to the layout pane
    assertTrue(main.jDesktopPane1.getComponents()[0] instanceof TicketReportController);
  }

  @Test
  void testCreateUserButton() {
    main.createUserButtonClicked(null);
    // Check that the controller has been added to the layout pane
    assertTrue(main.jDesktopPane1.getComponents()[0] instanceof UserCreationController);
  }

}
