package searching;

import edu.princeton.cs.algs4.*;

public class UnionFindQuickUnionBT 
{
    private int[] id;
    private int count;
    
    public UnionFindQuickUnionBT(int N)
    {
            count = N;
            id = new int[N];
            for (int i = 0; i < N; i++)
                id[i] = i;
    }
    
    public void union(int p, int q)
    {
        int i = find(p);
        int j = find(q);
       
        if (i == j) return;
        
        id[i] = j;
        
        count--; // Initially connected components = N, reduce as we make more groups
    }
    
    // Find the root of the forrest of nodes for p
    public int find(int p)
    {
        while(p != id[p]) p = id[p];
        return p;
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
        UnionFindQuickUnionBT uf = new UnionFindQuickUnionBT(N);
        
        while (!StdIn.isEmpty())
        {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p,q)) continue;
            
            uf.union(p,q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count + " components");
    }
}