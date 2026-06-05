package data_abstraction;

public class Counter
{
    private String _name;
    private int _count;
    
    public Counter(String name)
    {
        _name = name;
        _count = 0;
    }
    
    public void increment()
    {
        _count = _count + 1;
    }
    
    public int tally()
    {
        return _count;
    }
    
    public String toString()
    {
        return _count + " " + _name; 
    }
}
