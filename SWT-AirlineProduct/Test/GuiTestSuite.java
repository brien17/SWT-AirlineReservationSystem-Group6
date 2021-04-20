import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({MainGuiTest.class,TicketControllerGuiTest.class})
public class GuiTestSuite {

}