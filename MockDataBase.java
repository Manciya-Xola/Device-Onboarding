import java.util.*;
import java.util.Collection.*;

public class MockDataBase
{

   private List<Device> devices;
   
   public MockDataBase()
   {
      devices = new ArrayList<Device>();;
   }
   
   
   public void insertDevice(Device device)
   {
      devices.add(device);
   }
   
   public boolean Check_If_Device_Is_In_Database(Device device)
   {
      for(Device deviceItem : devices)
      {
         if(deviceItem.getSerialNumber().equals(device.getSerialNumber()))
         {
            return true;
         }
      }
      return false;
   }
   
   
   public List<Device> getAllDevices()
   {
      return devices;
   }
   
   
   public void deleteDevice(Device device)
   {
      for(Device deviceItem : devices)
      {
         if(deviceItem.getSerialNumber().equals(device.getSerialNumber()))
         {
            devices.remove(device);
         }
      }
   }
   
   public void DeleteAllDevices()
   {
      devices.clear();
   }
   public boolean IsEmpty()
   {
      if(devices.size()==0)
      {
         return true;
      }
      return false;
   }
}