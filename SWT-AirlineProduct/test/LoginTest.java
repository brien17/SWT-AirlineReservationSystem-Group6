import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;

public class LoginTest {
    @Test
    public void validLoginTest() {
        Login login = new Login();
        String username = "john";
        String password = "123";

        Connection con = null;
        String output = login.login(username, password, null);
        assertEquals("valid", output);
    }

    @Test
    public void invalidLoginTest() {
        Login login = new Login();
        String username = "j";
        String password = "123";
        Connection con = null;
        String output = login.login(username, password, con);

        assertEquals("invalid", output);
    }

    @Test
    public void emptyUsernameLoginTest() {
        Login login = new Login();
        String username = "";
        String password = "123";
        Connection con = null;
        String output = login.login(username, password, con);

        assertEquals("blank", output);
    }

    @Test
    public void emptyPasswordLoginTest() {
        Login login = new Login();
        String username = "john";
        String password = "";
        Connection con = null;
        String output = login.login(username, password, con);

        assertEquals("blank", output);
    }

}
