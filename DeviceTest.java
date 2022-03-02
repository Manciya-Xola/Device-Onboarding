import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class DeviceTest {

   private Device device;

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
      //device = new Device("12344444444", 1, 2, false, "12-qweqwde-asddas");
   }
   
   
   @Test
    public void Get_The_Serial_Number_If_All_The_Values_Are_Correct()
   {
      Device device = new Device("1234567890", 1, 2, "12-qweqwde-asddas");
      assertEquals("1234567890", device.GetSerialNumber());
   }
   
   
   @Test (expected = IllegalArgumentException.class)
    public void Throw_Exception_If_The_Serial_Number_Has_Characters_Not_Equal_To_Ten()
   {
      Device device = new Device("12344444444", 1, 2, "12-qweqwde-asddas");
      assertEquals("123456", device.GetSerialNumber());
   }
   
   
   @Test public void Check_Damage_Status()
   {
      Device device = new Device("1234567890", 1, 2, "12-qweqwde-asddas");
      device.SetDamageStatus(true);
      assertTrue(device.GetDamageStatus(true));
   }
   
   
   @Test(expected = IllegalArgumentException.class)
    public void Throw_An_Exception_When_Inserting_The_Simcard()
   {
      Device device = new Device("1234567890", 1, 2, "12-qweqwde-asddas");
      device.InsertSimcard(new Simcard("12345679012345","1234567890poiuy"));
      assertFalse(device.SimcardInserted());
   }
   
   
   @Test public void Check_If_Simcard_Is_Inserted()
   {
      Device device = new Device("1234567890", 1, 2, "12-qweqwde-asddas");
      device.InsertSimcard(new Simcard("123456789012345","1234567890poiuy"));
      assertTrue(device.SimcardInserted());
   }
   
   
   @Test public void Display_The_IMEI_Number()
   {
      Device device = new Device("1234567890", 1, 2, "12-qweqwde-asddas");
      assertEquals("12-qweqwde-asddas", device.GetIMEINumber());
   }
   
   
   @Test public void Flash_A_Device()
   {
      Device device = new Device("1234567890", 1, 2, "12-qweqwde-asddas");
      device.DeviceFlash(new MockFlashDevice(1));
      assertTrue(device.Device_Is_Flashed());
   }
   
   
   
}
