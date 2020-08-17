package FNA.ArithmeticsTypes;

import java.math.BigInteger;

public class HugeNumber extends ArithmeticTypes<BigInteger>
{
   public HugeNumber() {}
   
   public HugeNumber(int value)
   {
      this.setValue(value);
   }
   
   @Override public boolean isZero()
   {
      return value.equals(BigInteger.ZERO);
   }
   
   @Override public boolean isOne()
   {
      return value.equals(BigInteger.ONE);
   }
   
   @Override public void division(BigInteger number)
   {
      setValue(value.divide(number));
   }
   
   @Override public void multiplication(BigInteger number)
   {
      setValue(value.multiply(number));
   }
   
   @Override public BigInteger remainder(BigInteger number)
   {
      return value.remainder(number);
   }
   
   @Override public ArithmeticsOperations<BigInteger> setValue(int value)
   {
      setValue(BigInteger.valueOf(value));
      return this;
   }
   
   @Override public boolean noRemainder(BigInteger number)
   {
      return value.remainder(number).equals(BigInteger.ZERO);
   }
}
