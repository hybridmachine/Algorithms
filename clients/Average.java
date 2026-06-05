import data_abstraction.*;
import edu.princeton.cs.algs4.*;

// Example StdIn client from Page 39
public class Average
{
    public static void main(String []args)
    {
        // Average the numbers on stdin
        double sum = 0.0;
        int count = 0;
        
        while (!StdIn.isEmpty())
        {
            // Read a number and cumulate the sum
            sum += StdIn.readDouble();
            count++;
        }
        double avg = sum / count;
        StdOut.printf("Average is %.5f\n", avg);
    }
}