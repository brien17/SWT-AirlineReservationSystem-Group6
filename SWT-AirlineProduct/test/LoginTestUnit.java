import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class to perform unit testing on the Login class
 * Inputs were selected using decision table testing.
 */

public class LoginTestUnit {

    /**
     * Instance of the Login class used for testing
     */
    private Login login;

    /**
     * Assign a new Login object to login to setup for the test
     */
    @BeforeEach
    public void setup() {
        login = new Login();
    }

    /**
     * Make the login object null to cleanup after the test
     */
    @AfterEach
    public void tearDown() {
        login = null;
    }

    /**
     * Test Case ID: TC-L-01
     * Requirement ID/Description: SR-F-01  The system shall allow users to log in by providing a valid UserId and Password.
     * Purpose: Test that a user is able to log in by providing a valid UserId and Password
     * Test Setup: An instance of the Login class is created and the login method is called with a valid username and
     *              password passed into it as parameters. The output is compared to the expected output.
     * Test Strategy: A decision table was used to determine what inputs to test to test this functionality
     * Input: Username: “john”
     *        Password: “123”
     *        Main: new Main()
     *        sqlDriver: "com.mysql.jdbc.Driver"
     * Expected Output: "valid"
     */
    @Test
    public void validLoginTest() {
        String username = "john";
        String password = "123";
        String output = login.login(username, password, new Main(), "com.mysql.jdbc.Driver");
        assertEquals("valid", output);
    }

    /**
     * Test Case ID: TC-L-02
     * Requirement ID/Description: SR-F-01  The system shall allow users to log in by providing a valid UserId and Password.
     * Purpose: Test that a user will be denied access and a message will be displayed when providing an invalid UserId
     *          and Password combination.
     * Test Setup: An instance of the Login class is created and the login method is called with a valid username and
     *              an invalid password passed into it as parameters. The output is compared to the expected output.
     * Test Strategy: A decision table was used to determine what inputs to test to test this functionality
     * Input: Username: “john”
     *        Password: “password”
     *        Main: new Main()
     *        sqlDriver: "com.mysql.jdbc.Driver"
     * Expected Output: "UserName or Password do not Match"
     */
    @Test
    public void invalidLoginTest() {
        String username = "john";
        String password = "password";
        login.txtuser.setText(username);
        login.txtpass.setText(password);
        login.loginButton.doClick();
        String output = login.login(username, password, new Main(), "com.mysql.jdbc.Driver");

        assertEquals("UserName or Password do not Match", output);
    }

    /**
     * Test Case ID: TC-L-03
     * Requirement ID/Description: SR-F-01  The system shall allow users to log in by providing a valid UserId and Password.
     * Purpose: Test that a user will be denied access and a special message will be displayed when attempting to
     *          login with a blank UserId.
     * Test Setup: An instance of the Login class is created and the login method is called with a blank username and
     *              a non-blank password passed into it as parameters. The output is compared to the expected output.
     * Test Strategy: A decision table was used to determine what inputs to test to test this functionality
     * Input: Username: “”
     *        Password: “123”
     *        Main: new Main()
     *        sqlDriver: "com.mysql.jdbc.Driver"
     * Expected Output: "UserName or Password Blank"
     */
    @Test
    public void emptyUsernameLoginTest() {
        String username = "";
        String password = "123";
        String output = login.login(username, password, new Main(), "com.mysql.jdbc.Driver");

        assertEquals("UserName or Password Blank", output);
    }

    /**
     * Test Case ID: TC-L-04
     * Requirement ID/Description: SR-F-01  The system shall allow users to log in by providing a valid UserId and Password.
     * Purpose: Test that a user will be denied access and a special message will be displayed when attempting to
     *          login with a blank password.
     * Test Setup: An instance of the Login class is created and the login method is called with a non-blank username and
     *              a blank password passed into it as parameters. The output is compared to the expected output.
     * Test Strategy: A decision table was used to determine what inputs to test to test this functionality
     * Input: Username: “john”
     *        Password: “”
     *        Main: new Main()
     *        sqlDriver: "com.mysql.jdbc.Driver"
     * Expected Output: "UserName or Password Blank"
     */
    @Test
    public void emptyPasswordLoginTest() {
        String username = "john";
        String password = "";
        String output = login.login(username, password, new Main(), "com.mysql.jdbc.Driver");

        assertEquals("UserName or Password Blank", output);
    }


    /**
     * Test Case ID: TC-L-05
     * Requirement ID/Description: SR-F-01  The system shall allow users to log in by providing a valid UserId and Password.
     * Purpose: Test that a user will be denied access when a connection to the database cannot be established and
     *          that a message describing the error will be sent to the console and a message describing the error
     *          will be displayed to the user
     * Test Setup: An instance of the Login class is created and the login method is called with a valid username
     *              and password, a new instance of Main and a blank SQL driver string passed into it as parameters.
     *              The output is compared to the expected output.
     * Test Strategy: A decision table was used to determine what inputs to test to test this functionality
     * Input: Username: “john”
     *        Password: “123”
     *        Main: new Main()
     *        sqlDriver: ""
     * Expected Output: "Cannot connect to database"
     */
    @Test
    public void invalidSqlDriverTest() {
        String output = login.login("john", "123", new Main(), "");

        assertEquals("Cannot connect to database", output);
    }
}
