package sorting;

import edu.princeton.cs.algs4.StdIn;

public class InsertionSort extends SortBase {
    
    public InsertionSort(Comparable [] sortme)
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
            sortDisplayer.showStep(a, a, -1, -1);
        }
        for (int i = 1; i< n; i++)
        {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--)
            {
                for (int idx = 0; idx < n; idx++)
                    before[idx] = a[idx];

                exchange(a, j, j-1);
                show(before,a); // Display the sort in progress
                if (sortDisplayer != null)
                {
                    sortDisplayer.showStep(before, a, j, j-1);
                }
            }
        }
    }

    public static void main(String [] args)
    {
        InsertionSort sorter = new InsertionSort(StdIn.readAllStrings());
        sorter.sort();
        assert sorter.isSorted();
        sorter.show();
    }
}
