package FNA.ArithmeticsTypes;

import java.math.BigInteger;

/**
 * @author  Omer Kaya github.com/OmerKayaa
 * @version 1.0
 * @since   2020
 */

public class HugeNumber extends ArithmeticTypes<BigInteger>
{
   public HugeNumber()
   {
      this.value = BigInteger.ONE;
   }
   
   public HugeNumber(int i)
   {
      setValue(i);
   }
   
   public HugeNumber(BigInteger integer)
   {
      this.value = integer;
   }
   
   @Override public ArithmeticsOperations<BigInteger> division(BigInteger number)
   {
      return new HugeNumber(this.value.divide(number));
   }
   
   @Override public ArithmeticsOperations<BigInteger> multiplication(BigInteger number)
   {
      return new HugeNumber(this.value.multiply(number));
   }
   
   @Override public ArithmeticsOperations<BigInteger> newInstance(BigInteger number)
   {
      return new HugeNumber(number);
   }
   
   @Override public ArithmeticsOperations<BigInteger> setValue(int value)
   {
      this.value = BigInteger.valueOf(value);
      return this;
   }
   
   @Override public ArithmeticsOperations<BigInteger> remainder(BigInteger number)
   {
      return new HugeNumber(this.value.remainder(number));
   }
   
   @Override public boolean noRemainder(BigInteger number)
   {
      var a = this.value.remainder(number);
      return a.equals(BigInteger.ZERO);
   }
   
   @Override public boolean isZero()
   {
      return this.value.equals(BigInteger.ZERO);
   }
   
   @Override public boolean isOne()
   {
      return this.value.equals(BigInteger.ONE);
   }
}
