package FNA.Groups;

import FNA.Repositories.ArithmeticRepository;

import java.util.Collection;

public abstract class Group<E,N extends ArithmeticRepository<E,?>> implements Collection<E>
{
   N ArithmeticRepository;
   
   @Override public int size()
   {
      return ArithmeticRepository.size();
   }
   
   @Override public boolean isEmpty()
   {
      return size()==0;
   }
   
   @Override public boolean contains(Object o)
   {
      return false;
   }
   
   @Override public Object[] toArray()
   {
      return new Object[0];
   }
   
   @Override public <T> T[] toArray(T[] a)
   {
      return null;
   }
   
   @Override public boolean add(E e)
   {
      return false;
   }
   
   @Override public boolean remove(Object o)
   {
      return false;
   }
}
