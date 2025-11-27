import java.util.Arrays;

public class Deikstra {
    static final int INF = Integer.MAX_VALUE;

    static int[][] G = {
            {0,2,5,1,0,0,7,0},
            {2,0,0,3,6,0,0,0},
            {5,0,0,0,2,4,4,0},
            {1,3,0,0,5,4,9,0},
            {0,6,2,5,0,3,0,0},
            {0,0,4,4,3,0,0,1},
            {7,0,4,9,0,0,0,6},
            {0,0,0,0,0,1,6,0}
    };

    public static void main(String[] args) {
        dijkstra(0);
    }

    static void dijkstra(int start) {
        int n = G.length;
        int[] dist = new int[n];
        int[] prev = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(dist, INF);
        Arrays.fill(prev, -1);
        dist[start] = 0;

        print("Початковий стан", dist, prev, visited);

        for (int step = 0; step < n; step++) {
            int v = -1;
            for (int i = 0; i < n; i++)
                if (!visited[i] && (v == -1 || dist[i] < dist[v]))
                    v = i;

            if (v == -1 || dist[v] == INF) break;

            visited[v] = true;

            print("Крок: вибрана вершина " + (v + 1), dist, prev, visited);

            for (int u = 0; u < n; u++) {
                if (G[v][u] > 0 && !visited[u]) {
                    int nd = dist[v] + G[v][u];
                    if (nd < dist[u]) {
                        dist[u] = nd;
                        prev[u] = v;
                    }
                }
            }

            print("Після оновлення сусідів", dist, prev, visited);
            System.out.println("------------------------------------");
        }

        print("Фінальні значення", dist, prev, visited);
    }

    static void print(String title, int[] dist, int[] prev, boolean[] visited) {
        System.out.println(title);
        System.out.println("dist    = " + format(dist));
        System.out.println("prev    = " + Arrays.toString(prev));
        System.out.println("visited = " + Arrays.toString(visited));
    }

    static String format(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i] == INF ? "∞" : arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
