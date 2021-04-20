
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

    @Test
    public void invalidBookingTest() {
        window.button("bookButton").click();
        window.dialog("dialog1").requireVisible();
        window.dialog("dialog1").button().click();
        window.dialog("dialog2").requireVisible();
        window.dialog("dialog2").button().click();
        window.dialog("dialog3").requireVisible();
        window.dialog("dialog3").button().click();
        window.button("cancelButton").click();
    }

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
        window.dialog("dialog0").requireVisible();
        window.dialog("dialog0").button().click();

    }



    @AfterEach
    public void tearDown() {
        window.cleanUp();
    }

}
