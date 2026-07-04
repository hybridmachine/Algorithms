package sorting;

import edu.princeton.cs.algs4.StdIn;

public class SelectionSort extends SortBase {
    public void sort(Comparable [] a)
    {
        int n = a.length;
        for (int i = 0; i< n; i++)
        {
            int min = i;
            for (int j = i+1; j < n; j++)
            {
                if (less(a[j], a[min])) min = j;
            }
            exchange(a, i, min);
            show(a);
        }
    }

    public static void main(String [] args)
    {
        SelectionSort sorter = new SelectionSort();
        String[] a = StdIn.readAllStrings();
        sorter.sort(a);
        assert isSorted(a);
        show(a);
    }
}
