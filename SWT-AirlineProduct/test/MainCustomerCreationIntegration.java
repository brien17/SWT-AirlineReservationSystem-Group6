import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MainCustomerCreationIntegration {
  /**
   * Create instance of Main and stub
   */


  @Test
  public void stressIntegrationMainCustomerCreation(){
  MainChildrenIntegration stressIntegrationTest = new MainChildrenIntegration();
  stressIntegrationTest.main = new Main();
  int view_count = 0;
  while(view_count < 1000){
    stressIntegrationTest.addCustomerStub();
    view_count += 1;
  }
  System.out.println(view_count);
  assertEquals(view_count,1000);
  }

}
