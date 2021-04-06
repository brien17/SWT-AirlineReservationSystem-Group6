import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class LoginMainMockIntegration {

  @Mock
  Main mainMock;
  private Login login;

  @BeforeEach
  public void setup() {
    login = new Login();
    mainMock = mock(Main.class);
  }

  @AfterEach
  public void tearDown() {
    login = null;
    mainMock = null;
  }

  /**
   * Test Case ID: TC-05
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
   * Test Case ID: TC-06
   * Requirement ID/Description: SR-F-01  The system shall allow users to log in by providing a valid UserId and Password.
   * Purpose: Test that after a user supplies an invalid userId and password the Main object will not be made visible
   *          on the screen.
   * Test Setup: An instance of the Login class is created and the login method is called with a valid username and
   *             password combination and an instance of the MainMock passed into it as parameters. The output is
   *             compared to the expected output.
   * Test Strategy: Top down integration testing with mock
   * Input: Username: “john”
   *        Password: “123”
   * Expected Output: false
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
   * Test Case ID: TC-07
   * Requirement ID/Description: SR-F-01  The system shall allow users to log in by providing a valid UserId and Password.
   * Purpose: Test that after a user supplies an invalid userId and password the Main object will not be made visible
   *          on the screen.
   * Test Setup: An instance of the Login class is created and the login method is called with a valid username and
   *             password combination and an instance of the MainMock passed into it as parameters. The output is
   *             compared to the expected output.
   * Test Strategy: Top down integration testing with mock
   * Input: Username: “john”
   *        Password: “”
   * Expected Output: false
   */
  @Test
  public void blankUsernameLoginMockTest() {
    String username = "john";
    String password = "";

    login.login(username, password, mainMock, "com.mysql.jdbc.Driver");

    // Verify that setVisible was called zero times with it being set to true
    verify(mainMock, times(0)).setVisible(true);  }

  /**
   * Test Case ID: TC-08
   * Requirement ID/Description: SR-F-01  The system shall allow users to log in by providing a valid UserId and Password.
   * Purpose: Test that after a user supplies an invalid userId and password the Main object will not be made visible
   *          on the screen.
   * Test Setup: An instance of the Login class is created and the login method is called with a valid username and
   *             password combination and an instance of the MainMock passed into it as parameters. The output is
   *             compared to the expected output.
   * Test Strategy: Top down integration testing with mock
   * Input: Username: “john”
   *        Password: “”
   * Expected Output: false
   */
  @Test
  public void blankPasswordLoginMockTest() {
    String username = "";
    String password = "1";

    login.login(username, password, mainMock, "com.mysql.jdbc.Driver");

    // Verify that setVisible was called zero times with it being set to true
    verify(mainMock, times(0)).setVisible(true);  }

  // TODO: Give me comment
  @Test
  public void invalidSqlDriverTest() {
    login.login("john", "123", new Main(), "");

    // Verify that setVisible was called zero times with it being set to true
    verify(mainMock, times(0)).setVisible(true);  }
}
