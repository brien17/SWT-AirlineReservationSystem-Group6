import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import javax.imageio.ImageIO;

/**
 * Tests for the CustomerCreationController class
 */
public class CustomerCreationTest {

  public CustomerCreationTest() {
  }

  byte[] userimage;
  byte[] invalidImage;
  CustomerCreationController customerCreationTest = null;

  @BeforeEach
  public void setUp(){
    customerCreationTest = new CustomerCreationController();

  }

  /**
   * Test Case ID: TC -CC-1
   * Requirement ID/Description: SR-F-03 The system shall allow users to add customer accounts by
   *     entering first and last name, national ID Card number, passport ID,
   *     address, DOB, gender, photo and contact.
   * Purpose: Test that valid inputs adds a new customer to the database.
   * Test Setup: An instance of CustomerCreationController is created and the addCustomer() method
   *     is called with the test inputs.
   * Test Strategy: Unidimensional equivalence class partitioning (valid, invalid, null)
   * Input: String customerID = "CS001";
   *     String firstname = "Randy";
   *     String lastname = "Marsh";
   *     String nic = "00000000A";
   *     String passport = "123456789";
   *     String address = "1600 Pennsylvania Avenue NW Washington, DC, 20500";
   *
   *     Date date = new Date(1949,4,8);
   *     String sex = "Female";
   *     String contact = "2392392939";
   *     String errorTrace = "";
   *
   *     File image = new File("./resources/default.jpg");
   *     FileInputStream fis = new FileInputStream(image);
   *     ByteArrayOutputStream baos = new ByteArrayOutputStream();
   *     byte[] buff = new byte[1024];
   *     for (int readNum; (readNum = fis.read(buff)) != -1; ) {
   *       baos.write(buff, 0, readNum);
   *     }
   *     userimage = baos.toByteArray();
   *
   * Expected Output: "Registation Createdd........."
   */
  @Test
  public void testValidCustomer() throws IOException {
    String customerID = "CS001";
    String firstname = "Randy";
    String lastname = "Marsh";
    String nic = "00000000A";
    String passport = "123456789";
    String address = "1600 Pennsylvania Avenue NW Washington, DC, 20500";

    Date date = new Date(1949,4,8);
    String sex = "Female";
    String contact = "2392392939";
    String errorTrace = "";

    File image = new File("./resources/default.jpg");
    FileInputStream fis = new FileInputStream(image);
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    byte[] buff = new byte[1024];
    for (int readNum; (readNum = fis.read(buff)) != -1; ) {
      baos.write(buff, 0, readNum);
    }
    userimage = baos.toByteArray();
    customerCreationTest.generateCustomerID("test");

    String output = customerCreationTest.addCustomer(customerID,firstname,lastname,nic,passport,address,date,sex,contact,userimage,errorTrace);

    assertEquals("Registation Createdd.........", output);
  }


  /**
   * Test Case ID: TC -CC-2
   * Requirement ID/Description: SR-F-03 The system shall allow users to add customer accounts by
   *     entering first and last name, national ID Card number, passport ID,
   *     address, DOB, gender, photo and contact.
   * Purpose: Test that invalid inputs are handled without runtime errors and alerts user.
   * Test Setup: An instance of CustomerCreationController is created and the addCustomer() method
   *     is called with the test inputs.
   * Test Strategy: Unidimensional equivalence class partitioning (valid, invalid, null)
   * Input:
   *     String customerID = "1";
   *     String firstname = "123";
   *     String lastname = "456";
   *     String nic = "two";
   *     String passport = "three";
   *     String address = "2392392939";
   *     Date date = new Date(1850,3,4);
   *     String sex = "MaleFemale";
   *     String contact = "2392392939";
   *     String errorTrace = "";
   *     File sampleText = new File("./resources/Sample.txt");
   *     invalidImage = convertFileToByteArray(sampleText);
   * Expected Output: "" Empty String should show no Runtime Errors in the stack trace.
   */
  @Test
  public void testInvalidCustomer() throws AWTException, InterruptedException, SQLException {
    String customerID = "1";
    String firstname = "123";
    String lastname = "456";
    String nic = "two";
    String passport = "three";
    String address = "2392392939";

    Date date = new Date(1850,3,4);

    String sex = "MaleFemale";
    String contact = "2392392939";
    String errorTrace = "";
    File sampleText = new File("./resources/Sample.txt");
    invalidImage = convertFileToByteArray(sampleText);

    customerCreationTest.maleButton.setSelected(false);
    customerCreationTest.addCustomerActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));

    String output = customerCreationTest.addCustomer(customerID,firstname,lastname,nic,passport,address,date,sex,contact,invalidImage,errorTrace);
