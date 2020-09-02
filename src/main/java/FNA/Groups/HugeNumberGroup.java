package FNA.Groups;

import FNA.Repositories.HashHugeNumberRepository;
import FNA.Repositories.HashLongNumberRepository;

public class HugeNumberGroup<E> extends Group<E, HashHugeNumberRepository<E>>
{
   public HugeNumberGroup()
   {
      super(new HashHugeNumberRepository<E>());
   }
   
   public boolean containsAll(Group<E, HashHugeNumberRepository<E>> c)
   {
      return this.repository.hasAll(c.repository.getRepo());
   }
   
   public boolean retainAll(Group<E, HashHugeNumberRepository<E>> c)
   {
      this.repository.retailTheRepositories(c.repository.getRepo());
      return true;
   }
}
