import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class MockFlashDeviceTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

   @Test public void FlashDevice()
   {
      MockFlashDevice flash = new MockFlashDevice(1);
      assertTrue(flash.FlashDevice());
   }
   
   
   @Test (expected = FlashFailureException.class)
    public void FlashDevice_Throws_An_Exception_Since_The_Value_Is_Greater_Than_Two()
   {
      MockFlashDevice flash = new MockFlashDevice(3);
      assertFalse(flash.FlashDevice());
   }
   
   @Test (expected = FlashFailureException.class)
    public void FlashDevice_Throws_An_Exception_Since_The_Value_Is_Negative()
   {
      MockFlashDevice flash = new MockFlashDevice(-3);
      assertFalse(flash.FlashDevice());
   }
   
   
   @Test public void FlashDevice_Fails_Since_The_Value_Is_Equal_To_Two()
   {
      MockFlashDevice flash = new MockFlashDevice(2);
      assertFalse(flash.FlashDevice());
   }
   
   
}
