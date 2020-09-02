package FNA;

import FNA.Repositories.HashHugeNumberRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

public class HashHugeNumberRepositoryTest
{
   public HashHugeNumberRepository<String> repository1 = new HashHugeNumberRepository<>();
   public HashHugeNumberRepository<String> repository2 = new HashHugeNumberRepository<>();
   
   @Before
   public void setUp()
   {
      repository2.syncDictionary(repository1);
      IntStream.range(1, 7).forEach(value ->
                                    {
                                       repository1.add("Test" + value);
                                       repository2.add("Test" + (value + 20));
                                    });
      repository1.add("Test11");
   }
   
   @Test
   public void testGetAll()
   {
      String all = "Test1 " +"Test1 " +"Test2 " +"Test2 " +"Test11 " +"Test3 " +"Test4 " +"Test5 " +"Test6 ";
      
      repository1.add("Test" + 1);
      repository1.add("Test" + 2);
      repository1.getAll().forEach(s -> Assert.assertTrue(all.contains(s)));
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
