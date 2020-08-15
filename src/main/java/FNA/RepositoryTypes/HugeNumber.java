package FNA.RepositoryTypes;

import FNA.Interfaces.Arithmetics;

import java.math.BigInteger;

public class HugeNumber implements Arithmetics<BigInteger>
{
   @Override public BigInteger addition(BigInteger number1, BigInteger number2)
   {
      return new BigInteger(number1.add(number2).toByteArray());
   }
   
   @Override public BigInteger division(BigInteger number1, BigInteger number2)
   {
      return new BigInteger(number1.divide(number2).toByteArray());
   }
   
   @Override public BigInteger subtraction(BigInteger number1, BigInteger number2)
   {
      return new BigInteger(number1.subtract(number2).toByteArray());
   }
   
   @Override public BigInteger multiplication(BigInteger number1, BigInteger number2)
   {
      return new BigInteger(number1.multiply(number2).toByteArray());
   }
   
   @Override public BigInteger remainder(BigInteger number1, BigInteger number2)
   {
      return new BigInteger(number1.remainder(number2).toByteArray());
   }
   
   @Override public boolean noRemainder(BigInteger number1, BigInteger number2)
   {
      return number1.remainder(number2).equals(BigInteger.ZERO);
   }
}
