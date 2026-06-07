import edu.princeton.cs.algs4.*;
import searching.*;
import java.util.Arrays;

public class ThreeSumFastBT
{
    public static int count(int[] a)
    {
        // Count triples that sum to 0. Demonstrate a quadratic algorithm
        int n = a.length;
        int count = 0;
        Arrays.sort(a);
        
        for (int i = 0; i < n; i++)
        {
            for (int j = i+1; j < n; j++)
            {
                if (BinarySearchBT.indexOf(a, -a[i]-a[j]) > j)
                    count++;
            }
        }
        
        return count;
        
    }
    
    public static void main(String []args)
    {
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        StdOut.println(count(a));
    }
    
}