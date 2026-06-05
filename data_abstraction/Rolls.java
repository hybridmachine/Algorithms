package data_abstraction;

import edu.princeton.cs.algs4.*;

public class Rolls
{
    public static void main(String[] args)
    {
        int trials = Integer.parseInt(args[0]);
        final int SIDES = 6;
        Counter[] rolls = new Counter[SIDES+1];
        
        for (int i = 1; i <= SIDES; i++)
        {
            rolls[i] = new Counter(i+"s");
        }
        
        for (int t = 0; t < trials; t++)
        {
            int result = StdRandom.uniformInt(1,SIDES+1);
            rolls[result].increment();
        }
        
        for (int i = 1; i <= SIDES; i++)
        {
            StdOut.println(rolls[i]);
        }    
    }
}