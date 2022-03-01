import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class SimcardTest {

   private Simcard simcard;
   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
      simcard = new Simcard("123abc2HBYSYT6w","12-3456qwerrt4t");
   }

   @Test (expected = IllegalArgumentException.class)
    public void Throw_An_Exception_If_The_Value_Of_SNN_Or_IMSI_Has_Less_That_Fifteen_Characters()
   {
      Simcard s = new Simcard("123abc2HBYSYT6","12-3456qwerrt4t");
   }
   
   
   @Test public void Check_If_We_Get_The_Correct_SNN()
   {
      assertEquals("123abc2HBYSYT6w",simcard.Get_SNN_Number());
   }
   
   
   @Test public void Check_If_We_Get_The_Correct_IMSI()
   {
      assertEquals("12-3456qwerrt4t",simcard.Get_IMSI_Number());
   }

}
