import java.util.Arrays;

public class Krusk {

    private static final int V = 8;

    private static class Edge {
        int u, v, w;
        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    private static int[] parent = new int[V + 1];

    private static int findSet(int v) {
        if (parent[v] == v) return v;
        return parent[v] = findSet(parent[v]);
    }

    private static boolean unionSets(int a, int b) {
        a = findSet(a);
        b = findSet(b);
        if (a == b) return false;
        parent[b] = a;
        return true;
    }

    public static void main(String[] args) {

        Edge[] edges = {
                new Edge(1, 2, 2),
                new Edge(1, 4, 1),
                new Edge(1, 3, 5),
                new Edge(1, 7, 7),
                new Edge(2, 4, 3),
                new Edge(2, 5, 6),
                new Edge(3, 5, 2),
                new Edge(3, 6, 4),
                new Edge(3, 7, 4),
                new Edge(4, 5, 5),
                new Edge(4, 6, 4),
                new Edge(4, 7, 9),
                new Edge(5, 6, 3),
                new Edge(6, 8, 1),
                new Edge(7, 8, 6)
        };

        for (int i = 1; i <= V; i++) parent[i] = i;

        Arrays.sort(edges, (a, b) -> Integer.compare(a.w, b.w));

        int edgesUsed = 0;
        int totalWeight = 0;

        System.out.println("Ребра МКД (Крускал):");

        for (Edge e : edges) {
            if (unionSets(e.u, e.v)) {
                System.out.printf("%d - %d : %d%n", e.u, e.v, e.w);
                totalWeight += e.w;
                edgesUsed++;
                if (edgesUsed == V - 1) break;
            }
        }

        System.out.println("Загальна вага МКД (Крускал) = " + totalWeight);
    }
}
