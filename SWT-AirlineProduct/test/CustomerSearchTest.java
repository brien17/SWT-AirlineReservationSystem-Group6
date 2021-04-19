import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.ActionEvent;
import java.io.*;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerSearchTest {

  // Declare and Create search, update, browse objects
  private CustomerSearchController find;
  private CustomerSearchController update;
  private CustomerSearchController browse;

  byte[] userimage;


  // Initialize the find and update objects
  @BeforeEach
  public void searchBuild() {
    find = new CustomerSearchController();
    update = new CustomerSearchController();
    browse = new CustomerSearchController();
  }

  /**
   * Purpose: A simple manual GUI testcase to assist with reaching line and branch coverage of the CustomerSearchController
   * class. The test pulls button actions from CustomerSearchController to show that the system can perform button clicks
   * for the update button, find button, browse button, and close button.
   */

  @Test
  public void customerSearchButtonTest() {

    update.updateCustomerActionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ""));
    find.findButtonActionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ""));
    browse.browseButtonActionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ""));
    update.closeButtonActionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ""));
  }

  /**
   * Purpose: A simple testcase to assist with reaching line and branch coverage of the CustomerSearchController class.
   * The test sets a radio option in the GUI to the Male option, and this allows the test case to run through the if
   * statement block to test if the GUI works.
   */

  @Test
  public void updateSelectorTest() {

    update.r1.setSelected(true);
    update.updateCustomerActionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ""));

  }

  /**
   * Test Case ID: TC-CS-01
   * Requirement ID/Description: SR-F-04: The system shall allow users to search for a Customer’s account information
   * by entering a valid Customer ID.
   * Purpose: Test that the file chooser from the browse button takes a correct file path and completes the browse.
   * Test Setup: An instance of the CustomerSearchController class is created and the browse method is called with a
   * file path to the appropriate jpg file. An assertEquals method is used to confirm that the browse method completed
   * successfully.
   * Test Strategy: Use case testing was used to develop test cases for this requirement
   * Input: "./resources/default.jpg"
   * Expected Output: true
   */
  @Test
  public void validBrowseTest() {

    String path = "./resources/default.jpg";
    Boolean output = browse.browse(path);

    assertEquals(true, output);

  }

  /**
   * Test Case ID: TC-CS-02
   * Requirement ID/Description: SR-F-04: The system shall allow users to search for a Customer’s account information
   * by entering a valid Customer ID.
   * Purpose: Test that the method will fail with an IOException by setting the path parameter to null.
   * Test Setup: An instance of the CustomerSearchController class is created and the browse method is called with a
   * null file path. An assertEquals method is used to confirm that the browse method reaches an IO Exception and
   * returns false.
   * Test Strategy: Use case testing was used to develop test cases for this requirement
   * Input: null
   * Expected Output: false
   */
  @Test
  public void invalidBrowseTest() {

    Boolean output = browse.browse(null);

    assertEquals(false, output);

  }

  /**
   * Test Case ID: TC-CS-03
   * Requirement ID/Description: SR-F-04: The system shall allow users to search for a Customer’s account information
   * by entering a valid Customer ID.
   * Purpose: Test that a user can find a valid male user from the find button by inputting a valid customerID.
   * Test Setup: An instance of the CustomerSearchController class is created and the find method is called with a valid
   * male customerID and a proper database connection driver. An assertEquals method is used to confirm that the find
   * method successfully completes by returning "true".
   * Test Strategy: Use case testing was used to develop test cases for this requirement
   * Input: "cs001", null, "com.mysql.jdbc.Driver"
   * Expected Output: "true"
   */
  @Test
  public void validMaleFindTest() {
    // Sample inputs
    String id = "cs001";
    Connection con = null;

    String output = find.find(id, con, "com.mysql.jdbc.Driver");
    assertEquals("true", output);
  }

  /**
   * Test Case ID: TC-CS-04
   * Requirement ID/Description: SR-F-04: The system shall allow users to search for a Customer’s account information
   * by entering a valid Customer ID.
   * Purpose: Test that a user can find a valid female user from the find button by inputting a valid customerID.
   * Test Setup: An instance of the CustomerSearchController class is created and the find method is called with a valid
   * female customerID and a proper database connection driver. An assertEquals method is used to confirm that the find
   * method successfully completes by returning "true".
   * Test Strategy: Use case testing was used to develop test cases for this requirement
   * Input: "cs002", null, "com.mysql.jdbc.Driver"
   * Expected Output: "true"
   */
  @Test
  public void validFemaleFindTest() {
    // Sample inputs
    String id = "cs002";
    Connection con = null;

    String output = find.find(id, con, "com.mysql.jdbc.Driver");
    assertEquals("true", output);
  }

  /**
   * Test Case ID: TC-CS-05
   * Requirement ID/Description: SR-F-04: The system shall allow users to search for a Customer’s account information
   * by entering a valid Customer ID.
   * Purpose: Test that if an invalid customerID was submitted, the system will provide an failure to find error message.
   * Test Setup: An instance of the CustomerSearchController class is created and the find method is called with an
   * invalid customerID and a proper connection to the mySQL java database. An assertEquals method is used to confirm
   * that the find method will fail if provided an invalid customerID.
   * Test Strategy: Use case testing was used to develop test cases for this requirement
   * Input: "CS1", null, "com.mysql.jdbc.Driver"
   * Expected Output: "false"
   */
  @Test
  public void failToFindTest() {
    // Sample inputs
    String id = "CS1";
    Connection con = null;

    String output = find.find(id, con, "com.mysql.jdbc.Driver");
    assertEquals("false", output);
  }

  /**
   * Test Case ID: TC-CS-06
   * Requirement ID/Description: SR-F-04: The system shall allow users to search for a Customer’s account information
   * by entering a valid Customer ID.
   * Purpose: Test that the system will provide an error message if the system is not properly connected to the database.
   * Test Setup: An instance of the CustomerSearchController class is created and the find method is called without a
   * driver to connect to the mySQL java database. An assertEquals method is used to confirm that the find method will
   * fail due to a lack of a secure connection to the database.
   * Test Strategy: Use case testing was used to develop test cases for this requirement
   * Input: "CS1", null, ""
   * Expected Output: "error"
   */
  @Test
  public void failToConnectFindTest() {
    // Sample inputs
    String id = "CS1";
    Connection con = null;

    String output = find.find(id, con, "");
    assertEquals("error", output);
  }

  /**
   * Test Case ID: TC-CS-07
   * Requirement ID/Description: SR-F-04: The system shall allow users to search for a Customer’s account information
   * by entering a valid Customer ID.
   * Purpose: Test that if an empty customerID was submitted, the system will provide an failure to find error message.
   * Test Setup: An instance of the CustomerSearchController class is created and the find method is called with an
   * empty customerID and a proper connection to the mySQL java database. An assertEquals method is used to confirm
   * that the find method will fail if provided an invalid customerID.
   * Test Strategy: Use case testing was used to develop test cases for this requirement
   * Input: "", null, "com.mysql.jdbc.Driver"
   * Expected Output: true
   */
  @Test
  public void blankFindTest() {
    // Sample inputs
    String id = "";
    Connection con = null;

    String output = find.find(id, con, "com.mysql.jdbc.Driver");
    assertEquals("false", output);
  }

  /**
   * Test Case ID: TC-CS-08
   * Requirement ID/Description: SR-F-04: The system shall allow users to search for a Customer’s account information
   * by entering a valid Customer ID.
   * Purpose: Test that an existing male customer can be updated with the update button on the customer menu.
   * Test Setup: An instance of the CustomerSearchController class is created and the update method is called with a list
   * of input variables to test the customer update button by taking the customerID, firstname, lastname, nic, passport,
   * address, dateString, sex, contact, and a sample image, also with the database driver. An assertEquals method is
   * used to confirm that the customer information in the database is updated appropriately and successfully.
   * Test Strategy: Use case testing was used to develop test cases for this requirement
   * Input: "CS001", "Randy", "Marsh", "00000000A", "123456789", "1600 Pennsylvania Avenue NW Washington, DC, 20500",
   * "1949-04-08", "Male", "1234567890", userimage, "com.mysql.jdbc.Driver"
   * Expected Output: true
   */
  @Test
  public void validMaleUpdateTest() throws IOException {
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

    String output = update.update(customerID, firstname, lastname, nic, passport, address,
        dateString, sex, contact, userimage, "com.mysql.jdbc.Driver");
    assertEquals("true", output);
  }

  /**
   * Test Case ID: TC-CS-09
   * Requirement ID/Description: SR-F-04: The system shall allow users to search for a Customer’s account information
   * by entering a valid Customer ID.
   * Purpose: Test that an existing female customer can be updated with the update button on the customer menu.
   * Test Setup: An instance of the CustomerSearchController class is created and the update method is called with a list
   * of input variables to test the customer update button by taking the customerID, firstname, lastname, nic, passport,
   * address, dateString, sex, contact, and a sample image, also with the database driver. An assertEquals method is
   * used to confirm that the customer information in the database is updated appropriately and successfully.
   * Test Strategy: Use case testing was used to develop test cases for this requirement
   * Input: "CS002", "Sandy", "Marsh", "00000000A", "123456789", "1600 Pennsylvania Avenue NW Washington, DC, 20500",
   * "1949-04-08", "Female", "1234567890", userimage, "com.mysql.jdbc.Driver"
   * Expected Output: true
   */
  @Test
  public void validFemaleUpdateTest() throws IOException {
    String customerID = "CS002";
    String firstname = "Sandy";
    String lastname = "Marsh";
    String nic = "00000000A";
    String passport = "123456789";
    String address = "1600 Pennsylvania Avenue NW Washington, DC, 20500";
    String dateString = "1949-04-08";
    String sex = "Female";
    String contact = "1234567890";

    File image = new File("./resources/default.jpg");
    FileInputStream fis = new FileInputStream(image);
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    byte[] buff = new byte[1024];
    for (int readNum; (readNum = fis.read(buff)) != -1; ) {
      baos.write(buff, 0, readNum);
    }
    userimage = baos.toByteArray();

    String output = update.update(customerID, firstname, lastname, nic, passport, address,
        dateString, sex, contact, userimage, "com.mysql.jdbc.Driver");
    assertEquals("true", output);
  }

  /**
   * Test Case ID: TC-CS-10
   * Requirement ID/Description: SR-F-04: The system shall allow users to search for a Customer’s account information
   * by entering a valid Customer ID.
   * Purpose: Test that the system will throw an error when unable to connect to the database successfully.
   * Test Setup: An instance of the CustomerSearchController class is created and the update method is called, lacking
   * the necessary connection driver to mysql java database to test the customer update button by passing through the
   * sample set of String information without the database driver. An assertEquals method is used to confirm that an
   * error will occur due to a lack of connection to the database.
   * Test Strategy: Use case testing was used to develop test cases for this requirement
   * Input: "CS001", "Randy", "Marsh", "00000000A", "123456789", "1600 Pennsylvania Avenue NW Washington, DC, 20500",
   * "1949-04-08", "Male", "1234567890", userimage, ""
   * Expected Output: "error"
   */
  @Test
  public void failToConnectUpdateTest() throws IOException {
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

    String output = update.update(customerID, firstname, lastname, nic, passport, address,
        dateString, sex, contact, userimage, "");
    assertEquals("error", output);
  }

  // Tear down the search and update objects
  @AfterEach
  public void userTear() {
    find = null;
    update = null;
    browse = null;
  }
}