import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class RegisterDeviceTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   
   
   @Test public void Create_A_Device_Object_With_Not_Exception()
   {
      RegisterDevice r = new RegisterDevice();
      r.InsertDevice(new Device("1234567890", 1, 2, "1234567890poiuy"));
      assertEquals(1, r.GetNumberOfDevices());
   }

   /** A test that always fails. **/
   @Test public void defaultTest() {
      Assert.assertEquals("Default test added by jGRASP. Delete "
            + "this test once you have added your own.", 0, 1);
   }
}
