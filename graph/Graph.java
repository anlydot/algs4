package graph;

import std.Bag;
import std.In;
import static std.StdOut.println;

public class Graph implements GOnSteroids {
    private final int V;
    private int E;
    private final Bag<Integer>[] adj;
    @SuppressWarnings("unchecked")
    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<Integer>();
    }

    public Graph(In in) {
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
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public String toString() {
        return defaultToString();
    }

    public static void main(String[] args) {
        String file = args[0];
        In in = new In(file);
        Graph g = new Graph(in);
        println(g.toString());
    }
}