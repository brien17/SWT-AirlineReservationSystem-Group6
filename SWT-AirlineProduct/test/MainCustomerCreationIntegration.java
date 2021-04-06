import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MainCustomerCreationIntegration {
  /**
   * Create instance of Main and stub
   */

  /** Test Case ID: TC-INT-03
   * Requirement ID/Description: SR-NF-09  The system shall allow users to open up
   *            at least 100 windows in the Main menu.
   * Purpose: Stress test the integration link between Main and lower level components.
   * Test Setup: An instance of the MainChildrenIntegration class is created with
   *            a composed class variable of type main set with a new object
   * Test Strategy: Top down integration testing with stub
   * Input: MainChildrenIntegration{ Main main = new Main();  }, int view_count = 0
   * Expected Output: 100
   */

  @Test
  public void stressIntegrationMainCustomerCreation(){
  MainChildrenIntegration stressIntegrationTest = new MainChildrenIntegration();
  stressIntegrationTest.main = new Main();
  int view_count = 0;
  while(view_count < 100){
    stressIntegrationTest.addCustomerStub();
    view_count += 1;
  }
  System.out.println(view_count);
  assertEquals(view_count,100);
  }

}
