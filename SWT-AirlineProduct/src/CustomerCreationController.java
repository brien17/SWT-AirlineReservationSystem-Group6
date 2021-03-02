

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 * This class builds a CustomerCreationView
 */
public class CustomerCreationController extends javax.swing.JInternalFrame {

  /**
   * Creates new form CustomerCreationController
   */
  public CustomerCreationController() {
    initComponents();
    generateCustomerID();
  }

  Connection con;
  PreparedStatement pst;

  String path = null;
  byte[] userimage = null;

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton browseButton;
  private javax.swing.JButton addButton;
  private javax.swing.JButton closeButton;
  private javax.swing.JLabel firstNameLabel;
  private javax.swing.JLabel contactLabel;
  private javax.swing.JLabel lastNameLabel;
  private javax.swing.JLabel nicNumberLabel3;
  private javax.swing.JLabel passportNumberLabel;
  private javax.swing.JLabel addressLabel;
  private javax.swing.JLabel customerIDLabel;
  private javax.swing.JLabel dateOfBirthLabel;
  private javax.swing.JLabel genderLabel;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;

  private javax.swing.JScrollPane addressBox;
  private javax.swing.JRadioButton maleButton;
  private javax.swing.JRadioButton femaleButton;

  private javax.swing.JTextArea addressInput;
  private javax.swing.JTextField contactInput;
  private javax.swing.JTextField firstNameInput;
  private javax.swing.JLabel customerID;
  private javax.swing.JTextField lastNameInput;
  private javax.swing.JTextField nicNumInput;
  private javax.swing.JTextField passportIDInput;
  private javax.swing.JLabel customerPhoto;
  private com.toedter.calendar.JDateChooser dateOfBirthInput;
  // End of variables declaration//GEN-END:variables

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT
   * modify this code. The content of this method is always regenerated by the Form Editor.
   */
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    firstNameLabel = new javax.swing.JLabel();
    lastNameLabel = new javax.swing.JLabel();
    nicNumberLabel3 = new javax.swing.JLabel();
    passportNumberLabel = new javax.swing.JLabel();
    addressLabel = new javax.swing.JLabel();
    lastNameInput = new javax.swing.JTextField();
    firstNameInput = new javax.swing.JTextField();
    nicNumInput = new javax.swing.JTextField();
    passportIDInput = new javax.swing.JTextField();
    addressBox = new javax.swing.JScrollPane();
    addressInput = new javax.swing.JTextArea();
    customerIDLabel = new javax.swing.JLabel();
    customerID = new javax.swing.JLabel();
    jPanel2 = new javax.swing.JPanel();
    dateOfBirthLabel = new javax.swing.JLabel();
    genderLabel = new javax.swing.JLabel();
    contactLabel = new javax.swing.JLabel();
    maleButton = new javax.swing.JRadioButton();
    femaleButton = new javax.swing.JRadioButton();
    contactInput = new javax.swing.JTextField();
    customerPhoto = new javax.swing.JLabel();
    browseButton = new javax.swing.JButton();
    addButton = new javax.swing.JButton();
    closeButton = new javax.swing.JButton();
    dateOfBirthInput = new com.toedter.calendar.JDateChooser();

    jPanel1.setBackground(new java.awt.Color(51, 0, 255));

    firstNameLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    firstNameLabel.setForeground(new java.awt.Color(255, 255, 255));
    firstNameLabel.setText("FirstName");

    lastNameLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    lastNameLabel.setForeground(new java.awt.Color(255, 255, 255));
    lastNameLabel.setText("LastName");

    nicNumberLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    nicNumberLabel3.setForeground(new java.awt.Color(255, 255, 255));
    nicNumberLabel3.setText("National Identification Card\n(NIC) Number");

    passportNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    passportNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
    passportNumberLabel.setText("Passport Number");

    addressLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    addressLabel.setForeground(new java.awt.Color(255, 255, 255));
    addressLabel.setText("Address");

