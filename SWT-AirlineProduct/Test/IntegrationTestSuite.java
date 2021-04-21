import org.junit.Test;
import org.junit.Assert;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({
        LoginMainMockIntegrationTest.class,
        MainIntegrationTests.class,
        MainCustomerCreationIntegration.class
})
public class IntegrationTestSuite {

}