package FNA.Repositories;

import FNA.ArithmeticsTypes.ArithmeticsOperations;

import java.util.Map;

public interface ArithmeticRepository<T,N extends ArithmeticsOperations<T>,E>
{
   void add(E element);
   void remove(E element);
   
   boolean hasElement(E element);
   
   void combineTheRepositories(N repository);
   void retailTheRepositories(N repository);
}
