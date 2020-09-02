package FNA.Repositories;

import FNA.ArithmeticsTypes.HugeNumber;

import java.math.BigInteger;

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
