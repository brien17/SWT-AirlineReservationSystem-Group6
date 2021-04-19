public class MainChildrenIntegration {

  Main main;

  public void addCustomerStub() {
    CustomerCreationStub cus = new CustomerCreationStub();
    main.jDesktopPane1.add(cus);
    cus.setVisible(true);
  }
}
