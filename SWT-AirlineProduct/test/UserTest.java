import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserTest {
  // Declare and Create user object
  private UserCreationController add;

  // Initialize the user creation object
  @BeforeEach
  public void userBuild() {
    add = new UserCreationController();
  }

  /**
   * Purpose: A simple manual GUI testcase to assist with reaching line and branch coverage of UserCreationController
   * class. The test pulls button actions from UserCreationController to show that the system can perform button clicks
   * for the add button and the cancel button.
   */
  @Test
  public void userButtonTest() {

    add.addButtonActionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ""));
    add.cancelButtonActionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ""));
  }

  /**
   * Test Case ID: TC-U-01
   * Requirement ID/Description: SR-F-02: The system shall allow users to create an account by providing a first name,
   * last name, UserId and Password.
   * Purpose: Test that if a user were to provide a valid first name, last name, username, and password, a user would
   * be generated with a unique userID.
   * Test Setup: An instance of the UserCreationController class is created and the method add is called using a
   * sample set of String variables for firstname, lastname, username, and password while maintaining a connection
   * to the mySQL java database driver. An assertEquals method is used to confirm that the output is true,
   * thus a user has been created.
   * Test Strategy: Use case testing was used to develop test cases for this requirement
   * Input: "Cody", "Buckley", "testuser", "testpass", null, "com.mysql.jdbc.Driver"
   * Expected Output: "true"
   */
  // Positive Testing - Showing that a user is generated from clicking the add button
  @Test
  public void validUserTest() {
    // Sample inputs
    String firstname = "Cody";
    String lastname = "Buckley";
    String username = "testuser";
    String password = "testpass";
    Connection con = null;

    String output = add.add(firstname, lastname, username, password, con, "com.mysql.jdbc.Driver");
    assertEquals("true", output);
  }

  /**
   * Test Case ID: TC-U-02
   * Requirement ID/Description: SR-F-02: The system shall allow users to create an account by providing a first name,
   * last name, UserId and Password.
   * Purpose: Test that if a user were to input the correct login information without retaining a connection to the
   * database, that the system will error out.
   * Test Setup: An instance of the UserCreationController class is created and the method add is called using
   * a sample set of String variables for firstname, lastname, username, and password while lacking the connection
   * to the mySQL java database driver. An assertEquals method is used to confirm that the system returns an error.
   * Test Strategy: Use case testing was used to develop test cases for this requirement
   * Input: "Cody", "Buckley", "testuser", "testpass", null, ""
   * Expected Output: "error"
   */
  // Positive Testing - Showing that a user is generated from clicking the add button
  @Test
  public void invalidUserTest() {
    // Sample inputs
    String firstname = "Cody";
    String lastname = "Buckley";
    String username = "testuser";
    String password = "testpass";
    Connection con = null;

    String output = add.add(firstname, lastname, username, password, con, "");
    assertEquals("error", output);
  }

  /**
   * Test Case ID: TC-U-03
   * Requirement ID/Description: SR-F-02: The system shall allow users to create an account by providing a first name,
   * * last name, UserId and Password.
   * Purpose: Test the if statement within UserCreationController's method autoID generates a unique userID value
   * starting at "UO001" if there are no other userIDs in the user table of the database.
   * Test Setup: An instance of the UserCreationController class is created to run the autoID method and it passes the
   * connection driver to the mysql java database and a test value known as testNull in order to test the if statement
   * block by setting the test value to true. An assertEquals method is used to confirm the system creates a userID
   * "UO001".
   * Test Strategy: Use case testing was used to develop test cases for this requirement
   * Input: "com.mysql.jdbc.Driver", true
   * Expected Output: "UO001"
   */
  @Test
  public void emptyAutoIDTest() {

    String id = add.autoID("com.mysql.jdbc.Driver", true);
    assertEquals("UO001", id);

  }

  /**
   * Test Case ID: TC-U-04
   * Requirement ID/Description: SR-F-02: The system shall allow users to create an account by providing a first name,
   * * last name, UserId and Password.
   * Purpose: Test the autoID method to see if the database will automatically generate a unique userID incrementally
   * after a new user has been created.
   * Test Setup: An instance of the UserCreationController class is created to run the autoID method and it passes the
   * connection driver to the mysql java database and a test value known as testNull in order to test teh else statement
   * block by setting the test value to false. An assertEquals method is used to confirm teh system creates a userID
   * "UO006".
   * Test Strategy: Use case testing was used to develop test cases for this requirement
   * Input: "com.mysql.jdbc.Driver", false
   * Expected Output: "UO006"
   */
  @Test
  public void validAutoIDTest() {

    String id = add.autoID("com.mysql.jdbc.Driver", false);
    assertEquals("UO006", id);

  }

  /**
   * Test Case ID: TC-U-05
   * Requirement ID/Description: SR-F-02: The system shall allow users to create an account by providing a first name,
   * * last name, UserId and Password.
   * Purpose: Test the autoID method to see if the system will throw an exception if a connection to the database is not
   * securely connected.
   * Test Setup: An instance of the UserCreationController class is created to run the autoID method and it passes an
   * empty connection driver to the mysql java database and a test value known as testNull in order to test the else
   * statement block by setting the test value to false. An assertEquals method is used to confirm the system reaches
   * an exception by receiving "error".
   * Test Strategy: Use case testing was used to develop test cases for this requirement
   * Input: "", false
   * Expected Output: "error"
   */
  @Test
  public void invalidAutoIDTest() {

    String id = add.autoID("", false);
    assertEquals("error", id);

  }

  /**
   * Purpose: An AfterEach method that handles the removal of users from user table in the database in order to prevent
   * the table from being filled unnecessarily from the earlier test cases.
   * @throws ClassNotFoundException - an exception to be thrown in the case a proper connection to the database isn't made.
   * @throws SQLException - an exception thrown in the case that a proper connection to the database isn't made.
   */
  @AfterEach
  public void removeUser() throws ClassNotFoundException, SQLException {

    Connection con = null;
    PreparedStatement pst;
    String idOne = "UO006";

    Class.forName("com.mysql.jdbc.Driver");
    con = DriverManager.getConnection("jdbc:mysql://localhost/airline", "root", "");
    pst = con.prepareStatement("DELETE FROM user WHERE id = ?");

    pst.setString(1, idOne);

    pst.executeUpdate();
  }

  // Tear down the user creation object
  @AfterEach
  public void userTear() {
    add = null;
  }
}