// Download algs4 from https://algs4.cs.princeton.edu/code/algs4.jar, place in root directory of project (see Makefile for class path)
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Bag;

public class Graph {
	private final int V;		// number of vertices
	private int E;				// number of edges
	private Bag<Integer>[] adj;	// adjacency lists

    // Create a V-vertex graph with no edges.
	@SuppressWarnings("unchecked")	// For the new Bag[V] cast to Bag<Integer>[]
    public Graph (int V) 
	{
		this.V = V;
		adj = (Bag<Integer>[]) new Bag[V]; 	// Create array of lists
		for (int vert = 0; vert < V; vert++)			// Initialize all lists
		{
			adj[vert] = new Bag<Integer>();	// to empty
		}
    }

    // Create a graph from intput stream in
    public Graph (In in) 
	{
        this(in.readInt());			// Read V and construct this graph.
		int E = in.readInt();

		for (int idx = 0; idx < E; idx++)
		{	// Add an edge
			int v = in.readInt();	// Read a vertex
			int w = in.readInt(); 	// Read another vertex
			addEdge(v,w);
		}
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
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
	
	Iterable<Integer> adj(int v) 
	{
		return adj[v];
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
