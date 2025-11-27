import java.util.Arrays;

public class PrimTrace {

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
        prim(0);
    }

    static void prim(int start) {
        int n = G.length;
        int[] key = new int[n];
        int[] parent = new int[n];
        boolean[] used = new boolean[n];

        Arrays.fill(key, INF);
        Arrays.fill(parent, -1);
        key[start] = 0;

        printState("Початковий стан", key, parent, used);

        for (int i = 0; i < n; i++) {
            int v = -1;
            for (int j = 0; j < n; j++)
                if (!used[j] && (v == -1 || key[j] < key[v]))
                    v = j;

            used[v] = true;

            printState("Крок: вибрана вершина " + (v + 1), key, parent, used);

            for (int u = 0; u < n; u++) {
                if (G[v][u] > 0 && !used[u] && G[v][u] < key[u]) {
                    key[u] = G[v][u];
                    parent[u] = v;
                }
            }

            printState("Після оновлення сусідів", key, parent, used);
            System.out.println("----------------------------------");
        }

        System.out.println("Фінальні key:    " + format(key));
        System.out.println("Фінальні parent: " + Arrays.toString(parent));
    }

    static void printState(String title, int[] key, int[] parent, boolean[] used) {
        System.out.println(title);
        System.out.println("key:    " + format(key));
        System.out.println("parent: " + Arrays.toString(parent));
        System.out.println("used:   " + Arrays.toString(used));
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
