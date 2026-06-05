import bags_queues_stacks.*;
import edu.princeton.cs.algs4.*;

public static void main(String []args)
{
    StackBT<String> s = new StackBT<String>();
    
    while (!StdIn.isEmpty())
    {
        String item = StdIn.readString();
        if (!item.equals("-"))
        {
            s.push(item);
        }
        else if (!s.isEmpty()) 
        {
            StdOut.print(s.pop() + " ");
        }
    }
    
    StdOut.println("(" + s.size() + " left on stack)");
}