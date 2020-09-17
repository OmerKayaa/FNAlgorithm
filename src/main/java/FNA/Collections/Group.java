package FNA.Collections;

import FNA.Repositories.Repository;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author  Omer Kaya github.com/OmerKayaa
 * @version 1.0
 * @since   2020
 * @see java.util.Collection
 */

public abstract class Group<E,R extends Repository<?,?,E>> implements Collection<E>
{
   protected R repository;
   
   public Group(R repository)
   {
      this.repository = repository;
   }
   
   @Override public int size()
   {
      return repository.getAll().size();
   }
   
   @Override public boolean isEmpty()
   {
      return repository.getRepo().isOne();
   }
   
   @Override public boolean contains(Object o)
   {
      try
      {
         return repository.hasElement((E)o);
      }
      catch (ClassCastException exception)
      {
         return false;
      }
   }
   
   @Override public Iterator<E> iterator()
   {
      return repository.getAll().iterator();
   }
   
   @Override public Object[] toArray()
   {
      return repository.getAll().toArray();
   }
   
   @Override public <T> T[] toArray(T[] a)
   {
      return repository.getAll().toArray(a);
   }
   
   @Override public boolean add(E e)
   {
      repository.add(e);
      return true;
   }
   
   @Override public boolean remove(Object o)
   {
      try
      {
         repository.remove((E)o);
         return repository.hasElement((E)o);
      }
      catch (ClassCastException exception)
      {
         return false;
      }
   }
   
   @Override public boolean containsAll(Collection<?> c)
   {
      return repository.getAll().containsAll(c);
   }
   
   @Override public boolean addAll(Collection<? extends E> c)
   {
      c.forEach(e -> repository.add(e));
      return true;
   }
   
   @Override public boolean removeAll(Collection<?> c)
   {
      try
      {
         c.forEach(o -> repository.remove((E)o));
      }
      catch (ClassCastException classCastException)
      {
         return false;
      }
      return true;
   }
   
   @Override public boolean retainAll(Collection<?> c)
   {
      throw new UnsupportedOperationException();
   }
   
   @Override public void clear()
   {
      repository.getRepo().setValue(1);
      repository.reset();
   }
}
