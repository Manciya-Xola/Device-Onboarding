import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import junit.runner.Version;

public class MockKeyInjectionTest {


   @Test public void Key_Injected_Correctly()
   {
      MockKeyInjection keyinject = new MockKeyInjection(0);
      byte[] key = new byte[128];
      assertTrue(keyinject.InjectKey(key));
   }
   
   
   @Test public void Key_Injection_Failed_Due_To_Value()
   {
      MockKeyInjection keyinject = new MockKeyInjection(1);
      byte[] key = new byte[128];
      assertFalse(keyinject.InjectKey(key));
   }
   
   
   @Test (expected = InjectionFailureException.class)
    public void Throws_Exception_Due_To_The_Size_Of_The_Key()
   {
         MockKeyInjection keyinject = new MockKeyInjection(0);
         byte[] key = new byte[129];
         keyinject.InjectKey(key);
   }
   
   
   @Test (expected = InjectionFailureException.class)
    public void Throws_Exception_Due_To_The_Value_Passed()
   {
         MockKeyInjection keyinject = new MockKeyInjection(-1);
         byte[] key = new byte[128];
         keyinject.InjectKey(key);
   }
}
