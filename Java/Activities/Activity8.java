package NehaActivity1;

//2) Main class with main + exceptionTest() method
public class Activity8 {
 

 public static void exceptionTest(String str) throws CustomException {
     if (str == null) {
         throw new CustomException("Error String is null");
     } else {
         System.out.println("This string: " + str);
     }
 }

 public static void main(String[] args) {
     try {
     
         exceptionTest("Hello, world!");
         
         // Call with null — should throw CustomException
         exceptionTest(null);
     } catch (CustomException ex) {
         // Print custom error message
         System.out.println(" custom exception: " + ex.getMessage());
     }
 }
}
