import edu.princeton.cs.algs4.In;

public class Graph {
    // Create a V-vertex graph with no edges.
    public Graph (int V) 
	{
    
    }

    // Create a graph from intput stream in
    public Graph (In in) 
	{
        
    }
	
	// Number of vertices
	int V() 
	{
		return 0;
	}
	
	// Number of edges
	int E() 
	{
		return 0;
	}
	
	// Add edge v-w to this graph
	void addEdge(int v, int w) 
	{
		
	}
	
	Iterable<Integer> adj(int v) 
	{
		return null;
	}
	
	public String toString() 
	{ 
		String s = V() + " vertices, " + E() + " edges\n";
		
		for (int v = 0; v < V(); v++)
		{
			s += v + ": ";
			for (int w : this.adj(v))
				s += w + " ";
			s += "\n";
		}
		
		return s;
	}
	
	//---------------- Tasks ---------------
	
	public static int degree(Graph G, int v)
	{
		int degree = 0;
		for (int w : G.adj(v)) degree++;
		return degree;
	}
	
	public static int maxDegree(Graph G)
	{
		int max = 0;
		
		for (int v = 0; v < G.V(); v++)
		{
			int degreeG = degree(G,v);
			
			if (degreeG > max)
				max = degreeG;
		}
		
		return max;
	}
	
	public static double averageDegree(Graph G)
	{
		return 2.0 * G.E() / G.V();
	}
	
	public static int numberOfSelfLoops(Graph G)
	{
		int count = 0;
		for (int v = 0; v < G.V(); v++)
		{
			for (int w : G.adj(v))
			{
				if (v == w) count++;
			}
			
		}
		
		return count/2; // Each edge counted twice
	}
	
}
