package FNA.ArithmeticsTypes;

public abstract class ArithmeticTypes<N> implements ArithmeticsOperations<N>
{
   protected N value;
   
   public String getValue()
   {
      return value.toString();
   }
   
   public ArithmeticsOperations<N> setValue(N value)
   {
      this.value = value;
      return this;
   }
}
