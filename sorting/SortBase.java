package sorting;

import edu.princeton.cs.algs4.*;
import utils.*;

public class SortBase {
    protected ISortStepDisplayer sortDisplayer;
    protected Comparable[] a;
    
    public void sort(Comparable [] a)
    {

    }

    public void setSortStepDisplayer(ISortStepDisplayer displayer)
    {
        sortDisplayer = displayer;
    }

    protected static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w) < 0;
    }

    protected static void exchange(Comparable[] a, int i, int j)
    {
        Comparable t = a[i]; a[i] = a[j]; a[j] = t;
    }

    protected static void show(Comparable []before, Comparable []a)
    {
        for (int i = 0; i < a.length; i++)
        {
            if (a[i] != before[i])
                StdOut.print(ColoredTerminal.colorstr(ColoredTerminal.RED, ColoredTerminal.WHITE_BG, a[i].toString()) + " ");
            else
                StdOut.print(a[i] + " ");
            
        }
        StdOut.println();
    }

    protected static void show(Comparable []a)
    {
        for (int i = 0; i < a.length; i++)
        {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a)
    {
        for (int i = 1; i < a.length; i++)
        {
            if (less(a[i], a[i-1])) return false;
        }
        return true;
    }
}
