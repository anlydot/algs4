package graph;

import std.Bag;
import std.In;

public class AdjacencyMatrixIntGraph implements GOnSteroids {
    private int[][] matrix;
    private int V;
    private int E;

    public AdjacencyMatrixIntGraph(int V) {
        matrix = new int[V][];
        for (int i = 0; i < V; i++)
            matrix[i] = new int[V];
        this.V = V;
        this.E = 0;
    }

    public AdjacencyMatrixIntGraph(In in) {
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
        matrix[v][w] += 1;
        matrix[w][v] += 1;
        E++;
    }

    @Override
    public Iterable<Integer> adj(int v) {
        Bag<Integer> bag = new Bag<>();
        for (int i = 0; i < V; i++)
            for (int j = 0; j < matrix[v][i]; j++)
                bag.add(i);
        return bag;
    }
    @Override
    public String toString() {
        return defaultToString();
    }
}