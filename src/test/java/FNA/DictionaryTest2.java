package FNA;

import FNA.Repositories.HashLongNumberRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;


public class DictionaryTest2
{
   public HashLongNumberRepository<String> repository1 = new HashLongNumberRepository<>();
   public HashLongNumberRepository<String> repository2 = new HashLongNumberRepository<>();
   
   @Before
   public void setUp()
   {
      repository1 = new HashLongNumberRepository<>();
      repository2 = new HashLongNumberRepository<>();
      IntStream.range(1,7).forEach(value ->
                                    {
                                       repository1.add("Test" + value);
                                       repository1.add("Test" + (value + 5 ));
                                       repository2.add("Test" + (value + 20));
                                    });
   }
   
   @Test
   public void testCombining1()
   {
      repository1.syncDictionary(repository2);
      repository1.elementSet().forEach(s -> s.contains("20"));
   }
   
   @Test
   public void testCombining2()
   {
      repository1.syncDictionary(repository2);
      repository1.combineTheRepositories(repository2.getRepo());
      Assert.assertTrue(repository1.hasElement("Test21"));
   }
   
   @Test
   public void testRetailing()
   {
      repository1.retailTheRepositories(repository2.getRepo());
   }
}
