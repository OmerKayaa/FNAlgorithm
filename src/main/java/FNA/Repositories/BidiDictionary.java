package FNA.Repositories;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * This class is used for assigning prime number values
 * to elements
 *
 * @author  Omer Kaya github.com/OmerKayaa
 * @version 1.0
 * @since   2020
 */

public abstract class BidiDictionary<T,E>
{
   private BidiMap<T,E> dictionary = new DualHashBidiMap<>();
   
   public void syncDictionary(BidiDictionary<T,E> dictionary)
   {
      if(this.dictionary == dictionary)
         return;
      if(dictionary.dictionary != null && ( dictionary.dictionary.size()!=0 || this.dictionary.size()!=0))
      {
         if(dictionary.dictionary.size()==0)
            this.dictionary = dictionary.dictionary;
         else if (this.dictionary.size()==0)
            dictionary.dictionary = this.dictionary;
         else
         {
            NavigableMap<E,Integer> table = new TreeMap<>();
            this.dictionary.values().forEach(e -> table.put(e,howManyExits(e)));
            dictionary.dictionary.values().forEach(e -> table.put(e ,table.getOrDefault(e,0)
                                                                     + dictionary.howManyExits(e)));

            Map<E, Integer> sorted = table.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                 .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
   
            NavigableMap<E,Integer> table1 = new TreeMap<>();
            this.dictionary.values().forEach(e -> table1.put(e,howManyExits(e)));
   
            NavigableMap<E,Integer> table2 = new TreeMap<>();
            dictionary.dictionary.values().forEach(e -> table2.put(e,dictionary.howManyExits(e)));

            dictionary.dictionary = new DualHashBidiMap<>();
            this.dictionary = dictionary.dictionary;
            sorted.forEach((e, integer) -> dictionary.findKeyOrCreate(e));
   
            dictionary.resetElements();
            table2.entrySet().forEach(e -> dictionary.addElement(e.getKey(),e.getValue()));
   
            this.resetElements();
            table1.entrySet().forEach(e -> this.addElement(e.getKey(),e.getValue()));
         }
      }
      this.dictionary = dictionary.dictionary;
   }
   
   public BidiDictionary<T,E> getDictionary()
   {
      return this;
   }
   
   public T registerNewElement(E element)
   {
      T key = newInstance(PrimeNumbers.getPrime(dictionary.size()));
      dictionary.put(key,element);
      return key;
   }
   
   public Iterable<T> keySet()
   {
      return dictionary.keySet();
   }
   
   public Iterable<E> elementSet()
   {
      return dictionary.values();
   }
   
   public Optional<T> findKey(E element)
   {
      if(dictionary.containsValue(element))
         return Optional.of(dictionary.getKey(element));
      else
         return Optional.empty();
   }
   
   public T findKeyOrCreate(E element)
   {
      Optional<T> optionalT = findKey(element);
      return optionalT.orElseGet(() -> registerNewElement(element));
   }
   
   public Optional<E> findValue(T Key)
   {
      return Optional.of(dictionary.get(Key));
   }
   
   public void reset()
   {
      dictionary = new DualHashBidiMap<>();
   }
   
   protected abstract T newInstance(int i);
   
   public abstract int howManyExits(E element);
   
   public abstract void addElement(E element,int count);
   
   public abstract void resetElements();
}
