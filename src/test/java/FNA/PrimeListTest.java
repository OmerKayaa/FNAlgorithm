package FNA;

import FNA.Repositories.PrimeNumbers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrimeListTest
{
   @Test
   public void nThPrimeNumber()
   {
      assertEquals(1223,PrimeNumbers.getPrime(199));
   }
   
}
