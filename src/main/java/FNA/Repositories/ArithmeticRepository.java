package FNA.Repositories;

import FNA.ArithmeticsTypes.ArithmeticsOperations;

public interface ArithmeticRepository<E,N extends ArithmeticsOperations>
{
   N getKeyByValue(E element);
   void addElementValue(E element);
   E getValueByKey(N Key);
   int size();
}
