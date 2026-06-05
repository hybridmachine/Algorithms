import bags_queues_stacks.*;
import edu.princeton.cs.algs4.*;

public static void main(String []args)
{
    QueueBT<String> q = new QueueBT<String>();
    
    while (!StdIn.isEmpty())
    {
        String item = StdIn.readString();
        if (!item.equals("-"))
        {
            q.enqueue(item);
        }
        else if (!q.isEmpty()) 
        {
            StdOut.print(q.dequeue() + " ");
        }
    }
    
    StdOut.println("(" + q.size() + " left on queue)");
}