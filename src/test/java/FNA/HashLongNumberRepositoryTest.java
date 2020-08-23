package FNA;

import FNA.Repositories.HashLongNumberRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

public class HashLongNumberRepositoryTest
{
   public HashLongNumberRepository<String> repository1 = new HashLongNumberRepository<>();
   public HashLongNumberRepository<String> repository2 = new HashLongNumberRepository<>();
   
   @Before
   public void setUp()
   {
      repository2.syncDictionary(repository1);
      IntStream.range(1,7).forEach(value ->
                                    {
                                       repository1.add("Test" + value);
                                       repository2.add("Test" + (value + 20));
                                    });
      repository1.add("Test11");
   }
   
   @Test
   public void testCombining()
   {
      repository1.combineTheRepositories(repository2.getRepo());
      repository2.elementSet().forEach(System.out::println);
   }
   
   @Test
   public void testRetailing()
   {
      repository1.retailTheRepositories(repository2.getRepo());
   }
}
