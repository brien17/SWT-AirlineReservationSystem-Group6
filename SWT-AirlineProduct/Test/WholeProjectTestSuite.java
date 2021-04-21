import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({
        LoginUnitTest.class,
        UserTest.class,
        CustomerCreationTest.class,
        CustomerSearchTest.class,
        FlightAdditionTest.class,
        MainTest.class,
        TicketControllerTest.class,
        LoginMainMockIntegrationTest.class,
        MainIntegrationTests.class,
        MainCustomerCreationIntegration.class,
        MainGuiTest.class,
        TicketControllerGuiTest.class
})
public class WholeProjectTestSuite {

}
