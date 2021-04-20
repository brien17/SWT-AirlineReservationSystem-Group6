import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({
        UserTest.class,
        CustomerCreationTest.class,
        CustomerSearchTest.class,
        FlightAdditionTest.class,
        LoginTestUnit.class,
        MainTest.class,
        TicketControllerTest.class,
        UserTest.class
})
public class UnitTestSuite {

}