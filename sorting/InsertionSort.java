package sorting;

import edu.princeton.cs.algs4.StdIn;

public class InsertionSort extends SortBase {
    public void sort(Comparable [] a)
    {
        int n = a.length;
        Comparable []before = new Comparable[n];
        for (int i = 1; i< n; i++)
        {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--)
            {
                for (int idx = 0; idx < n; idx++)
                    before[idx] = a[idx];

                exchange(a, j, j-1);
                show(before,a); // Display the sort in progress
            }
        }
    }

    public static void main(String [] args)
    {
        InsertionSort sorter = new InsertionSort();
        String[] a = StdIn.readAllStrings();
        sorter.sort(a);
        assert isSorted(a);
        show(a);
    }
}
