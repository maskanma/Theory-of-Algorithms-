public class Prim {

    private static final int V = 8;
    private static final int INF = Integer.MAX_VALUE / 2;

    private static final int[][] G = {
            //1      2      3      4      5      6      7      8
            {INF,   INF,   2,     4,     INF,   8,     INF,   INF}, // 1
            {INF,   INF,   7,     6,     INF,   3,     6,     INF}, // 2
            {2,     7,     INF,   INF,   INF,   INF,   INF,   4  }, // 3
            {4,     6,     INF,   INF,   1,     INF,   INF,   INF}, // 4
            {INF,   INF,   INF,   1,     INF,   INF,   4,     INF}, // 5
            {8,     3,     INF,   INF,   INF,   INF,   INF,   3  }, // 6
            {INF,   6,     INF,   INF,   4,     INF,   INF,   5  }, // 7
            {INF,   INF,   4,     INF,   INF,   3,     5,     INF}  // 8
    };

    public static void main(String[] args) {

        boolean[] selected = new boolean[V];
        selected[0] = true; // start from vertex 1 (index 0)

        int edgesUsed = 0;
        int totalWeight = 0;

        System.out.println("Ребра МКД (Прім):");

        while (edgesUsed < V - 1) {
            int min = INF;
            int x = -1, y = -1;

            for (int i = 0; i < V; i++) {
                if (selected[i]) {
                    for (int j = 0; j < V; j++) {
                        if (!selected[j] && G[i][j] < min) {
                            min = G[i][j];
                            x = i;
                            y = j;
                        }
                    }
                }
            }

            System.out.printf("%d - %d : %d%n", x + 1, y + 1, G[x][y]);
            selected[y] = true;
            totalWeight += G[x][y];
            edgesUsed++;
        }

        System.out.println("Загальна вага МКД (Прім) = " + totalWeight);
    }
}
