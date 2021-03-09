import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class userTestClass {
    // Declare and Create user object
    private userCreation add;

    // Initialize the user creation object
    @BeforeEach
    public void userBuild() {
        add = new userCreation();
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

        String output = add.add(firstname, lastname, username, password, con);
        assertEquals("true", output);
    }

    // To prevent the database growing unnecessarily large during testing,
    // set to delete the created row. The UO005 id is a sample saved.
    @AfterEach
    public void removeUser() throws ClassNotFoundException, SQLException {

        Connection con = null;
        PreparedStatement pst;
        String id = "UO006";

        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/airline", "root", "");
        pst = con.prepareStatement("DELETE FROM user WHERE id = ?");

        pst.setString(1, id);

        pst.executeUpdate();
    }

    // Tear down the user creation object
    @AfterEach
    public void userTear() {
        add = null;
    }
}
