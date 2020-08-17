package FNA;

import FNA.ArithmeticsTypes.HugeNumber;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class HugeNumberClassTest
{
   private HugeNumber hn = new HugeNumber();
   
   @Before
   public void createAHugeNumber()
   {
      hn.setValue(BigInteger.ONE);
   }
   
   @Test
   public void testZero()
   {
      assertFalse(hn.isZero());
      hn.multiplication(BigInteger.ZERO);
      assertTrue(hn.isZero());
   }
   
   @Test
   public void testOne()
   {
      assertTrue(hn.isOne());
   }
   
   @Test
   public void testSetNumber()
   {
      hn.setValue(100);
      assertEquals(hn.getValue().toString(),new BigInteger("100").toString());
   }
}
