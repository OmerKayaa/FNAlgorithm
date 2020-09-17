package FNA.ArithmeticsTypes;

/**
 * @author  Omer Kaya github.com/OmerKayaa
 * @version 1.0
 * @since   2020
 */

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

   /**
    * Euclidean greatest common divisor algorithm(GCD)
    * Time complexity is log(N)
    *
    * -WARNING-
    * Do not use reference of your object. Create a
    * new instance. This method changes value of your
    * parameter
    *
    * @param number other number that will be used
    *               for finding GCD
    * @return ArithmeticsOperations value of result
    */
   @Override public ArithmeticsOperations<T> GCD(ArithmeticsOperations<T> number)
   {
      if(number.isZero())
         return this;
      else return number.GCD(this.remainder(number.getValue()));
   }
}
