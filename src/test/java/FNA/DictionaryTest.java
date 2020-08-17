package FNA;

import FNA.ArithmeticsTypes.LongNumber;
import FNA.Repositories.BidiDictionary;
import FNA.Repositories.Repository;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class DictionaryTest
{
   BidiDictionary<LongNumber, String> dictionary = new Repository<>()
   {
      @Override public LongNumber typeGenerator(int i)
      {
         return new LongNumber(i);
      }
   };
   
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
}
