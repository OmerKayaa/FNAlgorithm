package FNA.Repositories;

import FNA.ArithmeticsTypes.LongNumber;

public class HashLongNumberRepository<E> extends Repository<Long,LongNumber,E>
{
   public HashLongNumberRepository()
   {
      super(new LongNumber(1));
   }
   
   @Override protected Long newInstance(int i)
   {
      return (long) i;
   }
   
   
   @Override public void resetElements()
   {
      this.arithmeticRepo.setValue(1L);
   }
}
