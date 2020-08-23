package FNA.Repositories;

import FNA.ArithmeticsTypes.ArithmeticsOperations;

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
   
   @Override public void remove(E element)
   {
      arithmeticRepo.division(arithmeticRepo.GCD(arithmeticRepo.newInstance(findKeyOrCreate(element))).getValue());
   }
   
   @Override public void combineTheRepositories(T repository)
   {
      arithmeticRepo.setValue(arithmeticRepo.multiplication(repository.getValue()).getValue());
   }
   
   @Override public void retailTheRepositories(T repository)
   {
      repository.setValue(arithmeticRepo.division(arithmeticRepo.GCD(repository).getValue()).getValue());
   }
   
   @Override public boolean hasElement(E element)
   {
      return findKey(element).isPresent();
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
   
   public void resetDictionary()
   {
      super.reset();
   }
}
