package FNA.Repositories;

import FNA.ArithmeticsTypes.LongNumber;

/**
 * @author  Omer Kaya github.com/OmerKayaa
 * @version 1.0
 * @since   2020
 */

@SuppressWarnings("Please do not HashLongNumberRepository class if its not absolutely necessary")
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
