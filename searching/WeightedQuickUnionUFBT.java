package searching;

import edu.princeton.cs.algs4.*;
// Page 228
public class WeightedQuickUnionUFBT 
{
    private int[] id;   // parent link
    private int[] sz;   // Size of component for roots (site indexed)
    private int count;  // Number of components
    
    public WeightedQuickUnionUFBT(int N)
    {
            count = N;
            id = new int[N];
            sz = new int[N];
            for (int i = 0; i < N; i++)
            {
                id[i] = i;
                sz[i] = 1;
            }      
    }
    
    public void union(int p, int q)
    {
        int i = find(p);
        int j = find(q);
       
        if (i == j) return;
        
        // Here's the key, tracking size, join smaller as child of larger
        if (sz[i] < sz[j])  { id[i] = j; sz[j]+=sz[i]; }
        else                { id[j] = i; sz[i]+=sz[j]; }
        
        count--; // Initially connected components = N, reduce as we make more groups
    }
    
    // Find the root of the forrest of nodes for p
    public int find(int p)
    {
        while(p != id[p]) p = id[p];
        return p;
    }
    
    public int parent(int p)
    {
        return id[p];
    }
    
    public int forrestSize(int p)
    {
        return sz[p];
    }
    
    public boolean connected(int p, int q)
    {
        return find(p) == find(q);
    }
    
    public int count()
    {
        return count;
    }
    
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        WeightedQuickUnionUFBT uf = new WeightedQuickUnionUFBT(N);
        
        while (!StdIn.isEmpty())
        {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p,q)) continue;
            
            uf.union(p,q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count + " components");
        
        StdOut.println("node\troot\tforrest size");
        for (int idx = 0; idx < N; idx++)
        {
            StdOut.printf("%7d\t%7d\t%7d\n", idx, uf.find(idx), uf.forrestSize(uf.find(idx)));    
        }
        
    }
}