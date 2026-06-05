// Page 37 example StdOut client
import edu.princeton.cs.algs4.*;
import data_abstraction.*;

public class RandomSeq
{
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        double lo = Double.parseDouble(args[1]);
        double hi = Double.parseDouble(args[2]);
        for (int i = 0; i < n; i++)
        {
            double x = StdRandom.uniformDouble(lo, hi);
            StdOut.printf("%.2f\n", x);
        }
    }
}
