package FNA.Interfaces;

public interface ArithmeticRepository<E,N extends Arithmetics<N>> extends Iterable<E>
{
   boolean addNumber(E element);
   boolean subNumber(E element);
   
   int countNumbers();
   
   boolean isExist(E number);
   
   E findElement(E element);
   
   N convert(E element);
}
