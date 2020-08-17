package FNA;

import FNA.ArithmeticsTypes.LongNumber;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class LongNumberClassTest
{
   private LongNumber ln = new LongNumber();
   
   @Before
   public void createAHugeNumber()
   {
      ln.setValue(1);
   }
   
   @Test
   public void testZero()
   {
      assertFalse(ln.isZero());
      ln.multiplication(0L);
      assertTrue(ln.isZero());
   }
   
   @Test
   public void testOne()
   {
      assertTrue(ln.isOne());
   }
   
   @Test
   public void testSetNumber()
   {
      ln.setValue(100);
      assertEquals(ln.getValue().toString(),new BigInteger("100").toString());
   }
}
