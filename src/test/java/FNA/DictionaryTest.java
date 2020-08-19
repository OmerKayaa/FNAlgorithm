package FNA;

import FNA.ArithmeticsTypes.LongNumber;
import FNA.Repositories.HashLongNumberRepository;
import FNA.Repositories.Repository;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class DictionaryTest
{
   Repository<LongNumber, String> dictionary = new HashLongNumberRepository<>();
   
   @Before
   public void reset()
   {
      dictionary.reset();
   }
   
   @Test
   public void testRegistering()
   {
      dictionary.addNewKey("Test");
   }
   
   @Test
   public void testAdding()
   {
      IntStream.range(1, 5).forEach( i -> dictionary.addNewKey("Test" + i));
   }
   
   @Test
   public void testFinding()
   {
      assertTrue(dictionary.getKeyByValue("Non").isEmpty());
      IntStream.range(1, 5).forEach( i ->
                                     {
                                        dictionary.addNewKey("Test" + i);
                                        assertFalse(dictionary.getKeyByValue("Test" + i).isEmpty());
                                     });
   }
   
   @Test
   public void testBiDirectionalFinding()
   {
      IntStream.range(1, 5).forEach( i ->
                                     {
                                        dictionary.addNewKey("Test" + i);
                                        assertNotNull(dictionary.getValueByKey(dictionary.getKeyByValue(
                                             "Test" + i).get()).get());
                                     });
   }
}
