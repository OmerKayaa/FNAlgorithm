package FNA.Groups;

import FNA.Repositories.HashHugeNumberRepository;

import java.util.Collection;
import java.util.Iterator;

public class HugeNumberGroup<E> extends Group<E, HashHugeNumberRepository<E>>
{
   public HugeNumberGroup()
   {
      this.ArithmeticRepository = new HashHugeNumberRepository<>();
   }
   
   @Override public boolean contains(Object o)
   {
      return false;
   }
   
   @Override public Iterator<E> iterator()
   {
      return null;
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
   
   @Override public boolean containsAll(Collection<?> c)
   {
      return false;
   }
   
   @Override public boolean addAll(Collection<? extends E> c)
   {
      return false;
   }
   
   @Override public boolean removeAll(Collection<?> c)
   {
      return false;
   }
   
   @Override public boolean retainAll(Collection<?> c)
   {
      return false;
   }
   
   @Override public void clear()
   {
   
   }
}
