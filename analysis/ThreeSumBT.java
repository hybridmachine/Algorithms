import edu.princeton.cs.algs4.*;

public class ThreeSumBT
{
    public static int count(int[] a)
    {
        // Count triples that sum to 0. Demonstrate a quadratic algorithm
        int n = a.length;
        int count = 0;
        
        for (int i = 0; i < n; i++)
        {
            for (int j = i+1; j < n; j++)
            {
                for (int k = j+1; k < n; k++)
                {
                    if (a[i] + a[j] + a[k] == 0)
                        count++;
                }
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