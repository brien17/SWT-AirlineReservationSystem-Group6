/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Main extends javax.swing.JFrame {

  /** Creates new form Main */
  public Main() {
    initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT
   * modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jDesktopPane1 = new javax.swing.JDesktopPane();
    jMenuBar1 = new javax.swing.JMenuBar();
    customerMenu = new javax.swing.JMenu();
    addCustomerMenuItem = new javax.swing.JMenuItem();
    searchCustomerMenuItem = new javax.swing.JMenuItem();
    ticketMenu = new javax.swing.JMenu();
    bookTicketMenuItem = new javax.swing.JMenuItem();
    ticketReportMenuItem = new javax.swing.JMenuItem();
    flightMenu = new javax.swing.JMenu();
    addFlightMenuItem = new javax.swing.JMenuItem();
    userMenu = new javax.swing.JMenu();
    userCreationMenuItem = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setPreferredSize(new java.awt.Dimension(1366, 768));

    javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
    jDesktopPane1.setLayout(jDesktopPane1Layout);
    jDesktopPane1Layout.setHorizontalGroup(
        jDesktopPane1Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE));
    jDesktopPane1Layout.setVerticalGroup(
        jDesktopPane1Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE));

    customerMenu.setText("Customer");

    addCustomerMenuItem.setText("Add Customer");
    addCustomerMenuItem.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            addCustomerButtonClicked(evt);
          }
        });
    customerMenu.add(addCustomerMenuItem);

    searchCustomerMenuItem.setText("Search Customer");
    searchCustomerMenuItem.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            searchCustomerButtonClicked(evt);
          }
        });
    customerMenu.add(searchCustomerMenuItem);

    jMenuBar1.add(customerMenu);

    ticketMenu.setText("Tickets");

    bookTicketMenuItem.setText("Book Ticket");
    bookTicketMenuItem.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            bookTicketButtonClicked(evt);
          }
        });
    ticketMenu.add(bookTicketMenuItem);

    ticketReportMenuItem.setText("Ticket Report");
    ticketReportMenuItem.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            ticketReportButtonClicked(evt);
          }
        });
    ticketMenu.add(ticketReportMenuItem);

    jMenuBar1.add(ticketMenu);

    flightMenu.setText("Flight");

    addFlightMenuItem.setText("Add Flight");
    addFlightMenuItem.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            addFlightButtonClicked(evt);
          }
        });
    flightMenu.add(addFlightMenuItem);

    jMenuBar1.add(flightMenu);

    userMenu.setText("User");

    userCreationMenuItem.setText("Add User");
    userCreationMenuItem.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            createUserButtonClicked(evt);
          }
        });
    userMenu.add(userCreationMenuItem);

    jMenuBar1.add(userMenu);

    setJMenuBar(jMenuBar1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1));

    pack();
  } // </editor-fold>//GEN-END:initComponents

  /**
   * This method runs when the add customer button is clicked, it creates a new instance of the
   * CustomerCreationController class and sets it as visible on the screen.
   *
   * @param evt The click event provided by the user clicking the button
   */
  private void addCustomerButtonClicked(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_jMenuItem1ActionPerformed

    CustomerCreationController cus = new CustomerCreationController();
    jDesktopPane1.add(cus);
    cus.setVisible(true);
  } // GEN-LAST:event_jMenuItem1ActionPerformed

  /**
   * This method runs when the search customer button is clicked, it creates a new instance of the
   * CustomerSearchController class and sets it as visible on the screen.
   *
   * @param evt The click event provided by the user clicking the button
   */
  private void searchCustomerButtonClicked(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_jMenuItem2ActionPerformed

    CustomerSearchController scus = new CustomerSearchController();
    jDesktopPane1.add(scus);
    scus.setVisible(true);
  } // GEN-LAST:event_jMenuItem2ActionPerformed

  /**
   * This method runs when the add flight button is clicked, it creates a new instance of the
   * FlightAdditionController class and sets it as visible on the screen.
   *
   * @param evt The click event provided by the user clicking the button
   */
  private void addFlightButtonClicked(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_jMenuItem4ActionPerformed

    FlightAdditionController f = new FlightAdditionController();
    jDesktopPane1.add(f);
    f.setVisible(true);
  } // GEN-LAST:event_jMenuItem4ActionPerformed

  /**
   * This method runs when the book ticket button is clicked, it creates a new instance of the
   * TicketController class and sets it as visible on the screen.
   *
   * @param evt The click event provided by the user clicking the button
   */
  private void bookTicketButtonClicked(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_jMenuItem3ActionPerformed

    TicketController t = new TicketController();
    jDesktopPane1.add(t);
    t.setVisible(true);
  } // GEN-LAST:event_jMenuItem3ActionPerformed

  /**
   * This method runs when the search ticket report button is clicked, it creates a new instance of
   * the TicketReportController class and sets it as visible on the screen.
   *
   * @param evt The click event provided by the user clicking the button
   */
  private void ticketReportButtonClicked(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_jMenuItem6ActionPerformed

    TicketReportController ti = new TicketReportController();
    showTicketReport(ti);
  } // GEN-LAST:event_jMenuItem6ActionPerformed

  void showTicketReport(TicketReportController ticketController) {
    jDesktopPane1.add(ticketController);
    ticketController.setVisible(true);
  }

  /**
   * This method runs when the create user button is clicked, it creates a new instance of the
   * UserCreationController class and sets it as visible on the screen.
   *
   * @param evt The click event provided by the user clicking the button
   */
  private void createUserButtonClicked(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_jMenuItem5ActionPerformed

    UserCreationController u = new UserCreationController();
    jDesktopPane1.add(u);
    u.setVisible(true);
  } // GEN-LAST:event_jMenuItem5ActionPerformed

  /** @param args the command line arguments */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info :
          javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(Main.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(Main.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(Main.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(Main.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    }
    // </editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(
        new Runnable() {
          public void run() {
            new Main().setVisible(true);
          }
        });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  javax.swing.JDesktopPane jDesktopPane1;
  private javax.swing.JMenu customerMenu;
  private javax.swing.JMenu ticketMenu;
  private javax.swing.JMenu flightMenu;
  private javax.swing.JMenu userMenu;
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JMenuItem addCustomerMenuItem;
  private javax.swing.JMenuItem searchCustomerMenuItem;
  private javax.swing.JMenuItem bookTicketMenuItem;
  private javax.swing.JMenuItem addFlightMenuItem;
  private javax.swing.JMenuItem userCreationMenuItem;
  private javax.swing.JMenuItem ticketReportMenuItem;
  // End of variables declaration//GEN-END:variables
}