    lastNameInput.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txtlastnameActionPerformed(evt);
      }
    });

    passportIDInput.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txtpassportActionPerformed(evt);
      }
    });

    addressInput.setColumns(20);
    addressInput.setRows(5);
    addressBox.setViewportView(addressInput);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                    false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(firstNameLabel)
                                    .addGap(47, 47, 47)
                                    .addComponent(firstNameInput))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(addressLabel)
                                        .addComponent(passportNumberLabel)
                                        .addComponent(nicNumberLabel3))
                                    .addGap(38, 38, 38)
                                    .addGroup(jPanel1Layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(addressBox)
                                        .addComponent(passportIDInput)
                                        .addComponent(nicNumInput))))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lastNameLabel)
                            .addGap(48, 48, 48)
                            .addComponent(lastNameInput, javax.swing.GroupLayout.PREFERRED_SIZE,
                                166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(firstNameLabel)
                        .addComponent(firstNameInput, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lastNameLabel)
                        .addComponent(lastNameInput, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nicNumberLabel3)
                        .addComponent(nicNumInput, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(passportNumberLabel)
                        .addComponent(passportIDInput, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(addressLabel)
                        .addComponent(addressBox, javax.swing.GroupLayout.PREFERRED_SIZE, 62,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
    );

    customerIDLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    customerIDLabel.setText("Customer ID");

    customerID.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
    customerID.setForeground(new java.awt.Color(255, 0, 0));
    customerID.setText("jLabel7");

    jPanel2.setBackground(new java.awt.Color(51, 0, 255));

    dateOfBirthLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    dateOfBirthLabel.setForeground(new java.awt.Color(255, 255, 255));
    dateOfBirthLabel.setText("Date of Birth");

    genderLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    genderLabel.setForeground(new java.awt.Color(255, 255, 255));
    genderLabel.setText("Gender");

    contactLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    contactLabel.setForeground(new java.awt.Color(255, 255, 255));
    contactLabel.setText("Contact");

    maleButton.setText("Male");

    femaleButton.setText("Female");

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(
                    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(dateOfBirthLabel)
                        .addComponent(dateOfBirthInput)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(genderLabel)
                                .addComponent(contactLabel))
                            .addGap(43, 43, 43)
                            .addGroup(jPanel2Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                    false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(maleButton)
                                    .addGap(18, 18, 18)
                                    .addComponent(femaleButton))
                                .addComponent(contactInput))))
                .addContainerGap(41, Short.MAX_VALUE))
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(dateOfBirthLabel)
                .addComponent(dateOfBirthInput)
                .addGap(18, 18, 18)
                .addGroup(
                    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(genderLabel)
                        .addComponent(maleButton)
                        .addComponent(femaleButton))
                .addGap(18, 18, 18)
                .addGroup(
                    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(contactLabel)
                        .addComponent(contactInput, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(108, Short.MAX_VALUE))
    );

    customerPhoto
        .setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    browseButton.setText("Browse");
    browseButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        browseButtonActionPerformed(evt);
      }
    });

    addButton.setText("Add");
    addButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        addCustomerActionPerformed(evt);
      }
    });

    closeButton.setText("Close");
    closeButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        closeButtonActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(customerIDLabel)
                        .addGap(50, 50, 50)
                        .addComponent(customerID))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jPanel2,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(customerPhoto,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 250,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(337, 337, 337)
                                            .addComponent(browseButton,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 87,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(39, 39, 39)
                                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(closeButton,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(24, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerIDLabel)
                    .addComponent(customerID))
                .addGap(41, 41, 41)
                .addGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addGroup(layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                    false)
                                .addComponent(customerPhoto, javax.swing.GroupLayout.DEFAULT_SIZE,
                                    250, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addComponent(browseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
                                    javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                    38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(49, 49, 49))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  /**
   * Generates an ID for each new Customer created
   */
  public void generateCustomerID() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost/airline", "root", "");
      Statement s = con.createStatement();
      ResultSet rs = s.executeQuery("select MAX(id) from customer");
      rs.next();
      rs.getString("MAX(id)");
      if (rs.getString("MAX(id)") == null) {
        customerID.setText("CS001");
      } else {
        long id = Long
            .parseLong(rs.getString("MAX(id)").substring(2, rs.getString("MAX(id)").length()));
        id++;
        customerID.setText("CS" + String.format("%03d", id));


      }


    } catch (ClassNotFoundException ex) {
      Logger.getLogger(CustomerCreationController.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
      Logger.getLogger(CustomerCreationController.class.getName()).log(Level.SEVERE, null, ex);
    }


  }


  private void txtlastnameActionPerformed(
      java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlastnameActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_txtlastnameActionPerformed

  /**
   *
   * @param evt
   */
  private void txtpassportActionPerformed(
      java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpassportActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_txtpassportActionPerformed

  /**
   * This method allows the user to pick and upload an image for the customer
   * record to be stored in the database.
   *
   * @param evt
   */
  private void browseButtonActionPerformed(
      java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    // TODO add your handling code here:

    try {
      JFileChooser picchooser = new JFileChooser();
      picchooser.showOpenDialog(null);
      File pic = picchooser.getSelectedFile();
      FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "png", "jpg");
      picchooser.addChoosableFileFilter(filter);
      path = pic.getAbsolutePath();
      BufferedImage img;
      img = ImageIO.read(picchooser.getSelectedFile());
      ImageIcon imageIcon = new ImageIcon(new
          ImageIcon(img).getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
      customerPhoto.setIcon(imageIcon);

      File image = new File(path);
      FileInputStream fis = new FileInputStream(image);
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      byte[] buff = new byte[1024];
      for (int readNum; (readNum = fis.read(buff)) != -1; ) {
        baos.write(buff, 0, readNum);
      }
      userimage = baos.toByteArray();


    } catch (IOException ex) {
      Logger.getLogger(CustomerCreationController.class.getName()).log(Level.SEVERE, null, ex);
    }


  }//GEN-LAST:event_jButton1ActionPerformed

  /**
   * This method fetches user data from the input fields and inserts it into
   * the Customer table in the database
   * @param evt
   */
  private void addCustomerActionPerformed(
      java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    // TODO add your handling code here:

    String id = customerID.getText();
    String firstname = firstNameInput.getText();
    String lastname = lastNameInput.getText();
    String nic = nicNumInput.getText();
    String passport = passportIDInput.getText();
    String address = addressInput.getText();

    DateFormat da = new SimpleDateFormat("yyyy-MM-dd");
    String date = da.format(dateOfBirthInput.getDate());
    String Gender;

    if (maleButton.isSelected()) {
      Gender = "Male";
    } else {
      Gender = "FeMale";
    }

    String contact = contactInput.getText();

    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost/airline", "root", "");
      pst = con.prepareStatement(
          "insert into customer(id,firstname,lastname,nic,passport,address,dob,gender,contact,photo)values(?,?,?,?,?,?,?,?,?,?)");

      pst.setString(1, id);
      pst.setString(2, firstname);
      pst.setString(3, lastname);
      pst.setString(4, nic);
      pst.setString(5, passport);
      pst.setString(6, address);
      pst.setString(7, date);
      pst.setString(8, Gender);
      pst.setString(9, contact);
      pst.setBytes(10, userimage);
      pst.executeUpdate();

      JOptionPane.showMessageDialog(null, "Registation Createdd.........");


    } catch (ClassNotFoundException ex) {
      Logger.getLogger(CustomerCreationController.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
      Logger.getLogger(CustomerCreationController.class.getName()).log(Level.SEVERE, null, ex);
    }


  }//GEN-LAST:event_jButton2ActionPerformed

  /**
   * 
   * @param evt
   */
  private void closeButtonActionPerformed(
      java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    // TODO add your handling code here:

    this.hide();
  }//GEN-LAST:event_jButton3ActionPerformed


}
