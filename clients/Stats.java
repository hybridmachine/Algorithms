// Example Bag client
import edu.princeton.cs.algs4.*;
import bags_queues_stacks.*;

public class Stats
{
    public static void main(String[] args)
    {
        BagBT<Double> numbers = new BagBT<Double>();
        
        while (!StdIn.isEmpty())
            numbers.add(StdIn.readDouble());
            
        int n = numbers.size();
        
        double sum = 0.0;
        for (double x : numbers)
        {
            sum += x;
        }
        
        double mean = sum/n;
        
        sum = 0.0;
        for (double x : numbers)
            sum += (x-mean)*(x-mean);
            
        double stddev = Math.sqrt(sum/(n-1));
        
        StdOut.printf("Mean: %.2f\n", mean);
        StdOut.printf("Stddev: %.2f\n", stddev);
    }
}
