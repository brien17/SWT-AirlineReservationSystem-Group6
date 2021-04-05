import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;



public class FlightAdditionTest {

  @Mock
  List mockedList;

  FlightAdditionController flightAdditionTest = null;
  @BeforeEach
  public void setUp(){
    MockitoAnnotations.initMocks(this);

    flightAdditionTest = new FlightAdditionController();

  }

  @Test
  public void validFlightTest() {


//    Login login = new Login();
//    String username = "cbrien";
//    String password = "password";
//    Connection con = null;
//    String output = login.login(username, password, con);
//    assertEquals("valid", output);
  }

  @Test
  public void invalidFlightTest() throws AWTException, InterruptedException {

//    Login login = new Login();
//    String username = "cbrien";
//    String password = "123";
//    Connection con = null;
//    String output = login.login(username, password, con);
//
//    assertEquals("invalid", output);
  }

  @Test
  public void emptyFlightTest() {


//    Login login = new Login();
//    String username = "";
//    String password = "";
//    Connection con = null;
//    String output = login.login(username, password, con);
//
//    assertEquals("blank", output);
  }


  @AfterEach
  public void tearDown(){
    flightAdditionTest = null;
  }

/*
public CustomerTest() {

  }

  byte[] userimage;
  byte[] invalidImage;
  CustomerCreationController customerCreationTest = null;



  @Test
  public void validCustomerTest() throws IOException {
    String customerID = "CS001";
    String firstname = "Randy";
    String lastname = "Marsh";
    String nic = "00000000A";
    String passport = "123456789";
    String address = "1600 Pennsylvania Avenue NW Washington, DC, 20500";

    Date date = new Date(1949,4,8);
    String sex = "Male";
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


    String output = customerCreationTest.addCustomer(customerID,firstname,lastname,nic,passport,address,date,sex,contact,userimage,errorTrace);

    assertEquals("Registation Createdd.........", output);
  }

  @Test
  public void invalidCustomerTest() throws AWTException, InterruptedException, SQLException {
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


    String output = customerCreationTest.addCustomer(customerID,firstname,lastname,nic,passport,address,date,sex,contact,invalidImage,errorTrace);

// ErrorTrace should be empty and caught by GUI before causing runtime error
// GUI should update user as to what is incorrect and why
    assertEquals("", output);
  }

  @Test
  public void emptyCustomerTest() {
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
    String output = customerCreationTest.addCustomer(customerID,firstname,lastname,nic,passport,address,date,sex,contact,userimage,errorTrace);
//GUI should show what is missing, not output errors to console
    assertEquals("", output);
  }

  @AfterEach
  public void tearDown(){
    customerCreationTest = null;
  }

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
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }
    return bArray;
  }
 */
}
