package FNA.ArithmeticsTypes;

public abstract class ArithmeticTypes<T> implements ArithmeticsOperations<T>
{
   protected T value;
   
   @Override
   public ArithmeticsOperations<T> setValue(T value)
   {
      this.value = value;
      return this;
   }
   
   @Override public T getValue()
   {
      return value;
   }
   
   @Override public ArithmeticsOperations<T> GCD(ArithmeticsOperations<T> number)
   {
      if(number.isZero())
         return this;
      else return number.GCD(this.remainder(number.getValue()));
   }
}
