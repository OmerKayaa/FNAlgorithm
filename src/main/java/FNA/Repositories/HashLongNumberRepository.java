package FNA.Repositories;

import FNA.ArithmeticsTypes.HugeNumber;
import FNA.ArithmeticsTypes.LongNumber;

public class HashLongNumberRepository<E> extends Repository<LongNumber,E> implements ArithmeticRepository<E, LongNumber>
{
   @Override public LongNumber typeGenerator(int i)
   {
      return new LongNumber(i);
   }
   
   @Override public LongNumber getKeyByValue(E element)
   {
      return null;
   }
   
   @Override public void addElementValue(E element)
   {
   
   }
   
   @Override public E getValueByKey(LongNumber Key)
   {
      return null;
   }
   
   @Override public int size()
   {
      return 0;
   }
}
