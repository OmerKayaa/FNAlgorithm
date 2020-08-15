package FNA.RepositoryTypes;

import FNA.Interfaces.Arithmetics;

public class LongNumber implements Arithmetics<Long>
{
   @Override public Long addition(Long number1, Long number2)
   {
      return number1 + number2;
   }
   
   @Override public Long division(Long number1, Long number2)
   {
      return number1 / number2;
   }
   
   @Override public Long subtraction(Long number1, Long number2)
   {
      return number1 - number2;
   }
   
   @Override public Long multiplication(Long number1, Long number2)
   {
      return number1 * number2;
   }
   
   @Override public Long remainder(Long number1, Long number2)
   {
      return number1 % number2;
   }
   
   @Override public boolean noRemainder(Long number1, Long number2)
   {
      return number1 % number2 == 0;
   }
}
