package sorting;

public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;

    MaxPQ()
    {

    }

    MaxPQ(int max)
    {

    }

    MaxPQ(Key[] a)
    {

    }

    void insert(Key v)
    {

    }

    Key max()
    {
        return null;
    }

    Key delMax()
    {
        return null;
    }

    boolean isEmpty()
    {
        return false;
    }

    int size()
    {
        return -1;
    }

    private boolean less (int i, int j)
    {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j)
    {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    // Swim out of place larger children values up the heap until the heap is in proper heap order
    private void swim(int k)
    {
        while(k > 1 && less(k/2,k))
        {
            exch(k/2,k);
            k = k/2;
        }
    }

    // Sink out of place smaller parent values down the heap until the heap is in proper heap order
    private void sink(int k)
    {
        while(2*k <= N)
        {
            int j = 2*k;
            if (j < N && less(j,j+1)) j++;
            if (!less(k,j)) break;
            exch(k,j);
            k=j;
        }
    }
}
