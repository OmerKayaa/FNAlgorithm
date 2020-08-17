package FNA;

import FNA.Repositories.HashHugeNumberRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HashHugeNumberRepositoryTest
{
   public HashHugeNumberRepository<String> repo = new HashHugeNumberRepository<>();
   
   @Before
   public void setUp()
   {
   
   }
   
   @Test
   public void testAddingAndGettingElement()
   {
      repo.addElementValue("Test");
      Assert.assertNotNull(repo.getKeyByValue("Test"));
   }
   
}
