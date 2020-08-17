package FNA.Repositories;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

import java.util.Optional;

public abstract class BidiDictionary<T,E>
{
   private BidiMap<T,E> dictionary = new DualHashBidiMap<>();
   
   public void registerNewElement(E element)
   {
      if(!dictionary.containsValue(element))
      {
         dictionary.put(typeGenerator(PrimeNumbers.getPrime(dictionary.size())),element);
      }
   }
   
   public abstract T typeGenerator(int i);
   
   public Optional<T> findKey(E element)
   {
      if(dictionary.containsValue(element))
         return Optional.of(dictionary.getKey(element));
      else
         return Optional.empty();
   }
   
   public Optional<E> findValue(T Key)
   {
      return Optional.of(dictionary.get(Key));
   }
   
   public void reset()
   {
      dictionary = new DualHashBidiMap<>();
   }
}
