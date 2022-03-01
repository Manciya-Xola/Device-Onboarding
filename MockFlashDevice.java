public class MockFlashDevice implements IFlashDevice
{
   private int flash_Value;
   
   public MockFlashDevice(int value)
   {
      this.flash_Value = value;
   }
   
   
   public boolean FlashDevice()
   {
      if(flash_Value > 2 || flash_Value < 0)
      {
         throw new FlashFailureException();
      }
      return flash_Value < 2;
   }
}
