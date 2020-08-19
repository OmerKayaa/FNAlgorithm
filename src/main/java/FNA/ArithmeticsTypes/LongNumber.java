package FNA.ArithmeticsTypes;

public class LongNumber extends ArithmeticTypes<Long>
{
   public LongNumber(){}
   
   public LongNumber(int i)
   {
      setValue(i);
   }
   
   public LongNumber(long l)
   {
      this.value = l;
   }
   
   @Override public ArithmeticsOperations<Long> division(Long number)
   {
      return new LongNumber(this.value/number);
   }
   
   @Override public ArithmeticsOperations<Long> multiplication(Long number)
   {
      return new LongNumber(this.value*number);
   }
   
   @Override public ArithmeticsOperations<Long> setValue(int value)
   {
      this.value = (long) value;
      return this;
   }
   
   @Override public ArithmeticsOperations<Long> remainder(Long number)
   {
      return new LongNumber(this.value % number);
   }
   
   @Override public boolean noRemainder(Long number)
   {
      return false;
   }
   
   @Override public boolean isZero()
   {
      return this.value == 0;
   }
   
   @Override public boolean isOne()
   {
      return this.value == 1;
   }
}