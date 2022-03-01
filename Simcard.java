public class Simcard
{
   private String SNN;
   private String IMSI;
   
   public Simcard(String snn, String imsi)
   {
      if(snn.length()<15 || imsi.length()<15)
      {
         throw new IllegalArgumentException("Length of SNN or IMSI must be exactly 15 characters");
      }
      
      SNN = snn;
      IMSI = imsi;
   }
   
   
   public String Get_SNN_Number()
   {
      return SNN;
      
   }
   
   public String Get_IMSI_Number()
   {
      return IMSI;
   }
   
}