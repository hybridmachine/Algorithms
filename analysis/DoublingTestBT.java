import edu.princeton.cs.algs4.*;

public class DoublingTestBT 
{
    public static double timeTrial(int n)
    {
        int MAX = 1000000;
        int []a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = StdRandom.uniformInt(-MAX, MAX);
            
        StopwatchBT timer = new StopwatchBT();
        int count = ThreeSum.count(a);
        return timer.elapsedTime();
    }
    
    public static void main(String[] args)
    {
        for (int n = 250; true; n *= 2)
        {
            double time = timeTrial(n);
            StdOut.printf("%7d %7.1f\n", n, time);
        }
    }
}