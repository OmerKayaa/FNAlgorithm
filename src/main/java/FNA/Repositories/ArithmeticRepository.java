package FNA.Repositories;

import FNA.ArithmeticsTypes.ArithmeticsOperations;

import java.util.Collection;

/**
 * @author  Omer Kaya github.com/OmerKayaa
 * @version 1.0
 * @since   2020
 */

public interface ArithmeticRepository<T,N extends ArithmeticsOperations<T>,E>
{
   void add(E element);
   void remove(E element);
   
   boolean hasElement(E element);
   boolean hasAll(N repository);
   
   Collection<E> getAll();
   
   void combineTheRepositories(N repository);
   void retailTheRepositories(N repository);
   void disjunctTheRepositories(N repository);
}
