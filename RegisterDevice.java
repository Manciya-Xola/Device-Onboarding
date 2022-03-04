import java.util.*;

public class RegisterDevice
{
   private static MockDataBase db = new MockDataBase();
   private static Scanner input = new Scanner(System.in);
   private static String Menu()
   {
      return "Please Select What you would like to do and press Enter \n"+
             "1) Insert a device to the database.\n"+
             "2) Insert Simcard to the device.\n"+
             "3) Delete a device from the database.\n"+
             "4) Find a device.\n"+
             "5) Display All devices.\n"+
             "6) Flash a device.\n"+
             "7) Inject a key to the device.\n"+
             "8) Send the device for packing and Store in our warehouse.\n"+
             "9) Exit or Done\n";
   }
   public static Device InsertDevice()
   {
      System.out.println("Please enter the crate number:");
      int crate = input.nextInt();
      
      System.out.println("Please enter the box number:");
      int box = input.nextInt();
      
      System.out.println("Please enter the device serial number (10 characters).");
      String serial_number = input.next();
      
      System.out.println("Is the device damaged? Y/N");
      String damage = input.next();
      boolean damaged_status;
      
      if(damage.equals("Y")){damaged_status = true;}
      else{damaged_status=false;}
      
      System.out.println("Please enter the IMEI number for the device (Must be 15 digits).");
      String IMEI_Number = input.next();
      
      return new Device(serial_number, box, crate, damaged_status, IMEI_Number);
   }
   
   private static void Insert_Simcard()
   {
      System.out.println("Please enter the serial number of the device you would like to insert a simcard on:");
      String serial_Number = input.next();
      
      Device device = db.FindDevice(serial_Number);
      
      if(device != null)
      {
         System.out.println("Please enter the SNN (Must be 15 characters)");
         String snn = input.next();
         System.out.println("Please enter the IMSI (Must be 15 characters)");
         String imsi = input.next();
         device.InsertSimcard(new Simcard(snn, imsi));
         db.update(device);
      }
      else
      {
         System.out.println("Device does not exist.");
         return;
      }
      
   }
   
   private static void DeleteDevice()
   {
      System.out.println("Please enter the serial number of the device you would like to Delete from the database:");
      String serial_Number = input.next();
      if(db.FindDevice(serial_Number) != null )
      {
         db.deleteDevice(db.FindDevice(serial_Number));
         System.out.println("Device Deleted from the database.");
         return;
      }
      System.out.println("Device does not exist.");
      return;
   }
   private static Device FindDevice()
   {
      System.out.println("Please enter the serial number of the device you would like to find:");
      String serial_Number = input.next();
      return db.FindDevice(serial_Number);
   }
   private static void FlashDevice()
   {
      System.out.println("Please enter the serial number of the device you would like to flash:");
      String serial_Number = input.next();
      Device device = db.FindDevice(serial_Number);
      if(device != null )
      {
         device.DeviceFlash(new MockFlashDevice(1));
         db.update(device);
         return;
      }
      System.out.println("The serial number entered does not belong to any device.");
      return;
   }
   private static void KeyInjection()
   {
      System.out.println("Please enter the serial number of the device you would like to inject a key on:");
      String serial_Number = input.next();
      Device device = db.FindDevice(serial_Number);
      if(device != null && device.Device_Is_Flashed())
      {
         device.KeyInjection();
         db.update(device);
         return;
      }
      System.out.println("The device does not exist or has not been flashed");
      return;
      
   }
   private static void Repack_And_Store()
   {
      System.out.println("Please enter the serial number of the device you would like to inject a key on:");
      String serial_Number = input.next();
      
      Device device = db.FindDevice(serial_Number);
      if(device != null && device.Device_Key_Injected())
      {
         System.out.println("Please enter the warehouse number:");
         int warehouse_number = input.nextInt(); 
      
         System.out.println("Please enter the warehouse section:");
         int section_number = input.nextInt();
       
         System.out.println("Please enter the warehouse row:");
         int row = input.nextInt(); 
      
         System.out.println("Please enter the warehouse shelf:");
         int shelf = input.nextInt(); 
      
         System.out.println("Please enter the warehouse segment number:");
         int segment_number = input.nextInt(); 
      
         System.out.println("Please enter the segment (Front Left, Front Centre, Front Right, Back Left, Back Centre and Back Right):");
         String segment = input.nextLine(); 
      
         device.SetWarehouse_Number(new WareHouse(warehouse_number, section_number, row, shelf, segment_number, segment));
         db.update(device);
         return;
      }
      System.out.println("The device does not exist or has not been injected with the key.");
      return;
   }
   private static void displayAllDevices()
   {
      for(Device device:db.getAllDevices())
      {
         System.out.println(device);
      }
   }
   public static void main(String[] args)
   {
      
      System.out.println("*********************** Device Onboading *********************\n");
      
      
      while(true)
      {
         System.out.println(Menu());
         int option = input.nextInt();
         if(option == 1)
         {
            db.insertDevice(InsertDevice());
         }
         else if(option ==2)
         {
            Insert_Simcard();
         }
         else if(option ==3)
         {
            DeleteDevice();
         }
         else if(option == 4)
         {
            System.out.println(FindDevice());
         }
         else if(option == 5)
         {
            displayAllDevices();
         }
         else if(option == 6)
         {
            FlashDevice();
         }
         else if(option == 7)
         {
            KeyInjection();
         }
         else if(option == 8)
         {
            Repack_And_Store();
         }
         else if(option == 9)
         {
            break;
         }
      }
      System.out.println("Thank you.");
   }
}