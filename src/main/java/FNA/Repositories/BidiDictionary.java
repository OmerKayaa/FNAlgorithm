package FNA.Repositories;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

import java.util.Optional;

public abstract class BidiDictionary<T,E>
{
   private BidiMap<T,E> dictionary = new DualHashBidiMap<>();
   
   T registerNewElement(E element)
   {
      T key = typeGenerator(PrimeNumbers.getPrime(dictionary.size()));
      dictionary.put(key,element);
      return key;
   }
   
   Optional<T> findKey(E element)
   {
      if(dictionary.containsValue(element))
         return Optional.of(dictionary.getKey(element));
      else
         return Optional.empty();
   }
   
   T findKeyOrCreate(E element)
   {
      Optional<T> optionalT = findKey(element);
      return optionalT.orElseGet(() -> registerNewElement(element));
   }
   
   Optional<E> findValue(T Key)
   {
      return Optional.of(dictionary.get(Key));
   }
   
   void reset()
   {
      dictionary = new DualHashBidiMap<>();
   }
   
   public abstract T typeGenerator(int i);
}
