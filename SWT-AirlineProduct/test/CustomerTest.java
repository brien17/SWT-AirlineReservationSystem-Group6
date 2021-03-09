import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.Connection;

public class CustomerTest {
  @Test
  public void validCustomerTest() {
    CustomerCreationController validTest = new CustomerCreationController();

//    Login login = new Login();
//    String username = "cbrien";
//    String password = "password";
//    Connection con = null;
//    String output = login.login(username, password, con);
//    assertEquals("valid", output);
  }

  @Test
  public void invalidCustomerTest() throws AWTException, InterruptedException {

//    Login login = new Login();
//    String username = "cbrien";
//    String password = "123";
//    Connection con = null;
//    String output = login.login(username, password, con);
//
//    assertEquals("invalid", output);
  }

  @Test
  public void emptyCustomerTest() {
//    Login login = new Login();
//    String username = "";
//    String password = "";
//    Connection con = null;
//    String output = login.login(username, password, con);
//
//    assertEquals("blank", output);
  }

}
