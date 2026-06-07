import edu.princeton.cs.algs4.*;

public class StopwatchBT
{
    private final long start;
    
    public StopwatchBT()
    {
        start = System.currentTimeMillis();
    }
    
    public double elapsedTime()
    {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
}