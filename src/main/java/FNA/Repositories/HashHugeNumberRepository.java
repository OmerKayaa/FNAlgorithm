package FNA.Repositories;

import FNA.ArithmeticsTypes.HugeNumber;

import java.math.BigInteger;

/**
 * @author  Omer Kaya github.com/OmerKayaa
 * @version 1.0
 * @since   2020
 */

public class HashHugeNumberRepository<E> extends Repository<BigInteger, HugeNumber,E>
{
   public HashHugeNumberRepository()
   {
      super(new HugeNumber());
   }
   
   @Override protected BigInteger newInstance(int i)
   {
      return BigInteger.valueOf(i);
   }
   
   @Override public void resetElements()
   {
      arithmeticRepo.setValue(BigInteger.ONE);
   }
}
