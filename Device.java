public class Device
{

   
   private int box;
   private int crate;
   private boolean damaged;
   private boolean flashed;
   private Simcard simcard;
   private String IMEI_Number;
   private String Serial_Number;
   private int warehouse_Number;
   private boolean Key_Injected;
   private boolean Sent_For_Repacking;
   private MockKeyInjection keyInjected;
   private MockFlashDevice Flash_Device;
   
   public Device(String Serial_Number, int box, int crate, String IMEI_Number)
   {
      if (Serial_Number.length() != 10)
      {
         throw new IllegalArgumentException("The Serial number must have at exactly 10 characters");
      }
      this.Serial_Number = Serial_Number;
      this.box = box;
      this.crate = crate; 
      this.IMEI_Number = IMEI_Number;
   }
   
   
   
   public void SetDamageStatus(boolean damage)
   {
      this.damaged = damage;
   }
   
   
   public boolean GetDamageStatus(boolean damage)
   {
      return this.damaged;
   }
   
   public void SetWarehouse_Number(int warehouse)
   {
      warehouse_Number = warehouse;
   }
    
    
   public void InsertSimcard(Simcard simcard)
   {
      this.simcard = simcard;
   }
   
   
   
   public boolean SimcardInserted()
   {
      if(simcard != null)
      {
         return true;
      }
      return false;
   }
   
   // not really sure how to implement this part
   public void DeviceFlash(MockFlashDevice flash)
   {
      this.Flash_Device = flash;
   }
   
   
   public boolean Device_Is_Flashed()
   {
      return Flash_Device.FlashDevice();
   }
   
   
   private void KeyInjection()
   {
      keyInjected = new MockKeyInjection(0);
   }
   
   
   public void Sent_For_Packing(boolean sent_For_Packing)
   {
      Sent_For_Repacking = sent_For_Packing;
   }
   
   public String GetIMEINumber()
   {
   return IMEI_Number;
   }
   public String GetSerialNumber()
   {
      return Serial_Number;
   }
   
}