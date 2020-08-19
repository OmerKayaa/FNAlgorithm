package FNA.Repositories;

import FNA.ArithmeticsTypes.ArithmeticsOperations;

import java.util.Optional;

public abstract class Repository<R,T extends ArithmeticsOperations<R>,E>
      extends BidiDictionary<T,E> implements ArithmeticRepository<T,E>
{
   protected T repository;
   
   @Override public Optional<T> getKeyByValue(E element)
   {
      return this.findKey(element);
   }
   
   @Override public Optional<E> getValueByKey(T Key)
   {
      return this.findValue(Key);
   }
   
   @Override public void addNewKey(E element)
   {
      this.registerNewElement(element);
   }
   
   
   @Override public void addNewElementToRepository(T repo)
   {
      repository.multiplication(repo.getValue());
   }
   
   @Override public void removeElementFromRepository(T repo)
   {
      repository.division(repository.GCD(repo).getValue());
   }
   
   @Override public void add(E element)
   {
      repository.multiplication(findKeyOrCreate(element).getValue());
   }
   
   @Override public void remove(E element)
   {
      if(repository.noRemainder(findKeyOrCreate(element).getValue()))
         repository.division(findKeyOrCreate(element).getValue());
   }
   
   public void reset()
   {
      super.reset();
   }
   
   @Override public int size()
   {
      return 0;
   }
}
