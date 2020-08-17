package FNA.ArithmeticsTypes;

public class LongNumber extends ArithmeticTypes<Long>
{
   public LongNumber() {};
   
   public LongNumber(int value)
   {
      this.setValue(value);
   }
   
   @Override public void division(Long number)
   {
      setValue(value / number);
   }
   
   @Override public void multiplication(Long number)
   {
      setValue(value * number);
   }
   
   @Override public Long remainder(Long number)
   {
      return value % number;
   }
   
   @Override public boolean noRemainder(Long number)
   {
      return value % number == 0;
   }
   
   @Override public ArithmeticsOperations<Long> setValue(int value)
   {
      this.value = (long)value;
      return this;
   }
   
   @Override public boolean isZero()
   {
      return value == 0;
   }
   
   @Override public boolean isOne()
   {
      return value == 1;
   }
}
