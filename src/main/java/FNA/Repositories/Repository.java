package FNA.Repositories;

import FNA.ArithmeticsTypes.ArithmeticsOperations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author  Omer Kaya github.com/OmerKayaa
 * @version 1.0
 * @since   2020
 */

public abstract class  Repository<R,T extends ArithmeticsOperations<R>,E>
      extends BidiDictionary<R,E> implements ArithmeticRepository<R,T,E>
{
   /**
    * Number class that is used for store element
    */
   T arithmeticRepo;
   
   public Repository(T arithmeticRepo)
   {
      this.arithmeticRepo = arithmeticRepo;
   }
   
   public T getRepo()
   {
      return arithmeticRepo;
   }

   /**
    * Multiply the value of the other repository to add
    * the prime number to this number
    *
    * @param element to be add
    */
   @Override public void add(E element)
   {
      arithmeticRepo.setValue(arithmeticRepo.multiplication(findKeyOrCreate(element)).getValue());
   }

   /**
    * Uses List as default collection
    * returns all the elements in a list
    *
    * @return list of elements
    */
   @Override public Collection<E> getAll()
   {
      List<E> All = new ArrayList<>();
      elementSet().forEach(e -> IntStream.range(0,howManyExits(e)).forEach(value -> All.add(e)));
      return All;
   }

   /**
    * Divide the value of the greatest common divisor to
    * remove multiplication of prime number that are common
    *
    * @param element to be removed
    */
   @Override public void remove(E element)
   {
      findKey(element).ifPresent(r -> arithmeticRepo.division(arithmeticRepo.GCD(arithmeticRepo.newInstance(r)).getValue()));
   }

   /**
    * Multiply the value of the other repository to add all
    * the prime numbers to this number
    *
    * @param repository collections of elements combination
    */
   @Override public void combineTheRepositories(T repository)
   {
      arithmeticRepo.setValue(arithmeticRepo.multiplication(repository.getValue()).getValue());
   }

   /**
    * Calculates greatest common divisor to find multiplication
    * of common prime numbers
    *
    * @param repository collection of common elements
    */
   @Override public void retailTheRepositories(T repository)
   {
      arithmeticRepo.setValue(arithmeticRepo.GCD(repository).getValue());
   }

   /**
    * Calculates greatest common divisor to find multiplication
    * of common prime numbers then divide it to obtain
    * multiplication of all prime numbers which is not exist in
    * the other repository
    *
    * @param repository collection of all distinct elements
    */
   @Override public void disjunctTheRepositories(T repository)
   {
      arithmeticRepo.setValue(arithmeticRepo.division(arithmeticRepo.GCD(repository).getValue()).getValue());
   }

   /**
    * Checks if dictionary has a prime number related to
    * this elements
    *
    * @param element to check
    * @return true if there is a prime realted to this element
    */
   @Override public boolean hasElement(E element)
   {
      return findKey(element).isPresent();
   }

   /**
    * Checks if repository value can divide the other repository
    * value without remainder if so that means prime numbers
    * of this repository is presents on the other repository
    * which means this repository contains all the elements.
    *
    * @param repository to check
    * @return true if this repository has all the element
    *         other repository has.
    */
   @Override public boolean hasAll(T repository)
   {
      return arithmeticRepo.noRemainder(repository.getValue());
   }

   /**
    * How many of this element exists in this repository
    *
    * @param element
    * @return count of the element in this repository
    */
   @Override public int howManyExits(E element)
   {
      if(findKey(element).isPresent())
      {
         R key = findKey(element).get();
         ArithmeticsOperations<R> counter = arithmeticRepo.newInstance(arithmeticRepo.getValue());
         int i;
         for(i=0;counter.noRemainder(key);i++)
         {
            counter = counter.division(key);
         }
         return i;
      }
      else return 0;
   }

   /**
    * This method is used to synchronize dictionaries
    * of the repositories
    *
    * When synchronization start repository is reset
    *
    * Once synchronization ends elements added back to
    * repository using this method
    *
    * @param element to be added
    * @param count how many times
    */
   @Override public void addElement(E element, int count)
   {
      for (int i = 0; i < count; i++)
      {
         add(element);
      }
   }

   public void resetDictionary()
   {
      super.reset();
   }
}
