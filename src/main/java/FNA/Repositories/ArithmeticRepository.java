package FNA.Repositories;

import FNA.ArithmeticsTypes.ArithmeticsOperations;

import java.util.Optional;

public interface ArithmeticRepository<N extends ArithmeticsOperations<?>,E>
{
   Optional<N> getKeyByValue(E element);
   void addNewKey(E element);
   Optional<E> getValueByKey(N Key);
   
   void add(E value);
   void remove(E value);
   
   void addNewElementToRepository(N repository);
   void removeElementFromRepository(N repository);
   
   int size();
}
