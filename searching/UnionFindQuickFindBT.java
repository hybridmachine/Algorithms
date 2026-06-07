package searching;

import edu.princeton.cs.algs4.*;

public class UnionFindQuickFindBT 
{
    private int[] id;
    private int count;
    
    public UnionFindQuickFindBT(int N)
    {
            count = N;
            id = new int[N];
            for (int i = 0; i < N; i++)
                id[i] = i;
    }
    
    public void union(int p, int q)
    {
        int pID = find(p);
        int qID = find(q);
        
        if (pID == qID) return;
        
        for (int i = 0; i < id.length; i++)
        {
            if (id[i] == pID) id[i] = qID;
        }
        
        count--; // Initially connected components = N, reduce as we make more groups
    }
    
    public int find(int p)
    {
        return id[p];
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
        UnionFindQuickFindBT uf = new UnionFindQuickFindBT(N);
        
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