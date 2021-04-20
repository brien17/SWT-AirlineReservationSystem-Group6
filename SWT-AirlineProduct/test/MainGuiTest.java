import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.testing.AssertJSwingTestCaseTemplate;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainGuiTest extends AssertJSwingTestCaseTemplate {

    FrameFixture window;

    @BeforeEach
    public void setUp() {
        Main container = GuiActionRunner.execute(Main::new);
        window = new FrameFixture(container);
        window.show();
    }

    @Test
    public void customerMenuTest() {
        window.menuItem("customerMenu")
                .click()
                .requireVisible();
    }

    @Test
    public void ticketMenuTest(){
        window.menuItem("ticketMenu")
                .click()
                .requireVisible();
    }

    @Test
    public void flightMenuTest() {
        window.menuItem("flightMenu")
                .click()
                .requireVisible();
    }

    @Test
    public void userMenuTest() {
        window.menuItem("userMenu")
                .click()
                .requireVisible();
    }

    @AfterEach
    public void tearDown() {
        window.cleanUp();
    }
}
