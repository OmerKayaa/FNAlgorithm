package FNA;

import FNA.ArithmeticsTypes.LongNumber;
import FNA.Repositories.BidiDictionary;
import FNA.Repositories.HashLongNumberRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class DictionaryTest
{
   BidiDictionary<Long,String> dictionary = new HashLongNumberRepository<>();
   
   @Before
   public void reset()
   {
      dictionary.reset();
   }
   
   @Test
   public void testRegistering()
   {
      dictionary.registerNewElement("Test");
   }
   
   @Test
   public void testAdding()
   {
      IntStream.range(1, 5).forEach( i -> dictionary.registerNewElement("Test" + i));
   }
   
   @Test
   public void testFinding()
   {
      assertTrue(dictionary.findKey("Non").isEmpty());
      IntStream.range(1, 5).forEach( i ->
                                     {
                                        dictionary.registerNewElement("Test" + i);
                                        assertFalse(dictionary.findKey("Test" + i).isEmpty());
                                     });
   }
   
   @Test
   public void testBiDirectionalFinding()
   {
      IntStream.range(1, 5).forEach( i ->
                                     {
                                        dictionary.registerNewElement("Test" + i);
                                        assertNotNull(dictionary.findValue(dictionary.findKey(
                                             "Test" + i).get()).get());
                                     });
   }
   
   @Test
   public void testViewDictionary()
   {
      IntStream.range(1, 5).forEach( i -> dictionary.registerNewElement("Test" + i));
      dictionary.keySet().forEach(System.out::println);
      dictionary.elementSet().forEach(System.out::println);
   }
}
