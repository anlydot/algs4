package graph;
import std.Bag;
import std.In;
public class AdjacencyMatrixGraph implements GOnSteroids {
    private boolean[][] matrix;
    private int V;
    private int E;

    public AdjacencyMatrixGraph(int V) {
        matrix = new boolean[V][];
        for (int i = 0; i < V; i++)
            matrix[i] = new boolean[V];
        this.V = V;
        this.E = 0;
    }

    public AdjacencyMatrixGraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            // Add an edge.
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return E;
    }

    @Override
    public void addEdge(int v, int w) {
        matrix[v][w] = true;
        matrix[w][v] = true;
        E++;
    }

    @Override
    public Iterable<Integer> adj(int v) {
        Bag<Integer> bag = new Bag<>();
        for (int i = 0; i < V; i++)
            if (matrix[v][i])
                bag.add(i);
        if (matrix[v][v])
            bag.add(v);
        return bag;
    }
    @Override
    public String toString() {
        return defaultToString();
    }
}