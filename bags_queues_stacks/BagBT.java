package bags_queues_stacks; 

import java.util.Iterator;

// Bag collection
public class BagBT<Item> implements Iterable<Item>
{
    private Node first; // First node in the list
    private int size; 
    
    private class Node
    {
            Item item;
            Node next;
    }
    
    // Use implied constructor
        
    public void add(Item item)
    {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        size++;
    }
    
    public boolean isEmpty()
    {
        return first == null;
    }
    
    public int size()
    {
        return size;
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
