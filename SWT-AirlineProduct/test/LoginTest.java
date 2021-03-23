import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.*;
import java.awt.event.ActionEvent;
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
        login = new Login();
        String username = "john";
        String password = "123";

        Connection con = null;
        String output = login.login(username, password, null);
        assertEquals("valid", output);
    }

    @Test
    public void invalidLoginTest() {
        String username = "john";
        String password = "password";
        Connection con = null;
        String output = login.login(username, password, con);

        assertEquals("UserName or Password do not Match", output);
    }

    @Test
    public void emptyUsernameLoginTest() {
        String username = "";
        String password = "123";
        Connection con = null;
        String output = login.login(username, password, con);

        assertEquals("UserName or Password Blank", output);
    }

    @Test
    public void emptyPasswordLoginTest() {
        String username = "john";
        String password = "";
        Connection con = null;
        String output = login.login(username, password, con);

        assertEquals("UserName or Password Blank", output);
    }

}
