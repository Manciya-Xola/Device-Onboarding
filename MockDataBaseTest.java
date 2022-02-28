import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class MockDataBaseTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   
   
   @Test public void Testing_Mock_DataBase_Insert()
   {
      Device device = new Device();
      MockDataBase database = new MockDataBase();
      database.insertDevice(device);
      assertTrue(database.Check_If_Device_Is_In_Database( device));
   }
   
   
   @Test public void Testing_Mock_DataBase_Remove()
   {
      Device device = new Device();
      MockDataBase d = new MockDataBase();
      d.insertDevice(device);
      assertTrue(d.deleteDevice(device));
   }
   
   
   @Test public void Testing_Mock_DataBase_Is_Empty()
   {
      MockDataBase d = new MockDataBase();
      assertTrue(d.IsEmpty());
   }
   
   
   @Test public void Testing_Mock_DataBase_DeleteAllDevices()
   {
      Device device = new Device();
      MockDataBase d = new MockDataBase();
      d.insertDevice(device);
      assertTrue(d.DeleteAllDevices());
   }
   
   
   
}
