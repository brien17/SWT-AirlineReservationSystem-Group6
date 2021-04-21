import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

/**
 * This class serves as a test suite to run all of the GUI tests
 */

@RunWith(JUnitPlatform.class)
@SelectClasses({
        MainGuiTest.class,
        TicketControllerGuiTest.class
})
public class GuiTestSuite {

}