// Page 47
import java.util.Arrays;

public class BinarySearch
{
    public static int indexOf(int[] a, int key)
    {
        // Array must already be sorted
        int lo = 0;
        int hi = a.length - 1;
        
        while (lo <= hi)
        {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else                    return mid;
        }
    
        return -1; // Not found
    }   

    public static void main (String [] args)
    {
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();
        Arrays.sort(whitelist);
        
        while (!StdIn.isEmpty())
        {
            // Read key, print if not in whitelist.
            int key = StdIn.readInt();
            if (indexOf(whitelist, key) == -1)
                StdOut.println(key);
        }
    }
}