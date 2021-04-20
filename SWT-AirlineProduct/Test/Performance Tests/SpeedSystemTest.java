import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.event.ChangeEvent;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * System test to assess speed of methods with transactions to the database
 */
@TestInstance(Lifecycle.PER_CLASS)
public class SpeedSystemTest {

    Login loginWindow;
    CustomerCreationController customerCreationWindow;
    CustomerSearchController customerSearchWindow;
    FlightAdditionController flightAdditionWindow;
    TicketController ticketWindow;
    TicketReportController ticketReportWindow;
    UserCreationController userCreationWindow;
    byte[] userimage;

    @BeforeAll
    public void setUp(){
        this.loginWindow = new Login();
        this.customerCreationWindow = new CustomerCreationController();
        this.customerSearchWindow = new CustomerSearchController();
        this.flightAdditionWindow = new FlightAdditionController();
        this.ticketWindow = new TicketController();
        this.ticketReportWindow = new TicketReportController();
        this.userCreationWindow = new UserCreationController();
    }

    /**
     * Test Case ID:
     * Requirement ID/Description: The system shall complete methods interacting
     *      with the database in at most 8 seconds.
     * Purpose: Users get frustrated with slow, unresponsive software. To test the
     *      speed of Login transaction.
     * Test Setup: Instances are created for classes Login, CustomerCreationController,
     *  CustomerSearchController, FlightAdditionController, TicketController, TickerReportController,
     *  and UserCreationController.
     * Test Strategy: End to end testing, performance testing
     * Input: methodTime =  end time - start time
     *
     * Expected Output: <= 8000 milliseconds (8 seconds)
     */
    @Test
    public void testLoginTransaction() {

        //test Login
        String username = "john";
        String password = "123";
        long methodTime = 0;
        long startTime = System.currentTimeMillis();
        loginWindow.login(username, password, new Main(), "com.mysql.jdbc.Driver");
        long endTime = System.currentTimeMillis();
        methodTime = endTime-startTime;
        System.out.println(methodTime);
        assertTrue(methodTime <= 8000);

        //Reach coverage
        loginWindow.login("", "123", new Main(), "");
        loginWindow.login("123", "", new Main(), "");

        loginWindow.login("john", "password", new Main(), "com.mysql.jdbc.Driver");

    }

