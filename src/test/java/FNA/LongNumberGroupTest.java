package FNA;

import FNA.Collections.LongNumberGroup;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

public class LongNumberGroupTest
{
    LongNumberGroup<String> group1 = new LongNumberGroup<>();
    LongNumberGroup<String> group2 = new LongNumberGroup<>();

    @Before
    public void setUp()
    {
        group1 = new LongNumberGroup<>();
        group2 = new LongNumberGroup<>();
    }

    @Test
    public void testEmpty()
    {
        Assert.assertTrue(group1.isEmpty());

        group1.add("Test");
        Assert.assertFalse(group1.isEmpty());

        Assert.assertTrue(group2.isEmpty());
    }

    @Test
    public void testAdd()
    {
        IntStream.range(1, 100).forEach(value -> group1.add("Test" + value));
    }

    @Test
    public void testAddAndVerify()
    {
        IntStream.range(1, 100).forEach(value -> group1.add("Test" + value));
        IntStream.range(1, 100).forEach(value -> Assert.assertTrue(group1.contains("Test" + value)));
    }

    @Test
    public void testRemove()
    {
        group1.add("Test");
        group1.remove("Test");
        group1.remove("");
        group1.remove("test");
    }

    @Test
    public void testRemoveAndVerify()
    {
        group1.add("Test1");
        group1.add("Test2");

        group1.remove("Test");
        group1.remove("");
        group1.remove("test");

        Assert.assertTrue(group1.contains("Test1"));
        Assert.assertTrue(group1.contains("Test2"));

        group1.remove("Test1");
        group1.remove("Test2");

        Assert.assertTrue(group1.contains("Test1"));
        Assert.assertTrue(group1.contains("Test2"));
    }

    @Test
    public void testSize()
    {
        group1.add("Test1");

        Assert.assertEquals(1,group1.size());
    }

    @Test
    public void testCombineError()
    {
        group1.add("Test1");
        group2.add("Test1");

        group1.addAll(group2);
    }

    @Test
    public void testCombine()
    {
        group1.add("Test1");
        group1.add("Test2");
        group1.add("Test3");
        group2.add("Test1");
        group2.add("Test4");

        group1.addAll(group2);

        Assert.assertEquals(5,group1.size());
    }

    @Test
    public void testRemoveAll()
    {
        group1.add("Test1");
        group1.add("Test2");
        group1.add("Test3");
        group2.add("Test1");
        group2.add("Test4");

        group1.removeAll(group2);

        Assert.assertEquals(2,group1.size());
    }

    @Test
    public void testRetailAll()
    {
        group1.add("Test1");
        group1.add("Test2");
        group1.add("Test3");
        group2.add("Test1");
        group2.add("Test4");

        group1.retainAll(group2);

        Assert.assertEquals(1,group1.size());
    }

    @Test
    public void testHasAll()
    {
        group1.add("Test1");
        group1.add("Test2");
        group1.add("Test3");
        group2.add("Test1");
        group2.add("Test4");

        Assert.assertFalse(group1.containsAll(group2));

        group1.add("Test4");

        Assert.assertTrue(group1.containsAll(group2));
    }
}

