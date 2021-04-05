import java.awt.event.ActionEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.Connection;

public class LoginTest {

  private Login login;

  @BeforeEach
  public void setup() {
    login = new Login();
  }

  @Test
  public void validLoginTest() {
    login.txtuser.setText("cbrien");
    login.txtpass.setText("password");
    String username = "cbrien";
    String password = "password";
    Connection con = null;
    String output = login.login(username, password, con);
//    login.loginButton.doClick();

    assertEquals("valid", output);
  }

  @Test
  public void invalidLoginTest() throws AWTException, InterruptedException {
    String username = "cbrien";
    String password = "123";
    Connection con = null;
    String output = login.login(username, password, con);
//    login.loginButton.doClick();



//    login.loginButtonClicked(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));


    assertEquals("invalid", output);
  }

  @Test
  public void emptyLoginTest() {
    String username = "";
    String password = "";
    Connection con = null;
    String output = login.login(username, password, con);
//    login.loginButton.doClick();

    assertEquals("blank", output);
  }

  @Test
  public void oneEmptyLoginTest() {
    String username = "user";
    String password = "";
    Connection con = null;
    String output = login.login(username, password, con);
//    login.loginButton.doClick();

    assertEquals("blank", output);
  }
}