    /**
     * Test Case ID:
     * Requirement ID/Description: The system shall complete methods interacting
     *      with the database in at most 8 seconds.
     * Purpose: Users get frustrated with slow, unresponsive software. To test the
     *      speed of CustomerCreation transaction.
     * Test Setup: Instances are created for classes Login, CustomerCreationController,
     *  CustomerSearchController, FlightAdditionController, TicketController, TickerReportController,
     *  and UserCreationController.
     * Test Strategy: End to end testing, performance testing
     * Input: methodTime =  end time - start time
     *
     * Expected Output: <= 8000 milliseconds (8 seconds)
     */
    @Test
    public void testCustomerCreationTransaction()  throws IOException {

        //test CustomerCreationController transaction to Customer table
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

        customerCreationWindow.generateCustomerID("test");
        customerCreationWindow.maleButton.setSelected(false);

        customerCreationWindow.addCustomerActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));

        customerCreationWindow.maleButton.setSelected(true);
        customerCreationWindow.addCustomerActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));

        long startTime = System.currentTimeMillis();
        customerCreationWindow.addCustomer(customerID,firstname,lastname,nic,passport,address,date,sex,contact,userimage,errorTrace);
        long endTime = System.currentTimeMillis();
        long methodTime = endTime-startTime;
        System.out.println(methodTime);
        assertTrue(methodTime <= 8000);
    }

    /**
     * Test Case ID:
     * Requirement ID/Description: The system shall complete methods interacting
     *      with the database in at most 8 seconds.
     * Purpose: Users get frustrated with slow, unresponsive software. To test the
     *      speed of Customer Update transaction.
     * Test Setup: Instances are created for classes Login, CustomerCreationController,
     *  CustomerSearchController, FlightAdditionController, TicketController, TickerReportController,
     *  and UserCreationController.
     * Test Strategy: End to end testing, performance testing
     * Input: methodTime =  end time - start time
     *
     * Expected Output: <= 8000 milliseconds (8 seconds)
     */
    @Test
    public void testCustomerUpdateTransaction() throws IOException {
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

        customerSearchWindow.r1.setSelected(false);
        customerSearchWindow.updateCustomerActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));

        String id = "cs001";
        Connection con = null;

        customerSearchWindow.find(id, con, "com.mysql.jdbc.Driver");

        id = "cs002";

        customerSearchWindow.find(id, con, "com.mysql.jdbc.Driver");

        customerSearchWindow.r1.setSelected(true);
        customerSearchWindow.updateCustomerActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));
        customerSearchWindow.findButtonActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));

        long startTime = System.currentTimeMillis();
        customerSearchWindow.update(customerID, firstname, lastname, nic, passport, address,
                dateString, sex, contact, userimage, "com.mysql.jdbc.Driver");    long endTime = System.currentTimeMillis();
        long methodTime = endTime-startTime;
        System.out.println(methodTime);
        assertTrue(methodTime <= 8000);

        customerSearchWindow.closeButtonActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));


    }

    /**
     * Test Case ID:
     * Requirement ID/Description: The system shall complete methods interacting
     *      with the database in at most 8 seconds.
     * Purpose: Users get frustrated with slow, unresponsive software. To test the
     *      speed of FlightAddition transaction.
     * Test Setup: Instances are created for classes Login, CustomerCreationController,
     *  CustomerSearchController, FlightAdditionController, TicketController, TickerReportController,
     *  and UserCreationController.
     * Test Strategy: End to end testing, performance testing
     * Input: methodTime =  end time - start time
     *
     * Expected Output: <= 8000 milliseconds (8 seconds)
     */
    @Test
    public void testFlightAdditionTransaction() {
        flightAdditionWindow.airlineNameInput.setText("India Air");
        flightAdditionWindow.sourceInput.setSelectedItem("India");
        flightAdditionWindow.destinationInput.setSelectedItem("Usa");

        String date = "2021-04-01";
        try {
            java.util.Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            flightAdditionWindow.dateInput.setDate(date2);

        } catch (java.text.ParseException ex){
            System.out.println(ex.getMessage());
        }
        flightAdditionWindow.departureTimeInput.setText("12:00 PM");
        flightAdditionWindow.arrivalTimeInput.setText("1:00 PM");
        flightAdditionWindow.flightChargeInput.setText("$100");

        flightAdditionWindow.generateFlightID("test");

        long startTime = System.currentTimeMillis();
        flightAdditionWindow.addFlightActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));
        long endTime = System.currentTimeMillis();
        long methodTime = endTime-startTime;
        System.out.println(methodTime);
        assertTrue(methodTime <= 8000);
    }

    /**
     * Test Case ID:
     * Requirement ID/Description: The system shall complete methods interacting
     *      with the database in at most 8 seconds.
     * Purpose: Users get frustrated with slow, unresponsive software. To test the
     *      speed of Ticket Addition transaction.
     * Test Setup: Instances are created for classes Login, CustomerCreationController,
     *  CustomerSearchController, FlightAdditionController, TicketController, TickerReportController,
     *  and UserCreationController.
     * Test Strategy: End to end testing, performance testing
     * Input: methodTime =  end time - start time
     *
     * Expected Output: <= 8000 milliseconds (8 seconds)
     */
    @Test
    public void testTicketTransaction() {
        String flightID = "FO003";
        String customerID = "CS001";
        String numOfSeats = "10";

        ticketWindow.flightno.setText(flightID);
        ticketWindow.txtcustid.setText(customerID);
        //ticketWindow.txtseats.setValue("10");
        //ticketWindow.txtseatsStateChanged(new ChangeEvent(this));
        ticketWindow.autoIncrementTicketNo("test");
        ticketWindow.searchCustomerIDButtonActionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED,""));

        ticketWindow.txtcustid.setText(null);

        ticketWindow.searchCustomerIDButtonActionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED,""));

        //   ticketWindow.flightSelectionActionPerformed(new MouseEvent(ticketWindow.jTable1, MouseEvent.MOUSE_CLICKED,1,1,1,1,1,false));
        ticketWindow.searchTicketsButtonActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));


        flightID = "";
        customerID = "";
        numOfSeats = "10";
        ticketWindow.validateTicketDetails(flightID, customerID, numOfSeats);

        flightID = "";
        customerID = "CS001";
        numOfSeats = "5";
        ticketWindow.validateTicketDetails(flightID, customerID, numOfSeats);

        flightID = "FO002";
        customerID = "";
        numOfSeats = "15";
        ticketWindow.validateTicketDetails(flightID, customerID, numOfSeats);

        long startTime = System.currentTimeMillis();
        ticketWindow.bookButtonActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));
        long endTime = System.currentTimeMillis();
        long methodTime = endTime-startTime;
        System.out.println(methodTime);
        assertTrue(methodTime <= 8000);
    }

    /**
     * Test Case ID:
     * Requirement ID/Description: The system shall complete methods interacting
     *      with the database in at most 8 seconds.
     * Purpose: Users get frustrated with slow, unresponsive software. To test the
     *      speed of Ticket Report query.
     * Test Setup: Instances are created for classes Login, CustomerCreationController,
     *  CustomerSearchController, FlightAdditionController, TicketController, TickerReportController,
     *  and UserCreationController.
     * Test Strategy: End to end testing, performance testing
     * Input: methodTime =  end time - start time
     *
     * Expected Output: <= 8000 milliseconds (8 seconds)
     */
    @Test
    public void testTicketReportQuery() {
        long startTime = System.currentTimeMillis();
        ticketReportWindow.LoadData();
        long endTime = System.currentTimeMillis();
        long methodTime = endTime-startTime;
        System.out.println(methodTime);
        assertTrue(methodTime <= 8000);
        ticketReportWindow.cancelButtonActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));

    }

    /**
     * Test Case ID:
     * Requirement ID/Description: The system shall complete methods interacting
     *      with the database in at most 8 seconds.
     * Purpose: Users get frustrated with slow, unresponsive software. To test the
     *      speed of UserCreation transaction.
     * Test Setup: Instances are created for classes Login, CustomerCreationController,
     *  CustomerSearchController, FlightAdditionController, TicketController, TickerReportController,
     *  and UserCreationController.
     * Test Strategy: End to end testing, performance testing
     * Input: methodTime =  end time - start time
     *
     * Expected Output: <= 8000 milliseconds (8 seconds)
     */
    @Test
    public void testUserCreationTransaction() {
        // Sample inputs
        String firstname = "Cody";
        String lastname = "Buckley";
        String username = "testuser";
        String password = "testpass";
        Connection con = null;

        long startTime = System.currentTimeMillis();
        userCreationWindow.add(firstname, lastname, username, password, con, "com.mysql.jdbc.Driver");
        long endTime = System.currentTimeMillis();
        long methodTime = endTime-startTime;
        System.out.println(methodTime);

        userCreationWindow.autoID("", false);
        userCreationWindow.autoID("com.mysql.jdbc.Driver", true);
        userCreationWindow.autoID("com.mysql.jdbc.Driver", false);

        assertTrue(methodTime <= 8000);
    }

    @AfterAll
    public void tearDown(){
        this.loginWindow = null;
        this.customerCreationWindow = null;
        this.flightAdditionWindow = null;
        this.ticketWindow = null;
        this.ticketReportWindow = null;
    }

}