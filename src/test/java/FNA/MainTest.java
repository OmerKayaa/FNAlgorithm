package FNA;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class MainTest
{
   public static void main(String[] args)
   {
      Result result = JUnitCore.runClasses(LongNumberClassTest.class,
              HugeNumberClassTest.class,
              PrimeListTest.class,
              HashHugeNumberRepositoryTest.class,
              HashLongNumberRepositoryTest.class,
              DictionaryTest2.class,
              DictionaryTest.class);

      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }

      System.out.println(result.wasSuccessful()?"\n\n---All tests are successful---\n":"\n\n---Testing failed---\n");
   }
}
