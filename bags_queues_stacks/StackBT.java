package bags_queues_stacks;

import java.util.Iterator;

public class StackBT<Item> implements Iterable<Item>
{
    private Node first;     // Top of stack
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
    
    public void push(Item item)
    {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        size++;
    }
    
    public Item pop()
    {
        Item item = first.item;
        first = first.next;
        size--;
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