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

  @Test
  public void customerSearchButtonTest() {

    update.updateCustomerActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));
    find.findButtonActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));

    update.closeButtonActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));
    browse.browseButtonActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));

  }


  @Test
  public void updateMaleSelectorTest() {

    update.r1.setSelected(true);
    update.updateCustomerActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));

  }

  @Test
  public void updateFemaleSelectorTest() {

    update.r2.setSelected(true);
    update.updateCustomerActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));

  }

  @Test
  public void validBrowseTest() {

    String path = "./resources/default.jpg";
    Boolean output = browse.browse(path);

    assertEquals(true, output);

  }

  @Test
  public void invalidBrowseTest() {

    Boolean output = browse.browse(null);

    assertEquals(false, output);

  }

  // Equivalence Testing - Locating a user from the database after hitting the find button
  @Test
  public void validMaleFindTest() {
    // Sample inputs
    String id = "cs001";
    Connection con = null;

    String output = find.find(id, con, "com.mysql.jdbc.Driver");
    assertEquals("true", output);
  }

  // Equivalence Testing - Locating a user from the database after hitting the find button
  @Test
  public void validFemaleFindTest() {
    // Sample inputs
    String id = "cs002";
    Connection con = null;

    String output = find.find(id, con, "com.mysql.jdbc.Driver");
    assertEquals("true", output);
  }

  // Invalid case - incorrect characters
  @Test
  public void failToFindTest() {
    // Sample inputs
    String id = "CS1";
    Connection con = null;

    String output = find.find(id, con, "com.mysql.jdbc.Driver");
    assertEquals("false", output);
  }

  // Invalid case - incorrect characters
  @Test
  public void failToConnectFindTest() {
    // Sample inputs
    String id = "CS1";
    Connection con = null;

    String output = find.find(id, con, "");
    assertEquals("error", output);
  }

  // Invalid case - blank input
  @Test
  public void blankFindTest() {
    // Sample inputs
    String id = "";
    Connection con = null;

    String output = find.find(id, con, "com.mysql.jdbc.Driver");
    assertEquals("false", output);
  }

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

    String output = update.update(customerID, firstname, lastname, nic, passport, address, dateString, sex, contact, userimage, "");
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