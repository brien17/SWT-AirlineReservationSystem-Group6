import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

/**
 * This class serves as a test suite to run all of the tests in the project
 */

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
