import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import java.util.*;

public class MockDataBaseTest {

   private MockDataBase database = new MockDataBase();


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
      database.insertDevice(new Device("1234567890", 1, 3, true, "12345grew123234"));
      database.insertDevice(new Device("1234567891", 1, 3, true, "12345grew123234"));
      database.insertDevice(new Device("1234567892", 1, 3, true, "12345grew123234"));
      database.insertDevice(new Device("1234567893", 1, 3, true, "12345grew123234"));
      database.insertDevice(new Device("1234567894", 1, 3, true, "12345grew123234"));
   }
   
   
   @Test public void Testing_Mock_DataBase_Inserted()
   {
      assertTrue(database.Check_If_Device_Is_In_Database( new Device("1234567890", 1, 3, true, "12345grew123234")));
   }
   
   
   @Test (expected = NoSuchElementException.class)
    public void Testing_Mock_DataBase_Remove_A_Device()
   {
      database.deleteDevice(new Device("12345678", 1, 3, true, "12345grew123234"));
      assertEquals(4, database.GetSizeOfDatabase());
   }
   
   
   @Test public void Check_If_The_device_is_In_Database()
   {
      Device device = new Device("1234567890", 1, 3, true, "12345grew123234");
      assertEquals(device.GetSerialNumber(), database.FindDevice("1234567890").GetSerialNumber());
   }
   
   
   @Test(expected = NoSuchElementException.class)
    public void Throws_Exception_If_The_device_is_Not_In_Database()
   {
      Device device = new Device("1234567890", 1, 3, true, "12345grew123234");
      assertEquals(device, database.FindDevice("1234567899"));
   }
   
   
   @Test public void Mock_DataBase_Is_Empty_Reurn_True()
   {
      MockDataBase d = new MockDataBase();
      assertTrue(d.IsEmpty());
   }
   
   
   @Test public void Mock_DataBase_Is_Empty_Reurn_False()
   {
      assertFalse(database.IsEmpty());
   }
   
   
   @Test public void Testing_Mock_DataBase_DeleteAllDevices()
   {
      database.DeleteAllDevices();
   }
   
   @After
    public void destroy() {
      database.DeleteAllDevices();
   }
}
