package FNA.Groups;

import FNA.Repositories.HashLongNumberRepository;

/**
 * @author  Omer Kaya github.com/OmerKayaa
 * @version 1.0
 * @since   2020
 */

@SuppressWarnings("Please do not use LongNumberGroup if it not absolutely necessary")
public class LongNumberGroup<E> extends Group<E, HashLongNumberRepository<E>>
{
   public LongNumberGroup()
   {
      super(new HashLongNumberRepository<E>());
   }
   
   public boolean containsAll(LongNumberGroup<E> group)
   {
      this.repository.syncDictionary(group.repository.getDictionary());
      //needs to be implemented
      return this.repository.hasAll(group.repository.getRepo());
   }
   
   public boolean retainAll(LongNumberGroup<E> group)
   {
      this.repository.syncDictionary(group.repository.getDictionary());
      //needs to be implemented
      this.repository.retailTheRepositories(group.repository.getRepo());
      return true;
   }

   public boolean addAll(LongNumberGroup<E> group)
   {
      this.repository.syncDictionary(group.repository.getDictionary());
      //needs to be implemented
      return true;
   }
}
