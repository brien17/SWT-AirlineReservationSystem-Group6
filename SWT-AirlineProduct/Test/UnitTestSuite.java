import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

/**
 * This class serves as a test suite to run all of the unit tests
 */

@RunWith(JUnitPlatform.class)
@SelectClasses({
        UserTest.class,
        CustomerCreationTest.class,
        CustomerSearchTest.class,
        FlightAdditionTest.class,
        LoginUnitTest.class,
        MainTest.class,
        TicketControllerTest.class,
})


public class
UnitTestSuite {

}
