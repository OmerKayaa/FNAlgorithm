package FNA.ArithmeticsTypes;

/**
 * This is the interface for the integer
 * that will use to store data.
 *
 * @author  Omer Kaya github.com/OmerKayaa
 * @version 1.0
 * @since   2020
 */

public interface ArithmeticsOperations<N>
{
   /**
    * Division operation for integer of choice.
    *
    * @param number takes the number of same type
    * @return new object of result
    */
   ArithmeticsOperations<N> division(N number);

   /**
    * Multiplication operation for integer of choice.
    *
    * @param number takes the number of same type
    * @return new object of result
    */
   ArithmeticsOperations<N> multiplication(N number);

   /**
    * Modulus operation for integer of choice
    *
    * @param number divisor
    * @return remainder of dividend (value of the object)
    *         and divisor the number.
    */
   ArithmeticsOperations<N> remainder(N number);

   /**
    * Greatest Common Divisor for the number and value of the object
    *
    * @param number
    * @return Greatest Common Divisor
    */
   ArithmeticsOperations<N> GCD(ArithmeticsOperations<N> number);

   /**
    * Constructor reference for creating new object
    *
    * @param number number to be set on new instance
    * @return new object
    */
   ArithmeticsOperations<N> newInstance(N number);

   /**
    * @return Value of the object
    */
   N getValue();

   /**
    * Set operation in integer form
    *
    * @param value to be set on the object
    * @return new object
    */
   ArithmeticsOperations<N> setValue(int value);

   /**
    * Set operation in N form
    *
    * @param number to be set on the object
    * @return new object
    */
   ArithmeticsOperations<N> setValue(N number);

   /**
    * Whether value and number can be divided without
    * remainder or not.
    *
    * @param number Divisor
    * @return true if number can divide value of the object
    *         without remainder.
    */
   boolean noRemainder(N number);

   /**
    * Value is zero or not
    *
    * @return true if value is zero
    */
   boolean isZero();

   /**
    * Value is one or not
    *
    * @return true if value is one
    */
   boolean isOne();
}
