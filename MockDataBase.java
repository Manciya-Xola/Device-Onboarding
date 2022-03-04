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
         if(deviceItem.GetSerialNumber().equals(device.GetSerialNumber()))
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
   
   public int GetSizeOfDatabase()
   {
      return devices.size();
   }
   
   public Device FindDevice(String Serial_Number)
   {
      for(Device deviceItem : devices)
      {
         if(deviceItem.GetSerialNumber().equals(Serial_Number))
         {
            return deviceItem;
         }
      }
      return null;
   }
   
   
   public void update(Device device)
   {
      if(Check_If_Device_Is_In_Database(device))
      {
         devices.set(IndexOfDevice(device.GetSerialNumber()), device);
         return;
      }
      throw new NoSuchElementException();
   }
   public int IndexOfDevice(String Serial_Number)
   {
      int index =0;
      for(Device deviceItem : devices)
      {
         
         if(deviceItem.GetSerialNumber().equals(Serial_Number))
         {
            return index;
         }
         index++;
      }
      return -1;
   }
   public void deleteDevice(Device device)
   {
      if (!devices.contains(device)) {
         throw new NoSuchElementException();
      }
      devices.remove(device);
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