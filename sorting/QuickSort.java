package sorting;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSort extends SortBase {
    
    public QuickSort(Comparable [] sortme)
    {
        a = sortme;
    }

    public void sort()
    {
        sort(a);
    }

    public boolean isSorted()
    {
        return isSorted(a);
    }

    public void show()
    {
        show(a);
    }
    
    public void sort(Comparable a[])
    {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable a[], int lo, int hi)
    {
        if (hi <= lo) return;
        if (sortDisplayer != null)
        {
            sortDisplayer.showStep(a, a, lo, hi);
        }
        int j = partition(a, lo, hi);
        if (sortDisplayer != null)
        {
            sortDisplayer.showStep(a, a, lo, hi);
        }
        sort (a, lo, j - 1);
        sort (a , j+1, hi);
    }

    private int partition(Comparable a[], int lo, int hi)
    {
        int i = lo, j = hi + 1;

        Comparable v = a[lo];
        while(true)
        {
            while(less(a[++i], v)) if (i == hi) break;
            while(less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exchange(a, i, j);    
        }    
        exchange(a, lo, j);
        return j;
    }
    
}
