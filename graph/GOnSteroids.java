package graph;

public interface GOnSteroids extends G {
    /** the degree of x */
    default int degree(int v) {
        int degree = 0;
        for (int x : adj(v))
            degree++;
        return degree;
    }

    /** maximum degree */
    default int maxDegree() {
        int max = 0;
        for (int v = 0; v < V(); v++) {
            int degreeV = degree(v);
            if (degreeV > max)
                max = degreeV;
        }
        return max;
    }

    /** average degree */
    default int avgDegree() {
        return 2 * E() / V();
    }

    default int numberOfSelfLoops() {
        int count = 0;
        for (int v = 0; v < V(); v++)
            for (int w : adj(v))
                if (v == w) count++;
        return count / 2;
    }

    default String defaultToString() {
//        String s = V() + " vertices, " + E() + " edges\n";
//        for (int v = 0; v < V(); v++) {
//            s += v + ": ";
//            for (int w : this.adj(v))
//                s += w + " ";
//            s += "\n";
//        }
//        return s;
        StringBuilder s = new StringBuilder(V() + " vertices, " + E() + " edges\n");
        for (int v = 0; v < V(); v++) {
            s.append(v).append(": ");
            for (int w : this.adj(v))
                s.append(w).append(" ");
            s.append("\n");
        }
        return s.toString();
    }
}
