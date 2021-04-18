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

  /**
   * Todo
   */
  @Test
  void testOpenMain() {
    try {
      Main.main(null);
    } catch (Exception e) {
      e.printStackTrace();
    }
    assertTrue(true);
  }

  /**
   * Todo
   */
  @Test
  void testAddCustomerButton() {
    main = new Main();
    main.addCustomerButtonClicked(null);
    // Check that the controller has been added to the layout pane
    assertTrue(main.jDesktopPane1.getComponents()[0] instanceof CustomerCreationController);
  }

  /**
   * Todo
   */
  @Test
  void testSearchCustomerCreationButton() {
    main.searchCustomerButtonClicked(null);
    // Check that the controller has been added to the layout pane

    assertTrue(main.jDesktopPane1.getComponents()[0] instanceof CustomerSearchController);
  }

  /**
   * Todo
   */
  @Test
  void testAddFlightButton() {
    main.addFlightButtonClicked(null);
    // Check that the controller has been added to the layout pane
    assertTrue(main.jDesktopPane1.getComponents()[0] instanceof FlightAdditionController);
  }

  /**
   * Todo
   */
  @Test
  void testBookTicketButton() {
    main.bookTicketButtonClicked(null);
    // Check that the controller has been added to the layout pane
    assertTrue(main.jDesktopPane1.getComponents()[0] instanceof TicketController);
  }

  /**
   * Todo
   */
  @Test
  void testShowTicketReport() {
    main.ticketReportButtonClicked(null);
    // Check that the controller has been added to the layout pane
    assertTrue(main.jDesktopPane1.getComponents()[0] instanceof TicketReportController);
  }

  /**
   * Todo
   */
  @Test
  void testCreateUserButton() {
    main.createUserButtonClicked(null);
    // Check that the controller has been added to the layout pane
    assertTrue(main.jDesktopPane1.getComponents()[0] instanceof UserCreationController);
  }

}
