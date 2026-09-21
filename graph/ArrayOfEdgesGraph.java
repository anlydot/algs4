package graph;

import std.Bag;
import std.In;

public class ArrayOfEdgesGraph implements GOnSteroids {
    private record Edge(int v, int w) {
    }

    private Edge[] edges;
    private int V;
    private int E;

    public ArrayOfEdgesGraph(int V) {
        this.V = V;
        this.E = 0;
        edges = new Edge[V];
    }

    public ArrayOfEdgesGraph(In in) {
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
        if (edges.length == E) {
            // more size
            Edge[] newEdges = new Edge[edges.length * 2];
            for (int i = 0; i < edges.length; i++)
                newEdges[i] = edges[i];
            edges = newEdges;
        }
        E++;
        edges[E] = new Edge(v, w);
    }

    @Override
    public Iterable<Integer> adj(int v) {
        var bag = new Bag<Integer>();
        for (int i = 0; i < E; i++)
            if (edges[i].v == v)
                bag.add(v);
        return bag;
    }
}