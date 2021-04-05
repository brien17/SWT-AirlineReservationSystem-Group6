import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTestIntegration {

    private Login login;

    @BeforeEach
    public void setup() {
        login = new Login();
    }

    @AfterEach
    public void tearDown() {
        login = null;
    }

    /**
     * Test Case ID: TC-05
     * Requirement ID/Description: SR-F-01  The system shall allow users to log in by providing a valid UserId and Password.
     * Purpose: Test that after a user supplies a correct userId and password the Main object will be made visible on
     *          the screen.
     * Test Setup: An instance of the Login class is created and the login method is called with a valid username and
     *             password combination and an instance of the MainMock passed into it as parameters. The output is
     *             compared to the expected output.
     * Test Strategy: TODO: Finish Me
     * Input: Username: “john”
     *        Password: “123”
     * Expected Output: true
     */
    @Test
    public void validLoginMockTest() {
        String username = "john";
        String password = "123";
        Main mainMock =  new MainMock();

        login.login(username, password, mainMock);
        assertTrue(mainMock.isVisible());
    }

    /**
     * Test Case ID: TC-06
     * Requirement ID/Description: SR-F-01  The system shall allow users to log in by providing a valid UserId and Password.
     * Purpose: Test that after a user supplies an invalid userId and password the Main object will not be made visible
     *          on the screen.
     * Test Setup: An instance of the Login class is created and the login method is called with a valid username and
     *             password combination and an instance of the MainMock passed into it as parameters. The output is
     *             compared to the expected output.
     * Test Strategy: TODO: Finish Me
     * Input: Username: “john”
     *        Password: “123”
     * Expected Output: false
     */
    @Test
    public void invalidLoginMockTest() {
        String username = "john";
        String password = "password";
        Main mainMock =  new MainMock();

        login.login(username, password, mainMock);
        assertFalse(mainMock.isVisible());
    }
}