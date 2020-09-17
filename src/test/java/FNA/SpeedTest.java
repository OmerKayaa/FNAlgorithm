package FNA;

import FNA.Collections.HugeNumberGroup;
import FNA.Collections.LongNumberGroup;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class SpeedTest
{
    LongNumberGroup<String> LG = new LongNumberGroup<>();
    HugeNumberGroup<String> HG= new HugeNumberGroup<>();
    List<String> AL = new ArrayList<>();
    List<String> LL = new LinkedList<>();

    LongNumberGroup<String> lg = new LongNumberGroup<>();
    HugeNumberGroup<String> hg= new HugeNumberGroup<>();
    List<String> al = new ArrayList<>();
    List<String> ll = new LinkedList<>();

    List<Collection<String>> testList1 = List.of(LG,HG,AL,LL);
    List<Collection<String>> testList2 = List.of(lg,hg,al,ll);

    static private final int testSize = 100000,testVariety = 500;

    @Before
    public void reset()
    {
        LG = new LongNumberGroup<>();
        HG= new HugeNumberGroup<>();
        AL = new ArrayList<>();
        LL = new LinkedList<>();

        lg = new LongNumberGroup<>();
        hg= new HugeNumberGroup<>();
        al = new ArrayList<>();
        ll = new LinkedList<>();
    }

    @Test
    public void addAll() throws InterruptedException
    {
        AL.addAll(al); HG.addAll(hg);
        // AL, al, HG, hg, is empty. This command doesnt add anything but syncs their element dictionaries

        testList1.forEach(strings -> setUp(strings,"test",testSize,testVariety));
        testList2.forEach(strings -> setUp(strings,"TEST",testSize,testVariety));

        {
            Thread thread = new Thread(() -> LG.addAll(lg));
            thread.setPriority(1);
            long start = System.nanoTime();
            thread.start();
            thread.join();
            long end = System.nanoTime();

            System.out.println("Long Number \n add all time - " + (end-start) + " nano second");
        }

        {
            Thread thread = new Thread(() -> HG.addAll(hg));
            thread.setPriority(1);
            long start = System.nanoTime();
            thread.start();
            thread.join();
            long end = System.nanoTime();

            System.out.println("Huge Number \n add all time - " + (end-start) + " nano second");
        }

        {
            Thread thread = new Thread(() -> AL.addAll(al));
            thread.setPriority(1);
            long start = System.nanoTime();
            thread.start();
            thread.join();
            long end = System.nanoTime();

            System.out.println("Array List \n add all time - " + (end-start) + " nano second");
        }

        {
            Thread thread = new Thread(() -> LL.addAll(ll));
            thread.setPriority(1);
            long start = System.nanoTime();
            thread.start();
            thread.join();
            long end = System.nanoTime();

            System.out.println("Linked List \n add all time - " + (end-start) + " nano second");
        }

        System.out.println("-------------------------------------------------");
    }

    @Test
    public void retailAll() throws InterruptedException
    {
        AL.addAll(al); HG.addAll(hg);
        // AL, al, HG, hg, is empty. This command doesnt add anything but syncs their element dictionaries

        testList1.forEach(strings -> setUp(strings,"test",testSize,testVariety));
        testList2.forEach(strings -> setUp(strings,"TEST",testSize,testVariety));

        {
            Thread thread = new Thread(() -> LG.retainAll(lg));
            thread.setPriority(1);
            long start = System.nanoTime();
            thread.start();
            thread.join();
            long end = System.nanoTime();

            System.out.println("Long Number \n retail all time - " + (end-start) + " nano second");
        }

        {
            Thread thread = new Thread(() -> HG.retainAll(hg));
            thread.setPriority(1);
            long start = System.nanoTime();
            thread.start();
            thread.join();
            long end = System.nanoTime();

            System.out.println("Huge Number \n retail all time - " + (end-start) + " nano second");
        }

        {
            Thread thread = new Thread(() -> AL.retainAll(al));
            thread.setPriority(1);
            long start = System.nanoTime();
            thread.start();
            thread.join();
            long end = System.nanoTime();

            System.out.println("Array List \n retail all time - " + (end-start) + " nano second");
        }

        {
            Thread thread = new Thread(() -> LL.retainAll(ll));
            thread.setPriority(1);
            long start = System.nanoTime();
            thread.start();
            thread.join();
            long end = System.nanoTime();

            System.out.println("Linked List \n retail all time - " + (end-start) + " nano second");
        }

        System.out.println("-------------------------------------------------");
    }

    @Test
    public void removeAll() throws InterruptedException
    {
        AL.addAll(al); HG.addAll(hg);
        // AL, al, HG, hg, is empty. This command doesnt add anything but syncs their element dictionaries

        testList1.forEach(strings -> setUp(strings,"test",testSize,testVariety));
        testList2.forEach(strings -> setUp(strings,"TEST",testSize,testVariety));

        {
            Thread thread = new Thread(() -> LG.removeAll(lg));
            thread.setPriority(1);
            long start = System.nanoTime();
            thread.start();
            thread.join();
            long end = System.nanoTime();

            System.out.println("Long Number \n remove all time - " + (end-start) + " nano second");
        }

        {
            Thread thread = new Thread(() -> HG.removeAll(hg));
            thread.setPriority(1);
            long start = System.nanoTime();
            thread.start();
            thread.join();
            long end = System.nanoTime();

            System.out.println("Huge Number \n remove all time - " + (end-start) + " nano second");
        }

        {
            Thread thread = new Thread(() -> AL.removeAll(al));
            thread.setPriority(1);
            long start = System.nanoTime();
            thread.start();
            thread.join();
            long end = System.nanoTime();

            System.out.println("Array List \n remove all time - " + (end-start) + " nano second");
        }

        {
            Thread thread = new Thread(() -> LL.removeAll(ll));
            thread.setPriority(1);
            long start = System.nanoTime();
            thread.start();
            thread.join();
            long end = System.nanoTime();

            System.out.println("Linked List \n remove all time - " + (end-start) + " nano second");
        }

        System.out.println("-------------------------------------------------");
    }

    public void setUp(Collection<String> collection,String prefix, int size, int variety)
    {
        IntStream.range(1,size).forEach(i -> collection.add(prefix + i % variety));
    }
}
