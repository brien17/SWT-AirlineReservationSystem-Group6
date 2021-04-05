import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.util.Arrays;

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
  void testShowTicketReport() {
    TicketReportController ticketReportController = new TicketReportControllerStub();
    main.showTicketReport(ticketReportController);

    // Check that the stub controller has been added to the layout pane
    assertTrue(Arrays.asList(main.jDesktopPane1.getComponents()).contains(ticketReportController));
  }
}
