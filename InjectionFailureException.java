public class InjectionFailureException extends RuntimeException{

   private String message;

   public InjectionFailureException(String message)
   {
      this.message = message;
   }

   public InjectionFailureException(){}
   
   
   public String getMessage()
   {
      return message;
   }
}