package FNA;

import FNA.ArithmeticsTypes.HugeNumber;
import FNA.ArithmeticsTypes.LongNumber;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class MainTest
{
   public static void main(String[] args)
   {
      Result result = JUnitCore.runClasses(HugeNumberClassTest.class,
                                           LongNumberClassTest.class,
                                           DictionaryTest.class,
                                           HashHugeNumberRepositoryTest.class);
   
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
   
      System.out.println(result.wasSuccessful()?"All test are successful":"--Testing failed--");
   }
}
