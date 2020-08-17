package FNA.ArithmeticsTypes;

public interface ArithmeticsOperations<N>
{
   void division(N number);
   void multiplication(N number);
   
   String getValue();
   ArithmeticsOperations<N> setValue(N value);
   ArithmeticsOperations<N> setValue(int value);
   
   N remainder(N number);
   
   boolean noRemainder(N number);
   boolean isZero();
   boolean isOne();
}
