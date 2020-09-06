package FNA.ArithmeticsTypes;

/**
 * @author  Omer Kaya github.com/OmerKayaa
 * @version 1.0
 * @since   2020
 */

public interface ArithmeticsOperations<N>
{
   ArithmeticsOperations<N> division(N number);
   ArithmeticsOperations<N> multiplication(N number);
   
   ArithmeticsOperations<N> newInstance(N number);
   
   N getValue();
   ArithmeticsOperations<N> setValue(int value);
   ArithmeticsOperations<N> setValue(N number);
   ArithmeticsOperations<N> remainder(N number);
   
   ArithmeticsOperations<N> GCD(ArithmeticsOperations<N> number);
   
   boolean noRemainder(N number);
   boolean isZero();
   boolean isOne();
}
