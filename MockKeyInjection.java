interface IKeyInjector
{
   public boolean InjectKey(byte[] key);
}

public class MockKeyInjection implements IKeyInjector
{
   private int key_Injected;

   public MockKeyInjection(int value)
   {
      this.key_Injected = value;
   }

   public boolean  InjectKey(byte[] key)
   {
      if(key.length != 128 || key_Injected<0)
      {
         throw new InjectionFailureException();
      }
      else{
         return key_Injected == 0;
      }
   }
}
