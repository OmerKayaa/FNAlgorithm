package FNA.Repositories;

import FNA.ArithmeticsTypes.ArithmeticsOperations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

public abstract class  Repository<R,T extends ArithmeticsOperations<R>,E>
      extends BidiDictionary<R,E> implements ArithmeticRepository<R,T,E>
{
   T arithmeticRepo;
   
   public Repository(T arithmeticRepo)
   {
      this.arithmeticRepo = arithmeticRepo;
   }
   
   public T getRepo()
   {
      return arithmeticRepo;
   }
   
   @Override public void add(E element)
   {
      arithmeticRepo.setValue(arithmeticRepo.multiplication(findKeyOrCreate(element)).getValue());
   }
   
   @Override public Collection<E> getAll()
   {
      List<E> All = new ArrayList<>();
      elementSet().forEach(e -> IntStream.range(0,howManyExits(e)).forEach(value -> All.add(e)));
      return All;
   }
   
   @Override public void remove(E element)
   {
      findKey(element).ifPresent(r -> arithmeticRepo.division(arithmeticRepo.GCD(arithmeticRepo.newInstance(r)).getValue()));
   }
   
   @Override public void combineTheRepositories(T repository)
   {
      arithmeticRepo.setValue(arithmeticRepo.multiplication(repository.getValue()).getValue());
   }
   
   @Override public void retailTheRepositories(T repository)
   {
      repository.setValue(arithmeticRepo.GCD(repository).getValue());
   }
   
   @Override public boolean hasElement(E element)
   {
      return findKey(element).isPresent();
   }
   
   @Override public boolean hasAll(T repository)
   {
      return repository.noRemainder(repository.getValue());
   }
   
   @Override public int howManyExits(E element)
   {
      if(findKey(element).isPresent())
      {
         R key = findKey(element).get();
         ArithmeticsOperations<R> counter = arithmeticRepo.newInstance(arithmeticRepo.getValue());
         int i;
         for(i=0;counter.noRemainder(key);i++)
         {
            counter = counter.division(key);
         }
         return i;
      }
      else return 0;
   }
   
   @Override public void addElement(E element, int count)
   {
      for (int i = 0; i < count; i++)
      {
         add(element);
      }
   }
   
   @Override public void disjunctTheRepositories(T repository)
   {
      repository.setValue(arithmeticRepo.division(arithmeticRepo.GCD(repository).getValue()).getValue());
   }
   
   public void resetDictionary()
   {
      super.reset();
   }
}
