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
   /**
    * Add new element to storage
    * @param element to be add
    */
   void add(E element);

   /**
    * Element to remove from storage
    * Does nothing if element doesn't exists
    *
    * @param element to be removed
    */
   void remove(E element);

   /**
    * Checks if element has a related prime number in the
    * dictionary
    *
    * @param element to check
    * @return true if element exist in the collection
    */
   boolean hasElement(E element);

   /**
    * Check if all the elements exist in the collection
    * @param repository to check
    * @return true if elements exist in the collection
    */
   boolean hasAll(N repository);

   /**
    * All the elements that are exists in the collection
    * @return elements
    */
   Collection<E> getAll();

   /**
    * Combines two collections
    * @param repository collections of elements combination
    */
   void combineTheRepositories(N repository);

   /**
    * Removes all the elements that are not common
    * @param repository collection of common elements
    */
   void retailTheRepositories(N repository);

   /**
    * Removes all the elements that are common
    * @param repository collection of all distinct elements
    */
   void disjunctTheRepositories(N repository);
}
