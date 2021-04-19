import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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

  @Test
  public void addButtonTest() {

    add.addButtonActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));
  }

  @Test
  public void cancelButtonTest() {

    add.cancelButtonActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));
  }

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

  @Test
  public void emptyAutoIDTest() {

    String id = add.autoID("com.mysql.jdbc.Driver", true);
    assertEquals("UO001", id);

  }

  @Test
  public void validAutoIDTest() {

    String id = add.autoID("com.mysql.jdbc.Driver", false);
    assertEquals("UO006", id);

  }

  @Test
  public void invalidAutoIDTest() {

    String id = add.autoID("", false);
    assertEquals("error", id);

  }

  // To prevent the database growing unnecessarily large during testing,
  // set to delete the created row. The UO005 id is a sample saved.
  @AfterEach
  public void removeUser() throws ClassNotFoundException, SQLException {

    Connection con = null;
    PreparedStatement pst;
    String idOne = "UO006";
    String idTwo = "UO007";

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