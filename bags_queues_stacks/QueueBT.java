StdDrawpackage bags_queues_stacks; 

import java.util.Iterator;

public class QueueBT<Item>
{
    private Node first;     // least recently added node
    private Node last;      // most recently added node
    private int size;       // Num items
    
    private class Node
    {
            Item item;
            Node next;
    }
    
    public boolean isEmpty()
    {
        return first == null;
    }
    
    public int size()
    {
        return size;
    }
    
    public void enqueue(Item item)
    {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else            oldlast.next = last;
        size++;
    }
    
    public Item dequeue()
    {
        Item item = first.item;
        first = first.next;
        size--;
        if (isEmpty()) last = null;
        return item;
    }
    
    public Iterator<Item> iterator()
    {
        return new ListTerator();
    }
    
    private class ListTerator implements Iterator<Item>
    {
        private Node current = first;
        
        public boolean hasNext()
        {
            return current != null;
        }
        
        public void remove() 
        { 
            // Noop
        }
        
        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}