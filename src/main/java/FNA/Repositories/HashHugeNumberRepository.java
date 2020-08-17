package FNA.Repositories;

import FNA.ArithmeticsTypes.HugeNumber;

public class HashHugeNumberRepository<E> extends Repository<HugeNumber,E> implements ArithmeticRepository<E, HugeNumber>
{
   
   @Override public HugeNumber getKeyByValue(E element)
   {
      return null;
   }
   
   @Override public void addElementValue(E element)
   {
   
   }
   
   @Override public E getValueByKey(HugeNumber Key)
   {
      return null;
   }
   
   @Override public int size()
   {
      return 0;
   }
   
   @Override public HugeNumber typeGenerator(int i)
   {
      return new HugeNumber(i);
   }
}
