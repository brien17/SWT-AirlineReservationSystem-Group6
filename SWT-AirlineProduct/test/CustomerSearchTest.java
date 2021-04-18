import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.sql.Connection;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerSearchTest {

  // Declare and Create search and update objects
  private CustomerSearchController find;
  private CustomerSearchController update;

  byte[] userimage;

  // Initialize the find and update objects
  @BeforeEach
  public void searchBuild() {
    find = new CustomerSearchController();
    update = new CustomerSearchController();
  }

  // Equivalence Testing - Locating a user from the database after hitting the find button
  @Test
  public void validFindTest() {
    // Sample inputs
    String id = "cs001";
    Connection con = null;

    String output = find.find(id, con);
    assertEquals("true", output);
  }

  // Invalid case - incorrect characters
  @Test
  public void invalidFindTest() {
    // Sample inputs
    String id = "CS1";
    Connection con = null;

    String output = find.find(id, con);
    assertEquals("false", output);
  }

  // Invalid case - blank input
  @Test
  public void blankFindTest() {
    // Sample inputs
    String id = "";
    Connection con = null;

    String output = find.find(id, con);
    assertEquals("false", output);
  }

  @Test
  public void validUpdateTest() throws IOException {
    String customerID = "CS001";
    String firstname = "Randy";
    String lastname = "Marsh";
    String nic = "00000000A";
    String passport = "123456789";
    String address = "1600 Pennsylvania Avenue NW Washington, DC, 20500";
    String dateString = "1949-04-08";
    String sex = "Male";
    String contact = "1234567890";

    File image = new File("./resources/default.jpg");
    FileInputStream fis = new FileInputStream(image);
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    byte[] buff = new byte[1024];
    for (int readNum; (readNum = fis.read(buff)) != -1; ) {
      baos.write(buff, 0, readNum);
    }
    userimage = baos.toByteArray();

    String output = update.update(customerID, firstname, lastname, nic, passport, address, dateString, sex, contact, userimage);
    assertEquals("true", output);
  }

  // Tear down the search and update objects
  @AfterEach
  public void userTear() {
    find = null;
    update = null;
  }
}