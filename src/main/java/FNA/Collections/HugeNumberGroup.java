package FNA.Collections;

import FNA.Repositories.HashHugeNumberRepository;

/**
 * @author  Omer Kaya github.com/OmerKayaa
 * @version 1.0
 * @since   2020
 */

public class HugeNumberGroup<E> extends Group<E, HashHugeNumberRepository<E>>
{
   public HugeNumberGroup()
   {
      super(new HashHugeNumberRepository<E>());
   }
   
   public boolean containsAll(HugeNumberGroup<E> group)
   {
      this.repository.syncDictionary(group.repository.getDictionary());
      return this.repository.hasAll(group.repository.getRepo());
   }

   public boolean removeAll(HugeNumberGroup<E> group)
   {
      this.repository.syncDictionary(group.repository.getDictionary());
      this.repository.disjunctTheRepositories(group.repository.getRepo());
      return true;
   }

   public boolean retainAll(HugeNumberGroup<E> group)
   {
      this.repository.syncDictionary(group.repository.getDictionary());
      this.repository.retailTheRepositories(group.repository.getRepo());
      return true;
   }

   public boolean addAll(HugeNumberGroup<E> group)
   {
      this.repository.syncDictionary(group.repository.getDictionary());
      this.repository.combineTheRepositories(group.repository.getRepo());
      return true;
   }
}
