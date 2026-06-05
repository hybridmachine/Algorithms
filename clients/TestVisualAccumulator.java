import edu.princeton.cs.algs4.*;
import data_abstraction.*;

public class TestVisualAccumulator
{
    public static void main(String []args)
    {
        int trials = Integer.parseInt(args[0]);
        VisualAccumulator a = new VisualAccumulator(trials, 1.0);
        for (int t = 0; t < trials; t++)
        {
            a.addDataValue(StdRandom.uniformDouble(0.0, 1.0));
        }
        StdOut.println(a);
    }
}