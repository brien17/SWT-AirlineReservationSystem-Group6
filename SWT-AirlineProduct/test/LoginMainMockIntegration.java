import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;


/**
 * Test class to perform integration testing on the Login class
 * Integration testing is performed using the top down integration method. The individual test cases
 * are derived from a decision table to test the interaction between the Login class and the Main class and ensure
 * that the Login class is calling the correct method from the Main class with the correct parameter.
 */
public class LoginMainMockIntegration {

  /**
   * Mock of the Main class used for testing
   */
  @Mock
  Main mainMock;

  /**
   * Instance of the Login class used for testing
   */
  private Login login;

  /**
   * Assign a new Login object to login and a mock of the Main class to mainMock to setup for testing
   */
  @BeforeEach
  public void setup() {
    login = new Login();
    mainMock = mock(Main.class);
  }

  /**
   * Make the login and mainMock objects null to cleanup after the test
   */
  @AfterEach
  public void tearDown() {
    login = null;
    mainMock = null;
  }

  /**
   * Test Case ID: TC-L-06
   * Requirement ID/Description: SR-F-01  The system shall allow users to log in by providing a valid UserId and Password.
   * Purpose: Test that after a user supplies a correct userId and password the Main object will be made visible on
   *          the screen.
   * Test Setup: An instance of the Login class is created and the login method is called with a valid username and
   *             password combination and an instance of the MainMock passed into it as parameters. The output is
   *             compared to the expected output.
   * Test Strategy: Top down integration testing with mock
   * Input: Username: “john”
   *        Password: “123”
   * Expected Output: true
   */
  @Test
  public void validLoginMockTest() {
    String username = "john";
    String password = "123";

    login.login(username, password, mainMock, "com.mysql.jdbc.Driver");

    // Verify that setVisible was called once with it being set to true
    verify(mainMock, times(1)).setVisible(true);
  }

  /**
   * Test Case ID: TC-L-07
   * Requirement ID/Description: SR-F-01  The system shall allow users to log in by providing a valid UserId and Password.
   * Purpose: Test that after a user supplies an invalid userId and password the Main object will not be made visible
   *          on the screen.
   * Test Setup: An instance of the Login class is created and the login method is called with an invalid username and
   *             password combination and an instance of the MainMock passed into it as parameters. The output is
   *             compared to the expected output.
   * Test Strategy: Top down integration testing with mock
   * Input: Username: “john”
   *        Password: “password”
   * Expected Output: true
   */
  @Test
  public void invalidLoginMockTest() {
    String username = "john";
    String password = "password";

    login.login(username, password, mainMock, "com.mysql.jdbc.Driver");

    // Verify that setVisible was called zero times with it being set to true
    verify(mainMock, times(0)).setVisible(true);
  }

  /**
   * Test Case ID: TC-L-08
   * Requirement ID/Description: SR-F-01  The system shall allow users to log in by providing a valid UserId and Password.
   * Purpose: Test that after a user supplies an invalid userId and password the Main object will not be made visible
   *          on the screen.
   * Test Setup: An instance of the Login class is created and the login method is called with a valid username and
   *             password combination and an instance of the MainMock passed into it as parameters. The output is
   *             compared to the expected output.
   * Test Strategy: Top down integration testing with mock
   * Input: Username: “john”
   *        Password: “”
   * Expected Output: true
   */
  @Test
  public void blankUsernameLoginMockTest() {
    String username = "";
    String password = "123";

    login.login(username, password, mainMock, "com.mysql.jdbc.Driver");

    // Verify that setVisible was called zero times with it being set to true
    verify(mainMock, times(0)).setVisible(true);
  }

  /**
   * Test Case ID: TC-L-09
   * Requirement ID/Description: SR-F-01  The system shall allow users to log in by providing a valid UserId and Password.
   * Purpose: Test that after a user supplies an invalid userId and password the Main object will not be made visible
   *          on the screen.
   * Test Setup: An instance of the Login class is created and the login method is called with a valid username and
   *             blank password and an instance of the MainMock passed into it as parameters. The output is
   *             compared to the expected output.
   * Test Strategy: Top down integration testing with mock
   * Input: Username: “john”
   *        Password: “”
   * Expected Output: true
   */
  @Test
  public void blankPasswordLoginMockTest() {
    String username = "john";
    String password = "";

    login.login(username, password, mainMock, "com.mysql.jdbc.Driver");

    // Verify that setVisible was called zero times with it being set to true
    verify(mainMock, times(0)).setVisible(true);
  }

  /**
   * Test Case ID: TC-L-10
   * Requirement ID/Description: SR-F-01  The system shall allow users to log in by providing a valid UserId and Password.
   * Purpose: Test that if a connection to the database cannot be made the Main object will not be made visible
   *          on the screen.
   * Test Setup: An instance of the Login class is created and the login method is called with a valid username and
   *             password combination, an instance of the MainMock, and an invalid sql driver name passed into it as
   *             parameters. The output is compared to the expected output.
   * Test Strategy: Top down integration testing with mock
   * Input: Username: “john”
   *        Password: “123”
   * Expected Output: true
   */
  @Test
  public void invalidSqlDriverTest() {
    login.login("john", "123", mainMock, "");

    // Verify that setVisible was called zero times with it being set to true
    verify(mainMock, times(0)).setVisible(true);
  }
}
