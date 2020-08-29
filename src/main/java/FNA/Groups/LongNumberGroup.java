package FNA.Groups;

import FNA.Repositories.HashLongNumberRepository;

public class LongNumberGroup<E> extends Group<E, HashLongNumberRepository<E>>
{
   public LongNumberGroup()
   {
      super(new HashLongNumberRepository<E>());
   }
   
   public boolean containsAll(Group<E, HashLongNumberRepository<E> > c)
   {
      return this.repository.hasAll(c.repository.getRepo());
   }
   
   public boolean retainAll(Group<E, HashLongNumberRepository<E>> c)
   {
      this.repository.retailTheRepositories(c.repository.getRepo());
      return true;
   }
}
