public class Device
{

   
   private int box;
   private int crate;
   private boolean damaged;
   private boolean flashed;
   private Simcard simcard;
   private String IMEI_Number;
   private String Serial_Number;
   private WareHouse warehouse;
   private boolean Key_Injected;
   private boolean Sent_For_Repacking;
   private boolean keyInjected;
   private boolean Flash_Device;
   
   public Device(String Serial_Number, int box, int crate,boolean damage, String IMEI_Number)
   {
      if (Serial_Number.length() != 10)
      {
         throw new IllegalArgumentException("The Serial number must have at exactly 10 characters");
      }
      this.Serial_Number = Serial_Number;
      this.box = box;
      this.crate = crate; 
      this.IMEI_Number = IMEI_Number;
      this.damaged = damage;
   }
   
   
   public boolean GetDamageStatus()
   {
      return this.damaged;
   }
   
   public void SetWarehouse_Number(WareHouse warehouse)
   {
      this.warehouse = warehouse;
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
      this.Flash_Device = flash.FlashDevice();
   }
   
   
   public boolean Device_Is_Flashed()
   {
      return Flash_Device;
   }
   
   
   public void KeyInjection()
   {
      MockKeyInjection k = new MockKeyInjection(0);
      keyInjected = k.InjectKey(new byte[128]);
   }
   public boolean Device_Key_Injected()
   {
   return keyInjected;
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
   
   
   public String toString()
   {
      return "Serial Number: "+this.Serial_Number+
              "\nCrate: "+crate+
              "\nBox:"+box+
              "\nDamage status: "+damaged+
              "\nSimcard: "+simcard+
              "\nFlashed: "+Flash_Device+
              "\nKey Injected: "+keyInjected+
              "\nSent for packing: "+Sent_For_Repacking+
              "Warehouse number: "+warehouse;
   }
}