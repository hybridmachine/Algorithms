package sorting;

import edu.princeton.cs.algs4.StdIn;
import java.util.Arrays;

import javax.print.attribute.standard.MediaSize.ISO;

public class SelectionSort extends SortBase {
    private Comparable[] a;      

    public SelectionSort(Comparable [] sortme)
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

    public void sort(Comparable [] a)
    {
        int n = a.length;
        Comparable []before = new Comparable[n];

        if (sortDisplayer != null)
        {
            sortDisplayer.showStep(a);
        }

        for (int i = 0; i< n; i++)
        {
            int min = i;
            for (int j = i+1; j < n; j++)
            {
                if (less(a[j], a[min])) min = j;
            }

            for (int idx = 0; idx < n; idx++)
                before[idx] = a[idx];
            
            exchange(a, i, min);
            if (sortDisplayer != null)
            {
                sortDisplayer.showStep(a);
            }
            show(before, a);
        }
    }

    public static void main(String [] args)
    {
        SelectionSort sorter = new SelectionSort(StdIn.readAllStrings());
        sorter.sort();
        assert sorter.isSorted();
        sorter.show();
    }
}