/*
 ErrorTrace should be empty and caught by GUI before causing runtime error
 GUI should update user as to what is invalid and why, code erroneously adds
     to the database
     */
    assertEquals("", output);
  }

  /**
   * Test Case ID: TC -CC-3
   * Requirement ID/Description: SR-F-03 The system shall allow users to add customer accounts by
   *     entering first and last name, national ID Card number, passport ID,
   *     address, DOB, gender, photo and contact.
   * Purpose: Test that empty/null inputs are handled without runtime exception.
   * Test Setup: An instance of CustomerCreationController is created and the addCustomer() method
   *     is called with the test inputs.
   * Test Strategy: Unidimensional equivalence class partitioning (valid, invalid, null)
   * Input: String customerID = "";
   *        String firstname = "";
   *        String lastname = "";
   *        String nic = "";
   *        String passport = "";
   *        String address = "";
   *        Date date = null;
   *        String sex = "";
   *        String contact = "";
   *        String errorTrace = "";
   *        byte[] emptyImage = null;
   * Expected Output: "" Empty String should show no Runtime Errors in the stack trace.
   */
  @Test
  public void testEmptyCustomer() {
    String customerID = "";
    String firstname = "";
    String lastname = "";
    String nic = "";
    String passport = "";
    String address = "";
    Date date = null;
    String sex = "";
    String contact = "";
    String errorTrace = "";
    userimage = null;
    customerCreationTest.maleButton.setSelected(true);
    String output = customerCreationTest.addCustomerActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));
    //GUI should alert user to what is missing, not output errors to console
    assertEquals("", output);
  }


  /**
   * Test Case ID: TC - CC-4
   * Requirement ID/Description: SR-F-03 The system shall allow users to add customer accounts by
   *     entering first and last name, national ID Card number, passport ID,
   *     address, DOB, gender, photo and contact.
   * Purpose: Test that a null input for userImage is handled without runtime exception.
   * Test Setup: An instance of CustomerCreationController is created and the addCustomer() method
   *     is called with the test inputs.
   * Test Strategy: Unidimensional equivalence class partitioning (valid, invalid, null)
   * Input: String customerID = "1";
   *        String firstname = "123";
   *        String lastname = "456";
   *        String nic = "two";
   *        String passport = "three";
   *        String address = "2392392939";
   *
   *        Date date = new Date(1850,3,4);
   *
   *        String sex = "Male";
   *        String contact = "2392392939";
   *        String errorTrace = "";
   *        byte[] emptyImage = null;
   * Expected Output: "" Empty String should show no Runtime Errors in the stack trace.
   */
  @Test
  public void testEmptyImageCustomer() {
    String customerID = "1";
    String firstname = "123";
    String lastname = "456";
    String nic = "two";
    String passport = "three";
    String address = "2392392939";

    Date date = new Date(1850,3,4);

    String sex = "Male";
    String contact = "2392392939";
    String errorTrace = "";
    byte[] emptyImage = null;


    String output = customerCreationTest.addCustomer(
            customerID,firstname,lastname,nic,passport,address,date,sex,contact,emptyImage,errorTrace);

/*
 ErrorTrace should be empty and caught by GUI before causing runtime error
 GUI should update user as to what is invalid and why, code erroneously adds
     to the database
     */
    assertEquals("", output);
  }

  /**
   * Sets customerCreationTest object to null.
   */
  @AfterEach
  public void tearDown(){
    customerCreationTest = null;
  }

  /**
   * Helper method to create an invalid byte array from a text file.
   * @param file
   * @return byte array from file
   */
  private static byte[] convertFileToByteArray(File file){
    FileInputStream fis = null;
    // Creating bytearray of same length as file
    byte[] bArray = new byte[(int) file.length()];
    try{
      fis = new FileInputStream(file);
      // Reading file content to byte array
      fis.read(bArray);
      fis.close();
    }catch(IOException ioExp){
      ioExp.printStackTrace();
    }finally{
      if(fis != null){
        try {
          fis.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return bArray;
  }

}
