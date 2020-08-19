package FNA.Repositories;

import FNA.ArithmeticsTypes.LongNumber;

public class HashLongNumberRepository<E> extends Repository<Long,LongNumber,E>
{
   @Override public LongNumber typeGenerator(int i)
   {
      return new LongNumber(i);
   }
   
}
