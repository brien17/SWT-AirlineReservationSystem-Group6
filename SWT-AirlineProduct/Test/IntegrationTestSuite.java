import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

/**
 * This class serves as a test suite to run all of the integration tests
 */

@RunWith(JUnitPlatform.class)
@SelectClasses({
        LoginMainMockIntegrationTest.class,
        MainIntegrationTests.class,
        MainCustomerCreationIntegration.class
})
public class IntegrationTestSuite {

}