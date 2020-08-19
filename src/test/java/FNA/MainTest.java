package FNA;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class MainTest
{
   public static void main(String[] args)
   {
      Result result = JUnitCore.runClasses(LongNumberClassTest.class,
                                           DictionaryTest.class);
   
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
   
      System.out.println(result.wasSuccessful()?"All test are successful":"--Testing failed--");
   }
}
