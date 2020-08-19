package FNA;

import FNA.ArithmeticsTypes.LongNumber;
import org.junit.Before;
import org.junit.Test;

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
      assertTrue(ln.multiplication(0L).isZero());
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
      assertEquals(ln.getValue(), Long.valueOf(100L));
   }
   
   @Test
   public void testGCD()
   {
      ln.setValue(888);
      assertEquals(111L, (long) ln.GCD(new LongNumber(555)).getValue());
      assertEquals(222L, (long) ln.GCD(new LongNumber(666)).getValue());
      assertEquals(444L, (long) ln.GCD(new LongNumber(444)).getValue());
   }
}
