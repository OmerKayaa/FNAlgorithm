package FNA.Repositories;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers
{
   /**
    * Finds next prime number and adds it to static prime number list
    * {@code primes}
    */
   private static void addNextPrimeNumberToList()
   {
      int prime = primes.get(primes.size()-1);
      
      do { prime +=2; }
      while(!isPrime(prime));
      
      primes.add(prime);
   }
   
   /**
    * Gives Nth prime number is if exists
    * if not creates
    * {@code primes}
    */
   public static int getPrime(int number)
   {
      while (number >= primes.size())
         addNextPrimeNumberToList();
      return primes.get(number);
   }
   
   /**
    * Static prime number verification
    * {@code primes}
    */
   private static boolean isPrime(int i)
   {
      for (int j: primes)
      {
         if (i % j == 0)
            return false;
      }
      return true;
   }
   
   /**
    * Static prime number list
    * {@code primes}
    */
   private final static List<Integer> primes = new ArrayList<>(List.of(
        2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103,
        107,109,113,127,131,137,139,149,151,157,163,167,173,179,181,191,193,197,199,211,
        223,227,229,233,239,241,251,257,263,269,271,277,281,283,293,307,311,313,317,331,
        337,347,349,353,359,367,373,379,383,389,397,401,409,419,421,431,433,439,443,449,
        457,461,463,467,479,487,491,499,503,509,521,523,541));
}
