package FNA.Interfaces;

public interface Arithmetics<N>
{
   N addition(N number1,N number2);
   N division(N number1,N number2);
   N subtraction(N number1,N number2);
   N multiplication(N number1,N number2);
   
   N remainder(N number1,N number2);
   boolean noRemainder(N number1,N number2);
}
