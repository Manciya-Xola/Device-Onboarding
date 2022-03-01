public class FlashFailureException extends RuntimeException{

   private String message;

   public FlashFailureException(String message)
   {
      this.message = message;
   }

   public FlashFailureException(){}
   
   
   public String getMessage()
   {
      return message;
   }
}