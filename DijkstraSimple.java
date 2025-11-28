import java.util.Arrays;

public class DijkstraSimple {

    static final int INF = Integer.MAX_VALUE;

    public static void dijkstra(int[][] graph, int start) {
        int n = graph.length;
        int[] dist = new int[n];
        boolean[] used = new boolean[n];
        int[] pred = new int[n];

        Arrays.fill(dist, INF);
        Arrays.fill(pred, -1);
        dist[start] = 0;

        for (int step = 0; step < n; step++) {

            int v = -1;
            for (int i = 0; i < n; i++) {
                if (!used[i] && (v == -1 || dist[i] < dist[v])) {
                    v = i;
                }
            }

            if (dist[v] == INF) break;
            used[v] = true;

            for (int u = 0; u < n; u++) {
                if (graph[v][u] > 0) {
                    if (dist[v] + graph[v][u] < dist[u]) {
                        dist[u] = dist[v] + graph[v][u];
                        pred[u] = v;
                    }
                }
            }
        }

        System.out.println("dist: " + Arrays.toString(dist));
        System.out.println("pred: " + Arrays.toString(pred));
    }

    public static void main(String[] args) {

        int[][] G = {
            {0,8,1,5,3,0,0,0},
            {8,0,0,0,6,1,0,0},
            {1,0,0,6,0,7,0,3},
            {5,0,6,0,0,0,0,0},
            {3,6,0,0,0,0,9,0},
            {0,1,7,0,0,0,3,1},
            {0,0,0,0,9,3,0,4},
            {0,0,3,0,0,1,4,0}
        };

        dijkstra(G, 0); // старт з вершини 1 (індекс 0)
    }
}
